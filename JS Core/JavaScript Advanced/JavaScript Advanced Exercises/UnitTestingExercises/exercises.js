//01. Validate object
function result(object) {
    let validMethods = ["GET", "POST", "DELETE", "CONNECT"];

    if (!object.hasOwnProperty("method") || !validMethods.includes(object.method)) {
        throw new Error("Invalid request header: Invalid Method");
    }

    let uriPattern = /^(?:[A-Za-z0-9.]+|\*)$/g;

    if (!object.hasOwnProperty("uri") || !uriPattern.test(object.uri)) {
        throw new Error("Invalid request header: Invalid URI");
    }

    let validVersions = ["HTTP/0.9", "HTTP/1.0", "HTTP/1.1", "HTTP/2.0"];

    if (!object.hasOwnProperty("version") || !validVersions.includes(object.version)) {
        throw new Error("Invalid request header: Invalid Version");
    }

    let messagePattern = /^[^<>\\&'"]+$/g;

    if (!object.hasOwnProperty("message") || (!messagePattern.test(object.message) && object.message.length > 0)) {
        throw new Error("Invalid request header: Invalid Message");
    }

    return object;
}

//Unit tests
let expect = require("chai").expect;

describe("Validate objects tests", function () {
    it("Should return the same object if all fields are valid and present", function () {
        let object = {
            method: 'GET',
            uri: 'svn.public.catalog',
            version: 'HTTP/1.1',
            message: ''
        };

        expect(result(object)).to.equal(object);
    });

    it("Should throw an error if an invalid method is given", function () {
        let object = {
            method: 'ASD',
            uri: 'svn.public.catalog',
            version: 'HTTP/1.1',
            message: ''
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid Method");
    });

    it("Should throw an error if there is no method field", function () {
        let object = {
            uri: 'svn.public.catalog',
            version: 'HTTP/1.1',
            message: ''
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid Method");
    });

    it("Should throw an error if an invalid uri is given", function () {
        let object = {
            method: 'GET',
            uri: 'asd/2',
            version: 'HTTP/1.1',
            message: ''
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid URI");
    });

    it("Should throw an error if there is no uri field", function () {
        let object = {
            method: 'GET',
            version: 'HTTP/1.1',
            message: ''
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid URI");
    });

    it("Should throw an error if an invalid version is given", function () {
        let object = {
            method: 'GET',
            uri: 'svn.public.catalog',
            version: 'HTTP/1.8',
            message: ''
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid Version");
    });

    it("Should throw an error if there is no version field", function () {
        let object = {
            method: 'GET',
            uri: 'svn.public.catalog',
            message: ''
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid Version");
    });

    it("Should throw an error if an invalid message is given", function () {
        let object = {
            method: 'GET',
            uri: 'svn.public.catalog',
            version: 'HTTP/1.1',
            message: '<'
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid Message");
    });

    it("Should throw an error if there is no message field", function () {
        let object = {
            method: 'GET',
            uri: 'svn.public.catalog',
            version: 'HTTP/1.1'
        };

        expect(() => result(object)).to.throw(Error, "Invalid request header: Invalid Message");
    });

    it("Should not throw error if the uri is '*'", function () {
        let object = {
            method: 'GET',
            uri: '*',
            version: 'HTTP/1.1',
            message: ''
        };

        expect(result(object)).to.equal(object);
    });
});

//02. Even or odd
function isOddOrEven(string) {
    if (typeof(string) !== 'string') {
        return undefined;
    }
    if (string.length % 2 === 0) {
        return "even";
    }

    return "odd";
}

//Unit tests
describe("Even or odd tests", function () {
    it("Should return undefined if a non-string is passed", function () {
        expect(isOddOrEven(2)).to.be.undefined;
    });

    it("Should return 'even' if a string with an even length is passed", function () {
        expect(isOddOrEven("Pe")).to.equal("even");
    });

    it("Should return 'odd' if a string with an odd length is passed", function () {
        expect(isOddOrEven("Pes")).to.equal("odd");
    });

    it("Should return even if an empty string is passed", function () {
        expect(isOddOrEven("")).to.equal("even");
    })
});

//03. Char lookup
function lookupChar(string, index) {
    if (typeof(string) !== 'string' || !Number.isInteger(index)) {
        return undefined;
    }
    if (string.length <= index || index < 0) {
        return "Incorrect index";
    }

    return string.charAt(index);
}

//Unit tests
describe("Char lookup tests", function () {
    it("Should return undefined if the first parameter is not a string", function () {
        expect(lookupChar(2, 2)).to.be.undefined;
    });

    it("Should return undefined if the second parameter is not a number", function () {
        expect(lookupChar("Pesho", "Gesha")).to.be.undefined;
    });

    it("Should return 'Incorrect index' if the given index is below 0", function () {
        expect(lookupChar("Pesho", -1)).to.equal("Incorrect index");
    });

    it("Should return 'Incorrect index' if the given index is outside the bounds of the string", function () {
        expect(lookupChar("Pesho", 5)).to.equal("Incorrect index");
    });

    it("Should return 'Incorrect index' if the string given is empty regardless of the index", function () {
        expect(lookupChar("", 0)).to.equal("Incorrect index");
    });

    it("Should return undefined if the given index is a floating point number", function () {
        expect(lookupChar("Pesho", 1.1)).to.be.undefined;
    });

    it("Should return the correct char", function () {
        expect(lookupChar("Pesho", 1)).to.equal("e");
    })
});

//04. Math enforcer
let mathEnforcer = {
    addFive: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num + 5;
    },
    subtractTen: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num - 10;
    },
    sum: function (num1, num2) {
        if (typeof(num1) !== 'number' || typeof(num2) !== 'number') {
            return undefined;
        }
        return num1 + num2;
    }
};

//Unit tests
describe("Math enforcer tests", function () {
    it("Should return the correct sum while adding 5 to an integer", function () {
        expect(mathEnforcer.addFive(5)).to.equal(10);
    });

    it("Should return the correct sum while adding 5 to a floating point number", function () {
        expect(mathEnforcer.addFive(5.5)).to.be.closeTo(10.5, 0.01);
    });

    it("Should return undefined when adding 5 to a non-number", function () {
        expect(mathEnforcer.addFive("Gosho")).to.be.undefined;
    });

    it("Should return the correct sum while subtracting 10 from an integer", function () {
        expect(mathEnforcer.subtractTen(20)).to.equal(10);
    });

    it("Should return the correct sum while subtracting 10 from a floating point number", function () {
        expect(mathEnforcer.subtractTen(20.5)).to.be.closeTo(10.5, 0.01);
    });

    it("Should return undefined when subtracting 10 from a non-number", function () {
        expect(mathEnforcer.subtractTen("Gosho")).to.be.undefined;
    });

    it("Should sum two integer numbers successfully", function () {
        expect(mathEnforcer.sum(5, 5)).to.equal(10);
    });

    it("Should sum two floating point numbers successfully", function () {
        expect(mathEnforcer.sum(5.5, 5.5)).to.be.closeTo(11, 0.01);
    });

    it("Should return undefined if the first parameter when summing is not a number", function () {
        expect(mathEnforcer.sum("Pesho", 1)).to.be.undefined;
    });

    it("Should return undefined if the second parameter while summing is not a number", function () {
        expect(mathEnforcer.sum(1, "Pesho")).to.be.undefined;
    });

    it("Should return the correct value when adding 5 to negative numbers", function () {
        expect(mathEnforcer.addFive(-10)).to.equal(-5);
    });

    it("Should return the correct value when subtracting 10 from a negative number", function () {
        expect(mathEnforcer.subtractTen(-20)).to.equal(-30);
    });

    it("Should sum two negative numbers successfully", function () {
        expect(mathEnforcer.sum(-10, -10)).to.equal(-20);
    })
});

//05. Shared object
let sharedObject = {
    name: null,
    income: null,
    changeName: function (name) {
        if (name.length === 0) {
            return;
        }
        this.name = name;
        let newName = $('#name');
        newName.val(this.name);
    },
    changeIncome: function (income) {
        if (!Number.isInteger(income) || income <= 0) {
            return;
        }
        this.income = income;
        let newIncome = $('#income');
        newIncome.val(this.income);
    },
    updateName: function () {
        let newName = $('#name').val();
        if (newName.length === 0) {
            return;
        }
        this.name = newName;
    },
    updateIncome: function () {
        let newIncome = $('#income').val();
        if (isNaN(newIncome) || !Number.isInteger(Number(newIncome)) || Number(newIncome) <= 0) {
            return;
        }
        this.income = Number(newIncome);
    }
};

//Unit tests
let jsdom = require('jsdom-global')();
let $ = require('jquery');

document.body.innerHTML =
    "<div id='wrapper'>" +
    "<input type='text' id='name'>" +
    "<input type='text' id='income'>" +
    "</div>";

describe("Shared object tests", function () {
    it("Should start with the value null for the name field", function () {
        expect(sharedObject.name).to.be.null;
    });

    it("Should start with the value null for the income field", function () {
        expect(sharedObject.income).to.be.null;
    });

    beforeEach(function () {
        $('#name').val("");
        $('#income').val("");
        sharedObject.name = null;
        sharedObject.income = null;
    });

    it("Should successfully change the value of the name input field", function () {
        sharedObject.changeName("AsdAsd");
        expect($('#name').val()).to.equal("AsdAsd");
    });

    it("Should successfully change the inner name", function () {
        sharedObject.changeName("AsdAsd");
        expect(sharedObject.name).to.equal("AsdAsd");
    });

    it("Should successfully change the value of the income input field", function () {
        sharedObject.changeIncome(1000);
        expect(Number($('#income').val())).to.equal(1000);
    });

    it("Should successfully change the income", function () {
        sharedObject.changeIncome(1000);
        expect(sharedObject.income).to.equal(1000);
    });

    it("Should update the inner name successfully", function () {
        $('#name').val("AsdAsd");
        sharedObject.updateName();
        expect(sharedObject.name).to.equal("AsdAsd");
    });

    it("Should update the inner income successfully", function () {
        $('#income').val(5);
        sharedObject.updateIncome();
        expect(sharedObject.income).to.equal(5);
    });

    it("Should not change the name if an empty string is given", function () {
        $('#name').val("AsdAsd");
        sharedObject.changeName("");
        expect($('#name').val()).to.not.equal("");
    });

    it("Should not change the income if a non-number is given", function () {
        sharedObject.changeIncome("AsdAsd");
        expect(Number($('#income').val())).to.not.equal("AsdAsd");
    });

    it("Should not change the income if a negative number is given", function () {
        sharedObject.changeIncome(-1);
        expect(Number($('#income').val())).to.not.equal(-1);
    });

    it("Should not update the inner name if an empty string is given", function () {
        $('#name').val("");
        sharedObject.updateName();
        expect(sharedObject.name).to.not.equal("");
    });

    it("Should not update the inner income if a string is given", function () {
        $('#income').val("AsdAsd");
        sharedObject.updateIncome();
        expect(sharedObject.income).to.not.equal("AsdAsd");
    });

    it("Should not update the inner income if a negative number is given", function () {
        $('#income').val(-1);
        sharedObject.updateIncome();
        expect(sharedObject.income).to.not.equal(-1);
    });

    it("Should not update the income if NaN is given", function () {
        $('#income').val(NaN);
        sharedObject.updateIncome();
        expect(sharedObject.income).to.not.be.NaN;
    });

    it("Should not change the income if the value is 0", function () {
        sharedObject.changeIncome(0);
        let incomeField = $('#income');

        if (incomeField.val() === "") {
            incomeField.val("AsdAsd");
        }

        expect(Number(incomeField.val())).to.not.equal(0);
    });

    it("Should not update the income if the value is 0", function () {
        $('#income').val(0);
        sharedObject.updateIncome();
        expect(sharedObject.income).to.not.equal(0);
    });

    it("Should not change the income field if the given number is a floating point number", function () {
        sharedObject.changeIncome(1.1);
        expect(Number($('#income').val())).to.not.equal(1.1);
    });

    it("Should not change the income if the given number is a floating point number", function () {
        sharedObject.changeIncome(1.1);
        expect(sharedObject.income).to.not.equal(1.1);
    });

    it("Should not update the income if the given number is a floating point number", function () {
        $('#income').val(1.1);
        expect(sharedObject.income).to.not.equal(1.1);
    });
});

//06. ArmageDOM
function nuke(selector1, selector2) {
    if (selector1 === selector2) return;
    $(selector1).filter(selector2).remove();
}

describe("ArmageDOM tests", function () {
    beforeEach(function () {
        document.body.innerHTML =
            "<div id='target'>" +
            "<div class='nested target'>" +
            "<p>This is some text</p>" +
            "</div>" +
            "<div class='target'>" +
            "<p>Empty div</p>" +
            "</div>" +
            "<div class='inside'>" +
            "<span class='nested'>Some more text</span>" +
            "<span class='target'>Some more text</span>" +
            "</div>" +
            "</div>"
    });

    it("Should not delete the elements if two equal selectors are given", function () {
        let selector = '#target';
        nuke(selector, selector);
        expect($(selector).length).to.equal(1);
    });

    it("Should not delete anything if the second selector is missing", function () {
        let selector = '#target';
        nuke(selector);
        expect($(selector).length).to.equal(1);
    });

    it("Should delete all elements matching both selectors", function () {
        let selector1 = 'div';
        let selector2 = '.inside';
        nuke(selector1, selector2);
        expect($('div .inside').length).to.equal(0);
    });

    it("Should not do anything if the first selector is invalid", function () {
        let selector1 = 'DIVdiv';
        let selector2 = '.inside';
        nuke(selector1, selector2);
        expect($('.inside').length).to.equal(1);
    });

    it("Should not do anything if the second selector is invalid", function () {
        let selector1 = 'div';
        let selector2 = 'INnside';
        nuke(selector1, selector2);
        expect($('.inside').length).to.equal(1);
    });

    it("Should delete all elements with 'nested' and 'target' class", function () {
        let selector1 = '.nested';
        let selector2 = '.target';
        nuke(selector1, selector2);
        expect($('.target').length).to.equal(2);
        expect($('.nested').length).to.equal(1);
    })
});