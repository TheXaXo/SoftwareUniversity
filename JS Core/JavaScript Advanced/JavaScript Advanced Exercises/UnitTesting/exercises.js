function subSum(arr, start, end) {
    if (!arr instanceof Array) {
        return NaN;
    }

    if (start < 0) {
        start = 0;
    }

    if (end > arr.length) {
        end = arr.length - 1;
    }

    let sum = 0;

    if (arr.length === 0) {
        return 0;
    }

    for (let i = start; i <= end; i++) {
        if (typeof arr[i] !== 'number') {
            return NaN;
        }

        sum += arr[i];
    }

    return sum;
}

function makeCard(face, suit) {
    if (face.toUpperCase() !== face || suit.toUpperCase() !== suit) {
        throw new Error("Error");
    }

    let card = "";

    switch (face) {
        case "2":
            card += "2";
            break;
        case "3":
            card += "3";
            break;
        case "4":
            card += "4";
            break;
        case "5":
            card += "5";
            break;
        case "6":
            card += "6";
            break;
        case "7":
            card += "7";
            break;
        case "8":
            card += "8";
            break;
        case "9":
            card += "9";
            break;
        case "10":
            card += "10";
            break;
        case "J":
            card += "J";
            break;
        case "Q":
            card += "Q";
            break;
        case "K":
            card += "K";
            break;
        case "A":
            card += "A";
            break;
        default:
            throw new Error("Error");
    }

    switch (suit) {
        case "S":
            card += "\u2660";
            break;
        case "H":
            card += "\u2665";
            break;
        case "D":
            card += "\u2666";
            break;
        case "C":
            card += "\u2663";
            break;
        default:
            throw new Error("Error");
    }

    return card;
}

function printDeckOfCards(cards) {
    function makeCard(face, suit) {
        if (face.toUpperCase() !== face || suit.toUpperCase() !== suit) {
            throw new Error("Error");
        }

        let card = "";

        switch (face) {
            case "2":
                card += "2";
                break;
            case "3":
                card += "3";
                break;
            case "4":
                card += "4";
                break;
            case "5":
                card += "5";
                break;
            case "6":
                card += "6";
                break;
            case "7":
                card += "7";
                break;
            case "8":
                card += "8";
                break;
            case "9":
                card += "9";
                break;
            case "10":
                card += "10";
                break;
            case "J":
                card += "J";
                break;
            case "Q":
                card += "Q";
                break;
            case "K":
                card += "K";
                break;
            case "A":
                card += "A";
                break;
            default:
                throw new Error("Error");
        }

        switch (suit) {
            case "S":
                card += "\u2660";
                break;
            case "H":
                card += "\u2665";
                break;
            case "D":
                card += "\u2666";
                break;
            case "C":
                card += "\u2663";
                break;
            default:
                throw new Error("Error");
        }

        return card;
    }

    let cardsToPrint = [];

    for (let card of cards) {
        let face = card.substring(0, card.length - 1);
        let suit = card[card.length - 1];

        try {
            cardsToPrint.push(makeCard(face, suit));
        } catch (err) {
            console.log(`Invalid card: ${card}`);
            return;
        }
    }

    console.log(cardsToPrint.join(" "));
}

//Unit testing
let expect = require('chai').expect;

//04. Sum of numbers

function sum(arr) {
    let sum = 0;
    for (let num of arr)
        sum += Number(num);
    return sum;
}

describe("Sum tests", function () {
    it("Should return 3 from [1, 2].", function () {
        expect(sum([1, 2])).to.equal(3);
    });

    it("Should return NaN for ['asd'].", function () {
        expect(sum(['pesho'])).to.be.NaN;
    });

    it("Should return 3.3 for [1.1, 1.1, 1.1].", function () {
        expect(sum([1.1, 1.1, 1.1])).to.be.closeTo(3.3, 0.1);
    })
});

//05. Check for symmetry

function isSymmetric(arr) {
    if (!Array.isArray(arr))
        return false; // Non-arrays are non-symmetric
    let reversed = arr.slice(0).reverse(); // Clone and reverse
    let equal = (JSON.stringify(arr) == JSON.stringify(reversed));
    return equal;
}

describe("Check for symmetry tests", function () {
    describe("General tests", () => {
        it("Should be a function", function () {
            expect(typeof isSymmetric).to.equal('function');
        })
    });

    describe("Value tests", () => {
        it("Should return false for non array", function () {
            expect(isSymmetric("asd")).to.equal(false);
        });

        it("Should return true for symmetrical array", function () {
            expect(isSymmetric([1, 2, 1])).to.equal(true);
        });

        it("Should return false for non-symmetrical array of even length", function () {
            expect(isSymmetric([1, 2, 3, 4])).to.equal(false);
        });

        it("Should return false for non-symmetrical array of odd length", function () {
            expect(isSymmetric([1, 2, 3])).to.equal(false);
        });

        it("Should return false for non symmetrical array", function () {
            expect(isSymmetric([1, 2])).to.equal(false);
        });

        it("Should return true for empty array", function () {
            expect(isSymmetric([])).to.equal(true);
        });

        it("Should return false for symmetrical string", function () {
            expect(isSymmetric("abba")).to.equal(false);
        });

        it("Should return true for an array containing one element", function () {
            expect(isSymmetric([1])).to.equal(true);
        });

        it("Should return false for non-array", function () {
            expect(isSymmetric(1, 2, 1)).to.equal(false);
        });

        it("Should return false for a number", function () {
            expect(isSymmetric(1)).to.equal(false);
        });

        it("Should return true for symmetrical array of even length", function () {
            expect(isSymmetric([1, 2, 2, 1])).to.equal(true);
        });

        it("Should return true for a combined symmetrical array", function () {
            expect(isSymmetric([1, 'a', 'a', 1])).to.equal(true);
        });

        it("Should return true for a mixed symmetrical array", function () {
            expect(isSymmetric([1, new Date(), 1])).to.equal(true);
        });

        it("Should return true for [NaN, NaN]", function () {
            expect(isSymmetric([NaN, NaN])).to.equal(true);
        })
    });
});

//06. RGBToHex

function rgbToHexColor(red, green, blue) {
    if (!Number.isInteger(red) || (red < 0) || (red > 255))
        return undefined; // Red value is invalid
    if (!Number.isInteger(green) || (green < 0) || (green > 255))
        return undefined; // Green value is invalid
    if (!Number.isInteger(blue) || (blue < 0) || (blue > 255))
        return undefined; // Blue value is invalid
    return "#" +
        ("0" + red.toString(16).toUpperCase()).slice(-2) +
        ("0" + green.toString(16).toUpperCase()).slice(-2) +
        ("0" + blue.toString(16).toUpperCase()).slice(-2);
}

describe("RGB to Hex tests", function () {
    it("Should return correct hex", function () {
        expect(rgbToHexColor(66, 134, 244)).to.equal("#4286F4");
    });

    it("Should return undefined if first parameter is out of range", function () {
        expect(rgbToHexColor(-1, 2, 1)).to.equal(undefined);
    });

    it("Should return undefined if second parameter is out of range", function () {
        expect(rgbToHexColor(1, -2, 1)).to.equal(undefined);
    });

    it("Should return undefined if third parameter is out of range", function () {
        expect(rgbToHexColor(1, 2, -1)).to.equal(undefined);
    });

    it("Should return false if red is over 255", function () {
        expect(rgbToHexColor(256, 1, 1)).to.equal(undefined);
    });

    it("Should return false if green is over 255", function () {
        expect(rgbToHexColor(1, 256, 1)).to.equal(undefined);
    });

    it("Should return false if blue is over 255", function () {
        expect(rgbToHexColor(1, 1, 256)).to.equal(undefined);
    });

    it("Should return undefined for no parameters given", function () {
        expect(rgbToHexColor()).to.equal(undefined);
    });

    it("Should return undefined if only one number is passed as parameter", function () {
        expect(rgbToHexColor(1)).to.equal(undefined);
    });

    it("Should return proper black color", function () {
        expect(rgbToHexColor(0, 0, 0)).to.equal("#000000");
    });

    it("Should return proper white color", function () {
        expect(rgbToHexColor(255, 255, 255)).to.equal("#FFFFFF");
    })
});

//07. Add/Subtract

function createCalculator() {
    let value = 0;
    return {
        add: function (num) {
            value += Number(num);
        },
        subtract: function (num) {
            value -= Number(num);
        },
        get: function () {
            return value;
        }
    }
}

describe("Add/Subtract tests", function () {
    it("Should return correct value when adding valid numbers", function () {
        let calc = createCalculator();
        calc.add(2);

        expect(calc.get()).to.equal(2);
    });

    it("Should return correct value when subtracting valid numbers", function () {
        let calc = createCalculator();
        calc.subtract(2);

        expect(calc.get()).to.equal(-2);
    });

    it("Should initialize correctly", function () {
        let calc = createCalculator();
        expect(calc.get()).to.equal(0);
    });

    it("Should return correct value when adding floating point numbers", function () {
        let calc = createCalculator();
        calc.add(1.1);

        expect(calc.get()).to.be.closeTo(1.1, 0.1);
    });

    it("Should return correct value when subtracting floating point numbers", function () {
        let calc = createCalculator();
        calc.subtract(1.1);

        expect(calc.get()).to.be.closeTo(-1.1, 0.1);
    });

    it("Should return NaN when adding invalid value", function () {
        let calc = createCalculator();
        calc.add("Pesho");

        expect(calc.get()).to.be.NaN;
    });

    it("Should return NaN when subtracting invalid value", function () {
        let calc = createCalculator();
        calc.subtract("Pesho");

        expect(calc.get()).to.be.NaN;
    });

    it("Should parse numbers given as string correctly", function () {
        let calc = createCalculator();
        calc.add('2');

        expect(calc.get()).to.equal(2);
    })
});