function move(direction) {
    let children = $('#towns option');
    let selected = $(children).filter(':selected');

    if (selected.length === 0) {
        return;
    }

    let selectedElement = selected[0];

    if (direction === +1) {
        $(selectedElement).insertAfter($(selectedElement).next());
    } else {
        $(selectedElement).insertBefore($(selectedElement).prev());
    }
}