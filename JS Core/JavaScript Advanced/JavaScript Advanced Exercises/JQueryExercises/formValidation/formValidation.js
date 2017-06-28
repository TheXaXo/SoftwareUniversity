function validate() {
    $('#company').on('change', toggleCompanyInfo);
    $('#submit').on('click', validateFields);

    function toggleCompanyInfo() {
        let companyInfo = $('#companyInfo');

        if ($('#company:checked').length > 0) {
            companyInfo.show()
        } else {
            companyInfo.hide();
        }
    }

    function validateFields(target) {
        target.preventDefault();

        let userNameField = $('#username');
        let passwordField = $('#password');
        let confirmPasswordField = $('#confirm-password');
        let emailField = $('#email');

        let userNamePattern = /^[A-Za-z0-9]{3,20}$/;
        let passwordPattern = /^[\w]{5,15}$/;
        let emailPattern = /^.*@.*\..*$/;

        let areAllValid = true;

        if (!userNamePattern.test(userNameField.val())) {
            userNameField.css("border", "");
            userNameField.css("border-color", "red");
            areAllValid = false;
        } else {
            userNameField.css("border", "none");
        }

        let passwordFieldValue = passwordField.val();
        let confirmPasswordFieldValue = confirmPasswordField.val();

        if (!passwordPattern.test(passwordFieldValue)
            || !passwordPattern.test(confirmPasswordFieldValue)
            || passwordFieldValue !== confirmPasswordFieldValue) {
            passwordField.css("border", "");
            passwordField.css("border-color", "red");
            confirmPasswordField.css("border", "");
            confirmPasswordField.css("border-color", "red");
            areAllValid = false;
        } else {
            passwordField.css("border", "none");
            confirmPasswordField.css("border", "none");
        }

        if (!emailPattern.test(emailField.val())) {
            emailField.css("border", "");
            emailField.css("border-color", "red");
            areAllValid = false;
        } else {
            emailField.css("border", "none");
        }

        if ($('#company:checked').length > 0) {
            let companyPattern = /^[1-9][0-9]{3}$/;
            let companyField = $('#companyNumber');

            if (!companyPattern.test(companyField.val())) {
                companyField.css("border", "");
                companyField.css("border-color", "red");
                areAllValid = false;
            } else {
                companyField.css("border", "none");
            }
        }

        let validElement = $('#valid');
        if (areAllValid) {
            validElement.show();
        } else {
            validElement.hide();
        }
    }
}