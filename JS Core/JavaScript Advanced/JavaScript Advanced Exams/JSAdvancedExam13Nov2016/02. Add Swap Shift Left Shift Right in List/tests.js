let createList = require("./code");
let expect = require('chai').expect;

describe("List unit tests", function () {
    it("Should have add function", function () {
        expect(createList().hasOwnProperty("add")).to.equal(true);
    });

    it("Should have shiftLeft function", function () {
        expect(createList().hasOwnProperty("shiftLeft")).to.equal(true);
    });

    it("Should have shiftRight function", function () {
        expect(createList().hasOwnProperty("shiftRight")).to.equal(true);
    });

    it("Should have swap function", function () {
        expect(createList().hasOwnProperty("swap")).to.equal(true);
    });

    it("Should have a toString method which append all items", function () {
        let list = createList();
        list.add("ASD");
        list.add("BSD");

        expect(list.toString()).to.equal("ASD, BSD");
    });

    it("Should append the new item at the end of the list when the add function is called", function () {
        let list = createList();
        list.add("Gosho");
        list.add("Ivan");

        expect(list.toString()).to.equal("Gosho, Ivan");
    });

    it("Should shift all items left when the shiftLeft function is called", function () {
        let list = createList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.shiftLeft();

        expect(list.toString()).to.equal("2, 3, 4, 1");
    });

    it("Should shift all items right when the shiftRight function is called", function () {
        let list = createList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.shiftRight();

        expect(list.toString()).to.equal("4, 1, 2, 3");
    });

    it("Should swap both items when the swap function is called", function () {
        let list = createList();
        list.add("Ivan");
        list.add("Gosho");
        list.swap(0, 1);

        expect(list.toString()).to.equal("Gosho, Ivan");
    });

    it("Should return false and keep the collection unchanged when the swap method is called with equal indexes", function () {
        let list = createList();
        list.add("Gosho");

        expect(list.swap(0, 0)).to.equal(false);
        expect(list.toString()).to.equal("Gosho");
    });

    it("Should return false and keep the collection unchanged when the swap method is called with the first index being invalid", function () {
        let list = createList();
        list.add("Gosho");

        expect(list.swap(10, 0)).to.equal(false);
        expect(list.toString()).to.equal("Gosho");
    });

    it("Should return false and keep the collection unchanged when the swap method is called with the second index being invalid", function () {
        let list = createList();
        list.add("Gosho");

        expect(list.swap(0, 10)).to.equal(false);
        expect(list.toString()).to.equal("Gosho");
    });
});