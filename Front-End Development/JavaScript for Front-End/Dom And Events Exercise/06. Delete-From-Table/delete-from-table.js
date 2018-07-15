function deleteByEmail() {
    let resultDiv = document.getElementById('result');
    resultDiv.textContent = '';

    let emailInput = document.getElementsByName('email')[0];
    let emailColumns = document.querySelectorAll('#customers tr td:nth-of-type(2)');

    let isMissing = true;

    for (let emailColumn of emailColumns) {
        if (emailColumn.textContent === emailInput.value) {
            isMissing = false;

            let row = emailColumn.parentNode;
            row.parentNode.removeChild(row);
            break;
        }
    }

    if (isMissing) {
        resultDiv.textContent = 'Not found.'
    } else {
        resultDiv.textContent = 'deleted.'
    }
}