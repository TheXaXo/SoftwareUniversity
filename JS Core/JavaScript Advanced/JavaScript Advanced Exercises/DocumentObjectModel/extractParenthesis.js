function extractParenthesis(elementId) {
    let text = document.getElementById(elementId).textContent;
    let matchesArr = [];
    let pattern = /\(.+?\)/g;
    let match = pattern.exec(text);

    while (match) {
        matchesArr.push(match[0]);
        match = pattern.exec(text);
    }

    return matchesArr.join("; ");
}