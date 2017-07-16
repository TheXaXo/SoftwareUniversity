class Console {
    static get placeholder() {
        return /{\d+}/g;
    }

    static writeLine() {
        let message = arguments[0];
        if (arguments.length === 1) {
            if (typeof (message) === 'object') {
                message = JSON.stringify(message);
                return message;
            }
            else if (typeof(message) === 'string') {
                return message;
            }
        }
        else {
            if (typeof (message) !== 'string') {
                throw new TypeError("No string format given!");
            }
            else {
                let tokens = message.match(this.placeholder).sort(function (a, b) {
                    a = Number(a.substring(1, a.length - 1));
                    b = Number(b.substring(1, b.length - 1));
                    return a - b;
                });
                if (tokens.length !== (arguments.length - 1)) {
                    throw new RangeError("Incorrect amount of parameters given!");
                }
                else {
                    for (let i = 0; i < tokens.length; i++) {
                        let number = Number(tokens[i].substring(1, tokens[i].length - 1));
                        if (number !== i) {
                            throw new RangeError("Incorrect placeholders given!");
                        }
                        else {
                            message = message.replace(tokens[i], arguments[i + 1])
                        }
                    }
                    return message;
                }
            }
        }
    }
}

let expect = require("chai").expect;
let mocha = require("mocha");

describe("C# Console unit tests", function () {
    it("Should return the same string if only one string is passed", function () {
        expect(Console.writeLine("ASD")).to.equal("ASD");
    });

    it("Should return the JSON representation if an object is passed", function () {
        let obj = {name: "Pesho", age: 12};
        expect(Console.writeLine(obj)).to.equal(JSON.stringify(obj));
    });

    it("Should throw a TypeError if multiple args are passed but the first is not a string", function () {
        expect(() => Console.writeLine(2, 2)).to.throw(TypeError);
    });

    it("Should throw RangeError if the number of params does not correspond to the number of placeholders", function () {
        expect(() => Console.writeLine("{0} {1}", 1)).to.throw(RangeError);
    });

    it("Should throw RangeError if the index in the placeholder is invalid", function () {
        expect(() => Console.writeLine("{13}", 1)).to.throw(RangeError);
    });

    it("Should replace the placeholders successfully", function () {
        expect(Console.writeLine("{0} -> {1}", "Pesho", "Gosho")).to.equal("Pesho -> Gosho");
    })
});