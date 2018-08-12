let defaultFirstName = 'Pesho';
let defaultLastName = 'Peshov';
let defaultPhoneNumber = '555-333-4545';
let defaultUCL = '9311124003';

let supportPositions = $('#support-positions');
let crmPositions = $('#crm-positions');
let marketingPositions = $('#marketing-positions');
let developmentPositions = $('#development-positions');
let otherPositions = $('#other-positions');
let otherPositionsRadioButton = $('#other-positions-radio-button');

function attachEvents() {
    $('h5.h5.input-text').on('click', showInputField);
    $('input.form-control.input-field').on('keypress', hideInputField);
    $('#submit').on('click', resetForm);
    $('#reset').on('click', resetForm);
    $('#positions').find('input').on('change', changePosition);

    function showInputField() {
        $(this).hide();

        let inputField = $(this).prev();
        inputField.val($(this).text());
        inputField.show();
        inputField.focus();
    }

    function hideInputField(e) {
        if (e.which === 13) {
            $(this).hide();

            let inputText = $(this).next();
            inputText.text($(this).val());
            inputText.show();
        }
    }

    function resetForm() {
        $('#first-name').text(defaultFirstName);
        $('#last-name').text(defaultLastName);
        $('#phone-number').text(defaultPhoneNumber);
        $('#ucl').text(defaultUCL);

        otherPositionsRadioButton.prop('checked', true).trigger('change');
        $(supportPositions).find('input[type=radio]').prop('checked', false);
        $(crmPositions).find('input[type=radio]').prop('checked', false);
        $(marketingPositions).find('input[type=radio]').prop('checked', false);
        $(developmentPositions).find('input[type=radio]').prop('checked', false);
        $(otherPositions).find('input[type=radio]').prop('checked', false);
    }

    function changePosition() {
        let position = $(this).val();
        supportPositions.hide();
        crmPositions.hide();
        marketingPositions.hide();
        developmentPositions.hide();
        otherPositions.hide();

        switch (position) {
            case 'support':
                supportPositions.show();
                break;
            case 'crm':
                crmPositions.show();
                break;
            case 'marketing':
                marketingPositions.show();
                break;
            case 'development':
                developmentPositions.show();
                break;
            case 'other':
                otherPositions.show();
                break;
        }
    }
}

attachEvents();