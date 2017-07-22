function solution() {
    function listBuilder(selector) {
        return {
            createNewList() {
                $(selector).empty();
                $(selector).append($('<ul></ul>'));
            },

            addItem(itemName) {
                let listItem = $('<li>');
                listItem.text(itemName);

                let upButton = $('<button>Up</button>');
                let downButton = $('<button>Down</button>');

                upButton.on('click', function () {
                    $(this).parent().insertBefore($(this).parent().prev());
                });

                downButton.on('click', function () {
                    $(this).parent().insertAfter($(this).parent().next());
                });

                listItem.append(upButton);
                listItem.append(downButton);

                $('ul').append(listItem);
            }
        }
    }

    let builder = listBuilder("#main");
    builder.createNewList();
    builder.addItem("Sofia");
    builder.addItem("Varna");
    builder.addItem("Sofia <new>");
    builder.addItem("Pleven");
}