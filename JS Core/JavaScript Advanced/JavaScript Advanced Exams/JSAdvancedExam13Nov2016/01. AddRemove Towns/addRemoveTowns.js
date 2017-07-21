function attachEvents() {
    $('#btnAdd').on("click", addPressed);
    $('#btnDelete').on("click", deletePressed);

    function addPressed() {
        let townName = $('#newItem').val();

        if (townName === "") {
            return;
        }

        $('#towns').append($(`<option>${townName}</option>`));
        $('#newItem').val("");
    }

    function deletePressed() {
        $('option:selected').remove()
    }
}