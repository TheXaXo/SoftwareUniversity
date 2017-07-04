(function () {
    Array.prototype.last = function () {
        return this[this.length - 1];
    };

    Array.prototype.skip = function (n) {
        return this.slice(n);
    };

    Array.prototype.take = function (n) {
        return this.slice(0, n);
    };

    Array.prototype.sum = function () {
        return this.reduce((a, b) => a + b);
    };

    Array.prototype.average = function () {
        let sum = this.reduce((a, b) => a + b);
        return sum / this.length;
    }
})();

function constructionCrew(object) {
    if (object.handsShaking === false) {
        return object;
    }

    let requiredAlcohol = object.weight * object.experience * 0.1;
    object.bloodAlcoholLevel += requiredAlcohol;
    object.handsShaking = false;

    return object;
}

function carFactory(desiredCar) {
    let model = desiredCar.model;
    let engine;

    if (desiredCar.power <= 90) {
        engine = {power: 90, volume: 1800};
    } else if (desiredCar.power <= 120) {
        engine = {power: 120, volume: 2400};
    } else {
        engine = {power: 200, volume: 3500};
    }

    let carriage = {type: desiredCar.carriage, color: desiredCar.color};
    let wheelsize = desiredCar.wheelsize;

    if (wheelsize % 2 === 0) {
        wheelsize--;
    }

    return {
        model: model,
        engine: engine,
        carriage: carriage,
        wheels: [wheelsize, wheelsize, wheelsize, wheelsize]
    }
}

function extensibleObject() {
    let myObj = {
        __proto__: {},

        extend: function (object) {
            for (let field in object) {
                if (typeof object[field] === 'function') {
                    Object.getPrototypeOf(myObj)[field] = object[field];
                } else {
                    myObj[field] = object[field];
                }
            }

            return myObj;
        }
    };

    return myObj;
}

(function stringExtension() {
    String.prototype.ensureStart = function (str) {
        if (!this.startsWith(str)) {
            return str + "" + this;
        }

        return this + "";
    };

    String.prototype.ensureEnd = function (str) {
        if (!this.endsWith(str)) {
            return this + "" + str;
        }

        return this + "";
    };

    String.prototype.isEmpty = function () {
        return this.length === 0;
    };

    String.prototype.truncate = function (n) {
        if (this.length <= n) {
            return this + "";
        }

        let split = (this + "").split(/\s+/g);

        if (n < 4) {
            return ".".repeat(n);
        }

        if (split.length === 1) {
            return this.substr(0, n - 3) + "...";
        }

        while (true) {
            let stringToCheck = split.join(" ") + "...";

            if (stringToCheck.length <= n) {
                return stringToCheck;
            }

            split.pop();
        }
    };

    String.format = function () {
        let args = [...arguments];
        let string = args.shift();
        let params = args;

        let pattern = /{(\d+)}/g;
        let match = pattern.exec(string);

        while (match) {
            let index = Number(match[1]);

            if (index < 0 || index >= params.length) {
                match = pattern.exec(string);
                continue;
            }

            string = string.replace(`${match[0]}`, params[index]);
            match = pattern.exec(string);
        }

        return string;
    }
})();

let collection = function () {
    return {
        items: [],

        size: 0,

        add: function (element) {
            this.items.push(element);
            this.items.sort((a, b) => a - b);
            this.size++;
        },

        remove: function (index) {
            if (index < 0 || index >= this.items.length) {
                return;
            }

            this.items.splice(index, 1);
            this.size--;
        },

        get: function (index) {
            if (index < 0 || index >= this.items.length) {
                return;
            }

            return this.items[index];
        }
    }
};

function DOMTraversal(selector) {
    let allNodesInSelector = $(`${selector} *`);

    if (allNodesInSelector.length === 0) {
        $(selector).addClass("highlight");
    }

    let deepestLevel = Number.MIN_SAFE_INTEGER;
    let deepestItem;

    for (let node of allNodesInSelector) {
        let numberOfParents = $(node).parentsUntil(selector).length;

        if (numberOfParents > deepestLevel) {
            deepestLevel = numberOfParents;
            deepestItem = node;
        }
    }

    let allParents = $(deepestItem).parentsUntil(selector);
    $(deepestItem).addClass("highlight");

    for (let parent of allParents) {
        $(parent).addClass("highlight");
    }

    $(selector).addClass("highlight");
}