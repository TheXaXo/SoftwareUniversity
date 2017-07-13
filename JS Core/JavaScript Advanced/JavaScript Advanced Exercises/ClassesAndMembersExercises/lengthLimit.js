class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
    }

    increase(value) {
        let newValue = this.innerLength + value;

        if (newValue < 0) {
            newValue = 0;
        }

        this.innerLength = newValue;
    }

    decrease(value) {
        let newValue = this.innerLength - value;

        if (newValue < 0) {
            newValue = 0;
        }

        this.innerLength = newValue;
    }

    toString() {
        return this.innerString.substr(0, this.innerLength) + "...";
    }
}