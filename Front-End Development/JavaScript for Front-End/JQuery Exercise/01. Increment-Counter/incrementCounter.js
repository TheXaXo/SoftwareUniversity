function increment(selector) {
    let textArea = $('<textarea>', {class: 'counter', text: 0, disabled: 'disabled'});
    let incrementButton = $('<button>', {class: 'btn', id: 'incrementBtn', text: 'Increment'});
    let addButton = $('<button>', {class: 'btn', id: 'addBtn', text: 'Add'});
    let list = $('<ul>', {class: 'results'});

    incrementButton.on('click', incrementValue);
    addButton.on('click', addValue);

    function incrementValue() {
        textArea.val(Number(textArea.val()) + 1);
    }

    function addValue() {
        let listItem = $('<li>', {text: textArea.val()});
        list.append(listItem);
    }

    $(selector).append(textArea, incrementButton, addButton, list);
}