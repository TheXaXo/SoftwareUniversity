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

    const loginFormButton = $("#buttonLoginUser");
    const registerFormButton = $("#buttonRegisterUser");

    homeButton.on("click", () => showView("home"));
    loginButton.on("click", () => showView("login"));
    registerButton.on("click", () => showView("register"));
    listAdsButton.on("click", () => showView("ads"));
    createAdButton.on("click", () => showView("createAd"));

    registerFormButton.on("click", registerUser);
    loginFormButton.on("click", loginUser);
    logoutButton.on("click", logoutUser);

    renderMenuItems();
    showView("home");

    function renderMenuItems() {
        let username = localStorage.username;
        console.log(username);

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
            login(usernameField.val(), passwordField.val());
        });
    }

    function loginUser() {
        let loginForm = $("#formLogin");

        let usernameField = loginForm.find("[name='username']");
        let passwordField = loginForm.find("[name='passwd']");

        login(usernameField.val(), passwordField.val());

        usernameField.val("");
        passwordField.val("");
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

        $.ajax(req).then(data => {
            localStorage.setItem("username", data.username);
            localStorage.setItem("authtoken", data._kmd.authtoken);

            renderMenuItems();
            showView("home");
        });
    }

    function logoutUser() {
        localStorage.removeItem("username");
        localStorage.removeItem("authtoken");

        renderMenuItems();
        showView("home");
    }
}