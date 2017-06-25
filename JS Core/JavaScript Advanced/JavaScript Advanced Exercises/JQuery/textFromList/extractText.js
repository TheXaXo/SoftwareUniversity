function extractText() {
    let items = [];
    $('li').each((index, element) => items.push(element.textContent));
    $('#result').text(items.join(", "));
}