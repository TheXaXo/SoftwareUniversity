let SortedList = require('./sortedList');
let expect = require('chai').expect;

describe("Sorted list tests", function () {
    it("Should have add function", function () {
        expect(SortedList.prototype.hasOwnProperty('add')).to.equal(true);
    });

    it("Should have remove function", function () {
        expect(SortedList.prototype.hasOwnProperty('remove')).to.equal(true);
    });

    it("Should have get function", function () {
        expect(SortedList.prototype.hasOwnProperty('get')).to.equal(true);
    });

    it("Should have size getter", function () {
        let list = new SortedList();
        expect(Object.getPrototypeOf(list).hasOwnProperty('size')).to.equal(true);
    });

    it("Should hold numeric elements", function () {
        let list = new SortedList();
        list.add(2);
        list.add(3);

        expect(list.list).to.deep.equal([2, 3]);
    });

    it("Should have an add function which adds the element to the collection", function () {
        let list = new SortedList();
        list.add(2);

        expect(list.list).to.deep.equal([2]);
    });

    it("Should keep the items sorted", function () {
        let list = new SortedList();
        list.add(5);
        list.add(3);
        list.add(10);

        expect(list.list).to.deep.equal([3, 5, 10]);
    });

    it("Should throw an error if the get function is given negative index", function () {
        let list = new SortedList();
        list.add(5);

        expect(() => list.get(-1)).to.throw(Error, "Index was outside the bounds of the collection.");
    });

    it("Should throw an error if the get function is given index outside of the bounds", function () {
        let list = new SortedList();
        list.add(5);

        expect(() => list.get(5)).to.throw(Error, "Index was outside the bounds of the collection.");
    });

    it("Should throw an error if the get function is executed over an empty list", function () {
        let list = new SortedList();

        expect(() => list.get(0)).to.throw(Error, "Collection is empty.");
    });

    it("Should throw an error if the remove function is given negative index", function () {
        let list = new SortedList();
        list.add(5);

        expect(() => list.remove(-1)).to.throw(Error, "Index was outside the bounds of the collection.");
    });

    it("Should throw an error if the remove function is given index outside of the bounds", function () {
        let list = new SortedList();
        list.add(5);

        expect(() => list.remove(5)).to.throw(Error, "Index was outside the bounds of the collection.");
    });

    it("Should throw an error if the remove function is executed over an empty list", function () {
        let list = new SortedList();

        expect(() => list.remove(0)).to.throw(Error, "Collection is empty.");
    });

    it("Should return the correct size value", function () {
        let list = new SortedList();
        list.add(2);
        list.add(3);

        expect(list.size).to.equal(2);
    });

    it("Should have a remove function which removes the element at the given index", function () {
        let list = new SortedList();
        list.add(2);
        list.add(3);
        list.remove(1);

        expect(list.list).to.deep.equal([2]);
    });

    it("Should have a get function which returns the item at the given index", function () {
        let list = new SortedList();
        list.add(2);
        list.add(3);

        expect(list.get(1)).to.equal(3);
    });

    it("Should return 0 when the size function is called over an empty list", function () {
        let list = new SortedList();

        expect(list.size).to.equal(0);
    })
});