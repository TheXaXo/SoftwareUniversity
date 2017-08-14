$(() => {
    const appKey = "kid_SkNAhNQD-";
    const appSecret = "77c163fd27554fa9bc19980453472718";
    const baseUrl = "https://baas.kinvey.com";

    const app = Sammy("#main", function () {
        this.use("Handlebars", "hbs");

        this.get("index.html", function (ctx) {
            displayHome(ctx);
        });

        this.get("#/home", function (ctx) {
            displayHome(ctx);
        });

        this.get("#/login", function (ctx) {
            ctx.isLogged = localStorage.username !== undefined;

            ctx.loadPartials({
                header: "templates/header.hbs"
            }).then(function () {
                this.partial("templates/login.hbs");
            });
        });

        this.post("#/login", function () {
            let username = this.params.username;
            let password = this.params.passwd;

            login(username, password).then(data => {
                localStorage.setItem("username", data.username);
                localStorage.setItem("authtoken", data._kmd.authtoken);

                this.redirect("#/home");
            }).catch(showError);
        });

        this.get("#/logout", function () {
            logoutUser().then(() => {
                localStorage.clear();
                this.redirect("#/home");
            })
        });

        this.get("#/register", function (ctx) {
            ctx.isLogged = localStorage.username !== undefined;

            ctx.loadPartials({
                header: "templates/header.hbs"
            }).then(function () {
                this.partial("templates/register.hbs");
            })
        });

        this.post("#/register", function (ctx) {
            let username = ctx.params.username;
            let password = ctx.params.passwd;

            let req = {
                url: `${baseUrl}/user/${appKey}`,
                method: "POST",
                headers: {
                    "Authorization": `Basic ${btoa(appKey + ":" + appSecret)}`,
                    "Content-Type": "application/json"
                },
                data: JSON.stringify({
                    username,
                    password
                })
            };

            $.ajax(req).then(data => {
                login(username, password).then(function () {
                    localStorage.setItem("username", data.username);
                    localStorage.setItem("authtoken", data._kmd.authtoken);

                    ctx.redirect("#/home");
                });
            }).catch(showError);
        });

        this.get("#/ads", function (ctx) {
            ctx.isLogged = localStorage.username !== undefined;

            loadAdvertisements().then(data => {
                for (let adToCheck of data) {
                    if (adToCheck.publisher === localStorage.username) {
                        adToCheck.isPublishedByCurrentUser = true;
                    }
                }

                ctx.ads = data;

                ctx.loadPartials({
                    header: "templates/header.hbs",
                    ad: "templates/ad.hbs"
                }).then(function () {
                    this.partial("templates/ads.hbs");
                })
            });
        });

        this.get("#/createAd", function (ctx) {
            ctx.isLogged = localStorage.username !== undefined;

            ctx.loadPartials({
                header: "templates/header.hbs"
            }).then(function () {
                this.partial("templates/adCreate.hbs");
            })
        });

        this.post("#/createAd", function (ctx) {
            createAd(ctx).then(function () {
                ctx.redirect("#/ads");
            }).catch(showError);
        });

        this.get("#/delete/:id", function (ctx) {
            deleteAd(ctx.params.id).then(function () {
                ctx.redirect("#/ads");
            }).catch(showError);
        });

        this.get("#/edit/:id", function (ctx) {
            ctx.isLogged = localStorage.username !== undefined;
            let id = ctx.params.id;

            let req = {
                url: `${baseUrl}/appdata/${appKey}/ads/${id}`,
                headers: {"Authorization": `Kinvey ${localStorage.authtoken}`}
            };

            $.ajax(req).then(data => {
                ctx.title = data.title;
                ctx.description = data.description;
                ctx.price = data.price;
                ctx.id = data._id;

                let dateTokens = data.date.split("/");
                let month = dateTokens[0];
                let day = dateTokens[1];
                let year = dateTokens[2];

                ctx.date = `${year}-${month}-${day}`;

                ctx.loadPartials({
                    header: "templates/header.hbs"
                }).then(function () {
                    this.partial("templates/editAd.hbs");
                })
            });
        });

        this.post("#/edit/:id", function (ctx) {
            let dateTokens = ctx.params.datePublished.split("-");
            let year = dateTokens[0];
            let month = dateTokens[1];
            let day = dateTokens[2];

            let req = {
                url: `${baseUrl}/appdata/${appKey}/ads/${ctx.params.id}`,
                method: "PUT",
                headers: {
                    "Authorization": `Kinvey ${localStorage.authtoken}`,
                    "Content-Type": "application/json"
                },
                data: JSON.stringify({
                    "title": ctx.params.title,
                    "description": ctx.params.description,
                    "date": `${month}/${day}/${year}`,
                    "price": Number(ctx.params.price),
                    "publisher": localStorage.username
                })
            };

            $.ajax(req).then((data) => {
                ctx.redirect("#/ads");
            }).catch(showError);
        });
    });

    app.run();

    const loadingBox = $("#loadingBox");
    const errorBox = $("#errorBox");

    $(document).on({
        ajaxStart: () => loadingBox.show(),
        ajaxStop: () => loadingBox.fadeOut()
    });

    function showError(data) {
        errorBox.text(data.responseJSON.description);
        errorBox.show();
        setTimeout(() => errorBox.fadeOut(), 3000);
    }

    function login(username, password) {
        let req = {
            url: `${baseUrl}/user/${appKey}/login`,
            method: "POST",
            headers: {
                "Authorization": `Basic ${btoa(appKey + ":" + appSecret)}`,
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                username,
                password
            })
        };

        return $.ajax(req);
    }

    function logoutUser() {
        let req = {
            url: `${baseUrl}/user/${appKey}/_logout`,
            method: "POST",
            headers: {"Authorization": `Kinvey ${localStorage.authtoken}`}
        };

        return $.ajax(req);
    }

    function displayHome(ctx) {
        ctx.isLogged = localStorage.username !== undefined;

        ctx.loadPartials({
            header: "templates/header.hbs"
        }).then(function () {
            this.partial("templates/home.hbs")
        });
    }

    function loadAdvertisements() {
        let req = {
            url: `${baseUrl}/appdata/${appKey}/ads`,
            headers: {"Authorization": `Kinvey ${localStorage.authtoken}`}
        };

        return $.ajax(req);
    }

    function createAd(ctx) {
        let title = ctx.params.title;
        let description = ctx.params.description;
        let date = ctx.params.datePublished;
        let price = Number(ctx.params.price);
        let publisher = localStorage.username;

        let dateTokens = date.split("-");
        let year = dateTokens[0];
        let month = dateTokens[1];
        let day = dateTokens[2];

        date = `${month}/${day}/${year}`;

        let req = {
            url: `${baseUrl}/appdata/${appKey}/ads`,
            method: "POST",
            headers: {
                "Authorization": `Kinvey ${localStorage.authtoken}`,
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                title,
                description,
                date,
                price,
                publisher
            })
        };

        return $.ajax(req);
    }

    function deleteAd(adId) {
        let req = {
            url: `${baseUrl}/appdata/${appKey}/ads/${adId}`,
            method: "DELETE",
            headers: {"Authorization": `Kinvey ${localStorage.authtoken}`}
        };

        return $.ajax(req);
    }
});