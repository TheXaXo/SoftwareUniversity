function modifyDOM() {
    let field1;
    let field2;
    let resultField;

    return {
        init: function (selector1, selector2, resultsSelector) {
            field1 = $(selector1);
            field2 = $(selector2);
            resultField = $(resultsSelector);
        },

        add: function () {
            resultField.val(Number(field1.val()) + Number(field2.val()));
        },

        subtract: function () {
            resultField.val(Number(field1.val()) - Number(field2.val()));
        }
    }
}