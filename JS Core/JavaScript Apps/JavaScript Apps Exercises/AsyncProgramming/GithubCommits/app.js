function loadCommits() {
    let usernameField = $("#username");
    let repoField = $("#repo");
    let commitsList = $("#commits");

    $.ajax({
        url: `https://api.github.com/repos/${usernameField.val()}/${repoField.val()}/commits`
    })
        .then(displayCommits)
        .catch(displayError);

    function displayCommits(data) {
        commitsList.empty();

        for (let commit of data) {
            commitsList.append(`<li>${commit.commit.author.name}: ${commit.commit.message}</li>`);
        }
    }

    function displayError(error) {
        commitsList.empty();
        commitsList.append(`<li>Error: ${error.status} (${error.statusText})</li>`);
    }
}