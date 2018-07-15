function addItem() {
    let textInput = document.getElementById('newItemText');
    let valueInput = document.getElementById('newItemValue');

    let select = document.getElementById('menu');

    let option = document.createElement('option');
    option.text = textInput.value;
    option.value = valueInput.value;

    select.add(option);

    textInput.value = '';
    valueInput.value = '';
}