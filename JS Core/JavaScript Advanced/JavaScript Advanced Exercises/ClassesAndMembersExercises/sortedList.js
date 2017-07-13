class SortedList {
    constructor() {
        this.innerList = [];
        this.size = 0;
    }

    add(element) {
        this.innerList.push(element);
        this.innerList = this.innerList.sort((a, b) => {
            return a - b;
        });
        this.size++;
    }

    remove(index) {
        if (index < 0 || index >= this.innerList.length) {
            return;
        }

        this.innerList.splice(index, 1);
        this.size--;
    }

    get(index) {
        if (index < 0 || index >= this.innerList.length) {
            return;
        }

        return this.innerList[index];
    }
}