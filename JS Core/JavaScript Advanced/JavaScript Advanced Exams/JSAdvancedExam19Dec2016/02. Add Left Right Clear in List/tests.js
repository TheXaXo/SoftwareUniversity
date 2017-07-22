let makeList = require('./code');
let expect = require('chai').expect;

describe("Make List tests", function () {
    let list = {};

    beforeEach(function () {
        list = makeList();
    });

    it("Should have addLeft function", function () {
        expect(list.hasOwnProperty("addLeft")).to.equal(true);
    });

    it("Should have addRight function", function () {
        expect(list.hasOwnProperty("addRight")).to.equal(true);
    });

    it("Should have clear function", function () {
        expect(list.hasOwnProperty("clear")).to.equal(true);
    });

    it("Should add the item at the beginning of the list when the addLeft function is called", function () {
        list.addLeft("1");
        list.addLeft("2");

        expect(list.toString()).to.equal("2, 1");
    });

    it("Should add the item to the end of the list when the addRight function is called", function () {
        list.addRight("2");
        list.addRight("3");

        expect(list.toString()).to.equal("2, 3");
    });

    it("Should clear all items in the list when the clear function is called", function () {
        list.addLeft("2");
        list.addLeft("3");
        list.clear();

        expect(list.toString()).to.equal("");
    });
});