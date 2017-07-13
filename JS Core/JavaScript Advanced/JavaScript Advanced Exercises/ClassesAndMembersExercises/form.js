let result = (function () {
    class Textbox {
        constructor(selector, validSymbolsPattern) {
            this._elements = $(selector);
            this._invalidSymbols = validSymbolsPattern;
            this.attachListeners();
        }

        get value() {
            return this._value;
        }

        set value(value) {
            this._value = value;

            for (let element of this.elements) {
                $(element).val(value);
            }
        }

        get elements() {
            return this._elements;
        }

        isValid() {
            return !(this._invalidSymbols.test(this.value));
        }

        attachListeners() {
            let textBoxObject = this;

            for (let element of this.elements) {
                $(element).on("input", function () {
                    textBoxObject.value = $(element).val();

                    for (let otherElement of textBoxObject.elements) {
                        $(otherElement).val($(element).val());
                    }
                })
            }
        }
    }

    class Form {
        constructor() {
            this._element = $("<div class='form'>");

            for (let argument of arguments) {
                if (!(argument instanceof Textbox)) {
                    throw new Error("The argument passed is not of a Textbox class");
                }
            }

            this._textboxes = [];

            for (let textBoxObject of arguments) {
                $(textBoxObject.elements).remove();
                $(textBoxObject.elements).appendTo(this._element);
                this._textboxes.push(textBoxObject);
            }
        }

        submit() {
            let allValid = true;

            for (let textBox of this._textboxes) {
                if (textBox.isValid()) {
                    $(textBox.elements).css("border", "2px solid green");
                } else {
                    allValid = false;
                    $(textBox.elements).css("border", "2px solid red");
                }
            }

            return allValid;
        }

        attach(selector) {
            $(selector).append($(this._element));
        }
    }

    return {
        Textbox: Textbox,
        Form: Form
    }
}());

let Textbox = result.Textbox;
let Form = result.Form;
let username = new Textbox("#username", /[^a-zA-Z0-9]/);
let password = new Textbox("#password", /[^a-zA-Z]/);
username.value = "username";
password.value = "password2";
let form = new Form(username, password);
form.attach("#root");