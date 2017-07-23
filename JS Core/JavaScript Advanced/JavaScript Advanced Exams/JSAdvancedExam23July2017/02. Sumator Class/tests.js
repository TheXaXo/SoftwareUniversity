let Sumator = require('./code');
let expect = require('chai').expect;

describe("Sumator tests", function () {
    let instance;

    beforeEach(function () {
        instance = new Sumator();
    });

    it("Should have a data property", function () {
        expect(instance.hasOwnProperty("data")).to.equal(true);
    });

    it("Should have the data property initialized as an empty array", function () {
        expect(instance.data).to.deep.equal([]);
    });

    it("Should have a function add", function () {
        expect(Sumator.prototype.hasOwnProperty("add")).to.equal(true);
    });

    it("Should append the new item at the end of the list if a number is passed", function () {
        instance.add(2);
        instance.add(3);

        expect(instance.data).to.deep.equal([2, 3]);
    });

    it("Should append the new item at the end of the list if a string is passed", function () {
        instance.add(2);
        instance.add("Gosho");

        expect(instance.data).to.deep.equal([2, "Gosho"]);
    });

    it("Should append the new item at the end of the list if an Object is passed", function () {
        let object = new Date();

        instance.add(2);
        instance.add("Gosho");
        instance.add(object);

        expect(instance.data).to.deep.equal([2, "Gosho", object]);
    });

    it("Should have sumNums function", function () {
        expect(Sumator.prototype.hasOwnProperty("sumNums")).to.equal(true);
    });

    it("Should return the sum of the numbers only when the sumNums function is called", function () {
        let object = new Date();

        instance.add(2);
        instance.add("Gosho");
        instance.add(object);
        instance.add(20);

        expect(instance.sumNums()).to.equal(22);
    });

    it("Should return zero if there are no numbers when the sumNums function is called", function () {
        instance.add("Gosho");

        expect(instance.sumNums()).to.equal(0);
    });

    it("Should return zero if there are no items when the sumNums function is called", function () {
        expect(instance.sumNums()).to.equal(0);
    });

    it("Should have removeByFilter function", function () {
        expect(Sumator.prototype.hasOwnProperty("removeByFilter")).to.equal(true);
    });

    it("Should remove all items matching the function given as argument to the removeByFilter function", function () {
        instance.add(2);
        instance.add(3);
        instance.add(4);
        instance.add(5);

        instance.removeByFilter(a => a >= 4);

        expect(instance.data).to.deep.equal([2, 3]);
    });

    it("Should have a toString function", function () {
        expect(Sumator.prototype.hasOwnProperty("toString")).to.equal(true);
    });

    it("Should return '(empty)' when the toString function is called on an empty collection", function () {
        expect(instance.toString()).to.equal("(empty)");
    });

    it("Should return all items joined by ', ' when the toString function is called", function () {
        instance.add(2);
        instance.add("Gosho");
        instance.add(20);

        expect(instance.toString()).to.equal("2, Gosho, 20");
    });

    it("Should return only 1 item when the toString function is called on one item", function () {
        instance.add("Gosho");

        expect(instance.toString()).to.equal("Gosho");
    });

    it("Should return the correct sum when the data contains numbers below zero", function () {
        instance.add(2);
        instance.add(-3);

        expect(instance.sumNums()).to.equal(-1);
    });

    it("Should return the correct sum when the data contains floating point numbers", function () {
        instance.add(-1.1);
        instance.add(2.2);

        expect(instance.sumNums()).to.equal(1.1);
    });

    it("Should return zero if the data contains only numbers presented as string", function () {
        instance.add("2");
        instance.add("5");

        expect(instance.sumNums()).to.equal(0);
    });

    it("Should return the correct sum when there is only 1 numeric item in the data field", function () {
        instance.add(10);

        expect(instance.sumNums()).to.equal(10);
    });
});