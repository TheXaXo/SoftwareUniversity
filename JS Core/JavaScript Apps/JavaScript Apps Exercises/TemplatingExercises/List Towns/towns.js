function attachEvents() {
    $('#btnLoadTowns').on("click", renderTowns);
    const townsInputField = $('#towns');
    const rootDiv = $("#root");

    function renderTowns() {
        let towns = townsInputField.val().split(", ");

        if (towns.length === 0) {
            return;
        }

        townsInputField.val("");
        rootDiv.html("");

        for (let town of towns) {
            rootDiv.html(rootDiv.html() + template({townName: town}));
        }
    }

    let html = $('#towns-template').html();
    let template = Handlebars.compile(html);
}