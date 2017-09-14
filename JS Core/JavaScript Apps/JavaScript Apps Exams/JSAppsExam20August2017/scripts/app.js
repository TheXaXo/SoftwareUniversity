$(() => {
    const app = Sammy("#main", function () {
        this.use("Handlebars", "hbs");

        this.get("#/", function (ctx) {
            displayWelcome(ctx);
        });

        this.get("index.html", function (ctx) {
            displayWelcome(ctx);
        });

        this.post("#/register", function (ctx) {
            handleRegister(ctx);
        });

        this.post("#/login", function (ctx) {
            handleLogin(ctx);
        });

        this.get("#/logout", function (ctx) {
            handleLogout(ctx);
        });

        this.get("#/catalog", function (ctx) {
            displayCatalog(ctx);
        });

        this.get("#/submit", function (ctx) {
            displayPostSubmit(ctx);
        });

        this.post("#/submit", function (ctx) {
            handlePostSubmit(ctx);
        });

        this.get("#/edit/:id", function (ctx) {
            displayPostEdit(ctx);
        });

        this.post("#/edit/:id", function (ctx) {
            handlePostEdit(ctx);
        });

        this.get("#/delete/:id", function (ctx) {
            handleDeletePost(ctx);
        });

        this.get("#/posts", function (ctx) {
            displayUserPosts(ctx);
        });

        this.get("#/comments/:id", function (ctx) {
            displayPostComments(ctx);
        });

        this.post("#/comment/create/:id", function (ctx) {
            handleCreateComment(ctx);
        });

        this.get("#/comment/delete/:id", function (ctx) {
            handleDeleteComment(ctx);
        })
    });

    function getCommonElements(ctx) {
        let loggedIn = auth.isAuthed();
        let partialsObject = {
            "header": "templates/common/header.hbs",
            "footer": "templates/common/footer.hbs"
        };

        if (loggedIn) {
            ctx.loggedIn = true;
            ctx.username = sessionStorage.getItem("username");
            partialsObject["navigation"] = "templates/common/navigation.hbs";
        }

        return partialsObject;
    }

    function displayWelcome(ctx) {
        if (auth.isAuthed()) {
            ctx.redirect("#/catalog");
            return;
        }

        let partialsObject = getCommonElements(ctx);
        partialsObject["content"] = "templates/welcome/welcome.hbs";

        ctx.loadPartials(partialsObject).then(function () {
            this.partial("templates/common/main.hbs");
        });
    }

    function handleRegister(ctx) {
        let username = ctx.params.username;
        let password = ctx.params.password;
        let confirmPassword = ctx.params.repeatPass;

        if (!isValidUsername(username)) {
            return;
        }

        if (password !== confirmPassword) {
            notifications.showError("Passwords do not match.");
            return;
        }

        if (!isValidPassword(password)) {
            return;
        }

        auth.register(username, password).then(function (data) {
            auth.saveSession(data);
            notifications.showInfo("User registration successful.");
            ctx.redirect("#/catalog");
        }).catch(notifications.handleError);
    }

    function handleLogin(ctx) {
        let username = ctx.params.username;
        let password = ctx.params.password;

        if (!isValidUsername(username)) {
            return;
        }

        if (!isValidPassword(password)) {
            return;
        }

        auth.login(username, password).then(function (data) {
            auth.saveSession(data);
            notifications.showInfo("Login successful.");
            ctx.redirect("#/catalog");
        }).catch(notifications.handleError);
    }

    function handleLogout(ctx) {
        auth.logout().then(function () {
            notifications.showInfo("Logout successful.");
            sessionStorage.clear();
            ctx.redirect("#/");
        }).catch(notifications.handleError);
    }

    function displayCatalog(ctx) {
        postsService.loadPosts().then(function (data) {
            let partialsObject = getCommonElements(ctx);
            partialsObject["post"] = "templates/post/post.hbs";
            partialsObject["content"] = "templates/catalog/catalog.hbs";

            let postRank = 1;

            for (let post of data) {
                if (post.author === sessionStorage.getItem("username")) {
                    post.postIsMadeByLoggedInUser = true;
                }

                post.creationInfo = calcTime(post._kmd.ect);
                post.rank = postRank++;
            }

            ctx.posts = data;

            ctx.loadPartials(partialsObject).then(function () {
                this.partial("templates/common/main.hbs");
            });
        }).catch(notifications.handleError);
    }

    function displayPostSubmit(ctx) {
        let partialsObject = getCommonElements(ctx);
        partialsObject["content"] = "templates/post/submit.hbs";

        ctx.loadPartials(partialsObject).then(function () {
            this.partial("templates/common/main.hbs");
        })
    }

    function handlePostSubmit(ctx) {
        let author = sessionStorage.getItem("username");
        let url = escapeHTMLChars(ctx.params.url);
        let title = escapeHTMLChars(ctx.params.title);
        let imageUrl = escapeHTMLChars(ctx.params.image);
        let description = escapeHTMLChars(ctx.params.comment);

        if (!isValidUrl(url)) {
            return;
        }

        if (!isValidTitle(title)) {
            return;
        }

        postsService.createPost(author, url, title, imageUrl, description).then(function () {
            notifications.showInfo("Post created.");
            ctx.redirect("#/catalog");
        }).catch(notifications.handleError);
    }

    function displayPostEdit(ctx) {
        let id = ctx.params.id;

        postsService.loadPostDetails(id).then(function (data) {
            ctx.id = data._id;
            ctx.url = data.url;
            ctx.title = data.title;
            ctx.imageUrl = data.imageUrl;
            ctx.description = data.description;

            let partialsObject = getCommonElements(ctx);
            partialsObject["content"] = "templates/post/edit.hbs";

            ctx.loadPartials(partialsObject).then(function () {
                this.partial("templates/common/main.hbs");
            })
        })
    }

    function handlePostEdit(ctx) {
        let id = ctx.params.id;

        let url = escapeHTMLChars(ctx.params.url);
        let title = escapeHTMLChars(ctx.params.title);
        let imageUrl = escapeHTMLChars(ctx.params.image);
        let description = escapeHTMLChars(ctx.params.description);

        if (!isValidUrl(url)) {
            return;
        }

        if (!isValidTitle(title)) {
            return;
        }

        postsService.edit(id, url, title, imageUrl, description).then(function (data) {
            notifications.showInfo(`Post ${data.title} updated.`);
            ctx.redirect("#/catalog");
        }).catch(notifications.handleError);
    }

    function handleDeletePost(ctx) {
        let id = ctx.params.id;

        postsService.remove(id).then(function () {
            notifications.showInfo("Post deleted.");
            ctx.redirect("#/catalog");
        }).catch(notifications.handleError);
    }

    function displayUserPosts(ctx) {
        postsService.loadUserPosts().then(function (data) {
            let partialsObject = getCommonElements(ctx);
            partialsObject["post"] = "templates/post/post.hbs";
            partialsObject["content"] = "templates/post/userPosts.hbs";

            let postRank = 1;

            for (let post of data) {
                post.postIsMadeByLoggedInUser = true;
                post.creationInfo = calcTime(post._kmd.ect);
                post.rank = postRank++;
            }

            ctx.posts = data;

            ctx.loadPartials(partialsObject).then(function () {
                this.partial("templates/common/main.hbs");
            });
        }).catch(notifications.handleError);
    }

    function displayPostComments(ctx) {
        let id = ctx.params.id;

        let partialsObject = getCommonElements(ctx);
        partialsObject["content"] = "templates/post/postComments.hbs";
        partialsObject["comment"] = "templates/comment/comment.hbs";

        postsService.loadPostDetails(id).then(function (data) {
            ctx.id = id;
            ctx.url = data.url;
            ctx.title = data.title;
            ctx.imageUrl = data.imageUrl;
            ctx.creationInfo = calcTime(data._kmd.ect);
            ctx.author = data.author;

            if (data.author === sessionStorage.getItem("username")) {
                ctx.postIsMadeByLoggedInUser = true;
            }

            if (data.description === "") {
                ctx.description = "No description.";
            } else {
                ctx.description = data.description;
            }

            postsService.loadPostComments(id).then(function (data) {
                for (let comment of data) {
                    if (comment.author === sessionStorage.getItem("username")) {
                        comment.commentIsMadeByLoggedInUser = true;
                    }

                    comment.creationInfo = calcTime(comment._kmd.ect);
                }

                ctx.comments = data;

                ctx.loadPartials(partialsObject).then(function () {
                    this.partial("templates/common/main.hbs");
                })
            }).catch(notifications.handleError);
        }).catch(notifications.handleError);
    }

    function handleCreateComment(ctx) {
        let postId = ctx.params.id;
        let content = escapeHTMLChars(ctx.params.content);

        postsService.createComment(postId, content).then(function () {
            notifications.showInfo("Comment created.");
            ctx.redirect(`#/comments/${postId}`);
        }).catch(notifications.handleError);
    }

    function handleDeleteComment(ctx) {
        let commentId = ctx.params.id;

        postsService.getCommentDetails(commentId).then(function (data) {
            let postId = data.postId;

            postsService.deleteComment(commentId).then(function () {
                notifications.showInfo("Comment deleted.");
                ctx.redirect(`#/comments/${postId}`);
            }).catch(notifications.handleError);
        }).catch(notifications.handleError);
    }

    function isValidUsername(username) {
        let usernamePattern = /^[A-Za-z]{3,}$/g;

        if (!usernamePattern.test(username)) {
            notifications.showError("Username should be at least 3 characters long and should contain only english alphabet letters.");
            return false;
        }

        return true;
    }

    function isValidPassword(password) {
        let passwordPattern = /^[A-Za-z0-9]{6,}$/g;

        if (!passwordPattern.test(password)) {
            notifications.showError("Password should be at least 6 characters long and should contain only english alphabet letters and digits.");
            return false;
        }

        return true;
    }

    function isValidUrl(url) {
        if (url === "") {
            notifications.showError("URL should not be empty.");
            return false;
        }

        if (!url.startsWith("http")) {
            notifications.showError("URL should start with 'http'.");
            return false;
        }

        return true;
    }

    function isValidTitle(title) {
        if (title === "") {
            notifications.showError("Title should not be empty.");
            return false;
        }

        return true;
    }

    function calcTime(dateIsoFormat) {
        let diff = new Date - (new Date(dateIsoFormat));
        diff = Math.floor(diff / 60000);
        if (diff < 1) return 'less than a minute';
        if (diff < 60) return diff + ' minute' + pluralize(diff);
        diff = Math.floor(diff / 60);
        if (diff < 24) return diff + ' hour' + pluralize(diff);
        diff = Math.floor(diff / 24);
        if (diff < 30) return diff + ' day' + pluralize(diff);
        diff = Math.floor(diff / 30);
        if (diff < 12) return diff + ' month' + pluralize(diff);
        diff = Math.floor(diff / 12);
        return diff + ' year' + pluralize(diff);

        function pluralize(value) {
            if (value !== 1) return 's';
            else return '';
        }
    }

    function escapeHTMLChars(text) {
        return text
            .replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;")
            .replace(/"/g, "&quot;")
            .replace(/'/g, "&#039;");
    }

    app.run();
});