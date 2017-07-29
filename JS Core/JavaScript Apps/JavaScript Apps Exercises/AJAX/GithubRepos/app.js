function loadRepos() {
    let usernameField = $('#username');

    let req = {
        url: `https://api.github.com/users/${usernameField.val()}/repos`,
        success: onSuccess,
        error: onError
    };

    $.ajax(req);

    function onSuccess(data) {
        let list = $('#repos');
        list.empty();

        for (let repo of data) {
            list.append(`<li><a href="${repo.html_url}" target="_blank">${repo.full_name}</a></li>`)
        }
    }

    function onError() {
        let list = $('#repos');
        list.empty();
        list.append("<li>Error</li>");
    }
}