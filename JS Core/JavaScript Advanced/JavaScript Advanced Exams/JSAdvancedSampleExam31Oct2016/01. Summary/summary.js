function solution(selector) {
    $(selector).on("click", onClick);

    function onClick() {
        let items = $('#content strong');
        let string = "";

        for (let item of items) {
            string += $(item).text();
        }

        let summaryDiv = $('<div id="summary">');
        summaryDiv.append($('<h2>Summary</h2>'));
        summaryDiv.append($(`<p>${string}</p>`));

        $('#content').parent().append(summaryDiv);
    }
}
