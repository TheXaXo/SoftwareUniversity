function toggle() {
    let button = document.querySelector('.button');
    let textDiv = document.getElementById('extra');

    if (button.textContent === 'More') {
        button.textContent = 'Less';
        textDiv.style.display = 'block';
    } else {
        button.textContent = 'More';
        textDiv.style.display = 'none';
    }
}