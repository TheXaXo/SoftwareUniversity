function domSearch(selector, isCaseSensitive) {
    let textDiv = $('<div class="add-controls"></div>');
    let textLabel = $('<label>Enter text:</label>');
    let textInput = $('<input type="text">');
    let textAnchor = $('<a class="button" href="#">Add</a>');
    textAnchor.on('click', addItem);

    let searchDiv = $('<div class="search-controls"></div>');
    let searchLabel = $('<label>Search:</label>');
    let searchInput = $('<input type="text">');
    searchInput.on('input', search);

    let resultDiv = $('<div class="result-controls"></div>');
    let resultList = $('<ul class="items-list"></ul>');

    $(selector)
        .append(textDiv
            .append(textLabel)
            .append(textInput)
            .append(textAnchor))
        .append(searchDiv
            .append(searchLabel)
            .append(searchInput))
        .append(resultDiv
            .append(resultList));

    function addItem() {
        let deleteButton = $('<a class="button" href="#">X</a>');
        deleteButton.on('click', deleteItem);
        let listItem = $('<li class="list-item"></li>');

        listItem
            .append(deleteButton)
            .append($(`<strong>${textInput.val()}</strong>`));

        resultList.append(listItem);
    }

    function deleteItem() {
        $(this).parent().remove();
    }

    function search() {
        let searchValue = searchInput.val();
        let allListItems = $('li');

        if (searchValue === "") {
            allListItems.show();
        } else {
            for (let listItem of allListItems) {
                let itemText = $(listItem).children('strong').text();

                if (!isCaseSensitive || isCaseSensitive === undefined) {
                    itemText = itemText.toLowerCase();
                    searchValue = searchValue.toLowerCase();
                }

                if (itemText.indexOf(searchValue) >= 0) {
                    $(listItem).show();
                } else {
                    $(listItem).hide();
                }
            }
        }
    }
}