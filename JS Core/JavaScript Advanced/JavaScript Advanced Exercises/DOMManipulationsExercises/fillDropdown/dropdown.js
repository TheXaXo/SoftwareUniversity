function addItem() {
    let textField = document.getElementById('newItemText');
    let valueField = document.getElementById('newItemValue');

    let text = textField.value;
    let value = valueField.value;
    textField.value = '';
    valueField.value = '';

    let optionElement = document.createElement('option');
    optionElement.value = value;
    optionElement.textContent = text;

    document.getElementById('menu').appendChild(optionElement);
}