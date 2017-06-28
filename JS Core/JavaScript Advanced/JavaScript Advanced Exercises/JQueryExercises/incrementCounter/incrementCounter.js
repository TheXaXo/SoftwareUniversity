function increment(selector) {
    $(selector)
        .append($('<textarea class="counter" disabled>0</textarea>'))
        .append($('<button class="btn" id="incrementBtn">Increment</button>'))
        .append($('<button class="btn" id="addBtn">Add</button>'))
        .append($('<ul class="results"></ul>'));

    $('#incrementBtn').on('click', incrementPressed);
    $('#addBtn').on('click', addPressed);

    function incrementPressed() {
        let counter = $('.counter');
        counter.val(Number(counter.val()) + 1);
    }

    function addPressed() {
        let valueFromField = $('.counter').val();
        $('.results').append($(`<li>${valueFromField}</li>`));
    }
}