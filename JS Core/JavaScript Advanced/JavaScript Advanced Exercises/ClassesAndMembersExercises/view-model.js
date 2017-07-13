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

let textbox = new Textbox(".textbox", /[^a-zA-Z0-9]/);