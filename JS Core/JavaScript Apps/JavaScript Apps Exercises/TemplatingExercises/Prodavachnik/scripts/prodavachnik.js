function startApp() {
    const appKey = "kid_SkNAhNQD-";
    const appSecret = "77c163fd27554fa9bc19980453472718";
    const baseUrl = "https://baas.kinvey.com";

    const homeButton = $("#linkHome");
    const loginButton = $("#linkLogin");
    const registerButton = $("#linkRegister");
    const listAdsButton = $("#linkListAds");
    const createAdButton = $("#linkCreateAd");
    const logoutButton = $("#linkLogout");

    const homeView = $("#viewHome");
    const loginView = $("#viewLogin");
    const registerView = $("#viewRegister");
    const adsView = $("#viewAds");
    const createAdView = $("#viewCreateAd");
    const editAdView = $("#viewEditAd");

    const loginFormButton = $("#buttonLoginUser");
    const registerFormButton = $("#buttonRegisterUser");
    const createAdFormButton = $("#buttonCreateAd");
    const editAdFormButton = $("#buttonEditAd");

    const loadingBox = $("#loadingBox");
    const errorBox = $("#errorBox");

    homeButton.on("click", () => showView("home"));
    loginButton.on("click", () => showView("login"));
    registerButton.on("click", () => showView("register"));
    listAdsButton.on("click", listAdvertisements);
    createAdButton.on("click", () => showView("createAd"));

    registerFormButton.on("click", registerUser);
    loginFormButton.on("click", loginUser);
    logoutButton.on("click", logoutUser);
    createAdFormButton.on("click", createAd);

    renderMenuItems();
    showView("home");

    $(document).on({
        ajaxStart: () => loadingBox.show(),
        ajaxStop: () => loadingBox.fadeOut()
    });

    function showError(data) {
        errorBox.text(data.responseJSON.description);
        errorBox.show();
        setTimeout(() => errorBox.fadeOut(), 3000);
    }

    function renderMenuItems() {
        let username = localStorage.username;

        if (username === undefined) {
            homeButton.show();
            loginButton.show();
            registerButton.show();
            listAdsButton.hide();
            createAdButton.hide();
            logoutButton.hide();
        } else {
            homeButton.show();
            loginButton.hide();
            registerButton.hide();
            listAdsButton.show();
            createAdButton.show();
            logoutButton.show();
        }
    }

    function showView(viewName) {
        homeView.hide();
        loginView.hide();
        registerView.hide();
        adsView.hide();
        createAdView.hide();
        editAdView.hide();

        switch (viewName) {
            case "home":
                homeView.show();
                break;
            case "login":
                loginView.show();
                break;
            case "register":
                registerView.show();
                break;
            case "ads":
                adsView.show();
                break;
            case "createAd":
                createAdView.show();
                break;
            case "editAd":
                editAdView.show();
                break;
        }
    }

    function registerUser() {
        let registerForm = $("#formRegister");

        let usernameField = registerForm.find("[name='username']");
        let passwordField = registerForm.find("[name='passwd']");

        let req = {
            url: `${baseUrl}/user/${appKey}`,
            method: "POST",
            headers: {
                "Authorization": `Basic ${btoa(appKey + ":" + appSecret)}`,
                "Content-Type": "application/json"
            },
            data: JSON.stringify({
                username: usernameField.val(),
                password: passwordField.val()
            })
        };

        $.ajax(req).then(data => {
            login(usernameField, passwordField);
        }).catch(showError);
    }

    function loginUser() {
        let loginForm = $("#formLogin");

        let usernameField = loginForm.find("[name='username']");
        let passwordField = loginForm.find("[name='passwd']");

        login(usernameField, passwordField);
    }

    function login(usernameField, passwordField) {
        let username = usernameField.val();
        let password = passwordField.val();

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

        $.ajax(req).then(data => {
            localStorage.setItem("username", data.username);
            localStorage.setItem("authtoken", data._kmd.authtoken);

            renderMenuItems();
            showView("home");

            usernameField.val("");
            passwordField.val("");
        }).catch(showError);
    }

    function logoutUser() {
        let req = {
            url: `${baseUrl}/user/${appKey}/_logout`,
            method: "POST",
            headers: {"Authorization": `Kinvey ${localStorage.authtoken}`}
        };

        $.ajax(req).catch(showError);

        localStorage.removeItem("username");
        localStorage.removeItem("authtoken");

        renderMenuItems();
        showView("home");
    }

    function listAdvertisements() {
        let table = $("#ads").find("table");
        let tableChildren = table.find("tr");

        for (let i = 1; i < tableChildren.length; i++) {
            $(tableChildren[i]).detach();
        }

        let req = {
            url: `${baseUrl}/appdata/${appKey}/ads`,
            headers: {"Authorization": `Kinvey ${localStorage.authtoken}`}
        };

        $.ajax(req).then(data => {
            for (let ad of data) {
                let row = $("<tr>");
                row.append(`<td>${ad.title}</td>`);
                row.append(`<td>${ad.publisher}</td>`);
                row.append(`<td>${ad.description}</td>`);
                row.append(`<td>${ad.price}</td>`);
                row.append(`<td>${ad.date}</td>`);

                if (ad.publisher === localStorage.username) {
                    let buttonsColumn = $("<td>");
                    let deleteButton = $("<a href='#'>[Delete]</a>");
                    let editButton = $("<a href='#'>[Edit]</a>");

                    deleteButton.on("click", () => deleteAd(ad._id));
                    editButton.on("click", () => editAd(ad));

                    buttonsColumn.append([deleteButton, editButton]);
                    row.append(buttonsColumn);
                } else {
                    row.append("<td>");
                }

                table.append(row);
            }

            showView("ads");
        }).catch(showError);
    }

    function createAd() {
        let createAdForm = $("#formCreateAd");

        let titleField = createAdForm.find("[name='title']");
        let descriptionField = createAdForm.find("[name='description']");
        let datePublishedField = createAdForm.find("[name='datePublished']");
        let priceField = createAdForm.find("[name='price']");

        let title = titleField.val();
        let description = descriptionField.val();
        let date = datePublishedField.val();
        let price = Number(priceField.val());
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

        $.ajax(req).then(data => {
            listAdvertisements();

            titleField.val("");
            descriptionField.val("");
            datePublishedField.val("");
            priceField.val("");
        }).catch(showError);
    }

    function deleteAd(adId) {
        let req = {
            url: `${baseUrl}/appdata/${appKey}/ads/${adId}`,
            method: "DELETE",
            headers: {"Authorization": `Kinvey ${localStorage.authtoken}`}
        };

        $.ajax(req).then(data => {
            listAdvertisements();
        }).catch(showError)
    }

    function editAd(ad) {
        let editAdForm = $("#formEditAd");

        let titleField = editAdForm.find("[name='title']");
        let descriptionField = editAdForm.find("[name='description']");
        let dateField = editAdForm.find("[name='datePublished']");
        let priceField = editAdForm.find("[name='price']");

        let dateTokens = ad.date.split("/");
        let month = dateTokens[0];
        let day = dateTokens[1];
        let year = dateTokens[2];

        titleField.val(ad.title);
        descriptionField.val(ad.description);
        dateField.val(`${year}-${month}-${day}`);
        priceField.val(ad.price);

        showView("editAd");

        editAdFormButton.off();
        editAdFormButton.on("click", editAdOnClick);

        function editAdOnClick() {
            dateTokens = dateField.val().split("-");
            let year = dateTokens[0];
            let month = dateTokens[1];
            let day = dateTokens[2];

            let req = {
                url: `${baseUrl}/appdata/${appKey}/ads/${ad._id}`,
                method: "PUT",
                headers: {
                    "Authorization": `Kinvey ${localStorage.authtoken}`,
                    "Content-Type": "application/json"
                },
                data: JSON.stringify({
                    "title": titleField.val(),
                    "description": descriptionField.val(),
                    "date": `${month}/${day}/${year}`,
                    "price": Number(priceField.val()),
                    "publisher": localStorage.username
                })
            };

            $.ajax(req).then((data) => {
                listAdvertisements();
            }).catch(showError);
        }
    }
}