$(() => {
    const app = Sammy('#main', function () {
        this.use("Handlebars", "hbs");

        this.get("index.html", function (ctx) {
            displayHome(ctx)
        });

        this.get("#/home", function (ctx) {
            displayHome(ctx);
        });

        this.get("#/login", function (ctx) {
            displayLoginPage(ctx);
        });

        this.post("#/login", function (ctx) {
            handleLogin(ctx);
        });

        this.get("#/register", function (ctx) {
            displayRegister(ctx);
        });

        this.post("#/register", function (ctx) {
            handleRegister(ctx);
        });

        this.get("#/logout", function (ctx) {
            handleLogout(ctx);
        });

        this.get("#/about", function (ctx) {
            displayAbout(ctx);
        });

        this.get("#/catalog", function (ctx) {
            displayCatalog(ctx);
        });

        this.get("#/catalog/:id", function (ctx) {
            displayTeamDetails(ctx);
        });

        this.get("#/join/:id", function (ctx) {
            handleJoinTeam(ctx);
        });

        this.get("#/leave", function (ctx) {
            handleLeaveTeam(ctx);
        });

        this.get("#/create", function (ctx) {
            displayCreateTeam(ctx);
        });

        this.post("#/create", function (ctx) {
            handleCreateTeam(ctx);
        });

        this.get("#/edit/:id", function (ctx) {
            displayEditTeam(ctx);
        });

        this.post("#/edit/:id", function (ctx) {
            handleEditTeam(ctx);
        })
    });

    app.run();

    $(document).on({
        ajaxStart: () => auth.showInfo("Loading..."),
        ajaxStop: () => $("#infoBox").hide()
    });

    function displayHome(ctx) {
        ctx.loadPartials(getHeaderAndFooter(ctx)).then(function () {
                this.partial("templates/home/home.hbs");
            }
        );
    }

    function getHeaderAndFooter(ctx) {
        let username = sessionStorage.getItem("username");
        let loggedIn = username !== null;

        if (loggedIn) {
            ctx.loggedIn = loggedIn;
            ctx.username = username;
        }

        return {
            header: "templates/common/header.hbs",
            footer: "templates/common/footer.hbs"
        };
    }

    function displayLoginPage(ctx) {
        let partialsObject = getHeaderAndFooter(ctx);
        partialsObject["loginForm"] = "templates/login/loginForm.hbs";

        ctx.loadPartials(partialsObject).then(function () {
            this.partial("templates/login/loginPage.hbs");
        });
    }

    function handleLogin(ctx) {
        let username = ctx.params.username;
        let password = ctx.params.password;

        auth.login(username, password).then(function (data) {
            auth.saveSession(data);
            ctx.redirect("#/home");
        }).catch(auth.handleError);

    }

    function displayRegister(ctx) {
        let partialsObject = getHeaderAndFooter(ctx);
        partialsObject["registerForm"] = "templates/register/registerForm.hbs";

        ctx.loadPartials(partialsObject).then(function () {
            this.partial("templates/register/registerPage.hbs");
        });
    }

    function handleRegister(ctx) {
        let username = ctx.params.username;
        let password = ctx.params.password;
        let passwordRepeat = ctx.params.repeatPassword;

        if (password !== passwordRepeat) {
            auth.showError("Passwords do not match.");
            return;
        }

        auth.register(username, password).then(function (data) {
            auth.saveSession(data);
            ctx.redirect("#/home");
        }).catch(auth.handleError);
    }

    function handleLogout(ctx) {
        auth.logout().then(function () {
            sessionStorage.clear();
            ctx.redirect("#/home");
        }).catch(auth.handleError);
    }

    function displayAbout(ctx) {
        ctx.loadPartials(getHeaderAndFooter(ctx)).then(function () {
            this.partial("templates/about/about.hbs");
        })
    }

    function displayCatalog(ctx) {
        let partialsObject = getHeaderAndFooter(ctx);
        partialsObject["team"] = "templates/catalog/team.hbs";

        teamsService.loadTeams().then(function (data) {
            ctx.teams = data;
            ctx.hasNoTeam = sessionStorage.teamId === "";

            ctx.loadPartials(partialsObject).then(function () {
                this.partial("templates/catalog/teamCatalog.hbs");
            });
        }).catch(auth.handleError);
    }

    function displayTeamDetails(ctx) {
        let id = ctx.params.id.substring(1);

        let partialsObject = getHeaderAndFooter(ctx);
        partialsObject["teamMember"] = "templates/catalog/teamMember.hbs";
        partialsObject["teamControls"] = "templates/catalog/teamControls.hbs";

        teamsService.loadTeamDetails(id).then(function (data) {
            ctx.name = data.name;
            ctx.teamId = id;
            let comment = data.comment;

            if (comment) {
                ctx.comment = comment;
            }

            if (data._acl.creator === sessionStorage.userId) {
                ctx.isAuthor = true;
            }

            if (sessionStorage.teamId === id) {
                ctx.isOnTeam = true;
            }

            ctx.loadPartials(partialsObject).then(function () {
                this.partial("templates/catalog/details.hbs");
            });
        }).catch(auth.handleError);
    }

    function handleJoinTeam(ctx) {
        let id = ctx.params.id.substring(1);

        teamsService.joinTeam(id).then(function () {
            sessionStorage.teamId = id;
            ctx.redirect(`#/catalog/:${id}`);
        });
    }

    function handleLeaveTeam(ctx) {
        teamsService.leaveTeam().then(function () {
            sessionStorage.teamId = "";
            ctx.redirect("#/catalog");
        }).catch(auth.handleError);
    }

    function displayCreateTeam(ctx) {
        let partialsObject = getHeaderAndFooter(ctx);
        partialsObject["createForm"] = "templates/create/createForm.hbs";

        ctx.loadPartials(partialsObject).then(function () {
            this.partial("templates/create/createPage.hbs");
        });
    }

    function handleCreateTeam(ctx) {
        let name = ctx.params.name;
        let comment = ctx.params.comment;

        teamsService.createTeam(name, comment).then(function (data) {
            let id = data._id;

            teamsService.joinTeam(id).then(function () {
                sessionStorage.teamId = id;
                ctx.redirect(`#/catalog/:${id}`);
            }).catch(auth.handleError);
        }).catch(auth.handleError);
    }

    function displayEditTeam(ctx) {
        let id = ctx.params.id.substring(1);

        let partialsObject = getHeaderAndFooter(ctx);
        partialsObject["editForm"] = "templates/edit/editForm.hbs";

        teamsService.loadTeamDetails(id).then(function (data) {
            ctx.name = data.name;
            ctx.comment = data.comment;
            ctx.teamId = id;

            ctx.loadPartials(partialsObject).then(function () {
                this.partial("templates/edit/editPage.hbs");
            })
        }).catch(auth.handleError);
    }

    function handleEditTeam(ctx) {
        let id = ctx.params.id.substring(1);

        let name = ctx.params.name;
        let comment = ctx.params.comment;

        teamsService.edit(id, name, comment).then(function (data) {
            ctx.redirect(`#/catalog/:${id}`);
        }).catch(auth.handleError);
    }
});