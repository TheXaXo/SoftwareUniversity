(function createBook() {
    let id = 1;

    return function (selector, title, author, ISBN) {
        let div = $(`<div id="${"book" + id++}" style="border: medium none">`);
        let titleElement = $(`<p class="title">${title}</p>`);
        let authorElement = $(`<p class="author">${author}</p>`);
        let ISBNElement = $(`<p class="isbn">${ISBN}</p>`);
        let selectButton = $('<button>Select</button>').on('click', select);
        let deselectButton = $('<button>Deselect</button>').on('click', deselect);

        $(selector).append(
            div
                .append(titleElement)
                .append(authorElement)
                .append(ISBNElement)
                .append(selectButton)
                .append(deselectButton)
        );

        function select() {
            $(this).parent().css("border", "2px solid blue");
        }

        function deselect() {
            $(this).parent().css("border", "none");
        }
    }
}());