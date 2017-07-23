function move(command) {
    let selectedElement;
    let element;

    switch (command) {
        case "left":
            selectedElement = $('#selected-towns option:selected');

            if (selectedElement.length === 0) {
                return;
            }

            element = selectedElement[0];
            $(element).remove();
            $('#available-towns').append($(element));
            break;
        case "right":
            selectedElement = $('#available-towns option:selected');

            if (selectedElement.length === 0) {
                return;
            }

            element = selectedElement[0];
            $(element).remove();
            $('#selected-towns').append($(element));
            break;
        case "print":
            let towns = $('#selected-towns option');
            let out = "";

            for (let option of towns) {
                out += $(option).text() + "; ";
            }

            $('#output').text(out.substring(0, out.length - 2));
            break;
    }
}