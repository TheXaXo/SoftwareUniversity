function attachEvents() {
    $('#items li').click(select);
    $('#showTownsButton').click(showTowns);

    function select() {
        let item = $(this);

        if (item.attr("data-selected")) {
            item.css("background-color", "");
            item.removeAttr("data-selected");
        } else {
            item.css("background-color", "#DDD");
            item.attr("data-selected", true);
        }
    }

    function showTowns() {
        let allSelected = $('li[data-selected=true]');
        let towns = [...allSelected].map(a => a.textContent);

        $('#selectedTowns').text(`Selected towns: ${towns.join(", ")}`);
    }
}