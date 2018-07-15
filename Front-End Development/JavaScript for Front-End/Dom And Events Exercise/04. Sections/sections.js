function create(sentences) {
    let contentDiv = document.getElementById('content');

    for (let sentence of sentences) {
        let section = document.createElement('div');

        let paragraph = document.createElement('p');
        paragraph.textContent = sentence;
        paragraph.style.display = 'none';

        section.appendChild(paragraph);
        contentDiv.appendChild(section);

        section.addEventListener('click', onClick);
    }

    function onClick(e) {
        let paragraph = e.target.firstChild;
        paragraph.style.display = 'block';
    }
}