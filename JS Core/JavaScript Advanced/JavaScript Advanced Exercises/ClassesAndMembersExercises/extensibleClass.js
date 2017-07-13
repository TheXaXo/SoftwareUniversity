let extensible = (function () {
    let currentID = 0;

    return class Extensible {
        constructor() {
            this.id = currentID++;
        }

        extend(object) {
            for (let field in object) {
                if (typeof object[field] === 'function') {
                    Extensible.prototype[field] = object[field];
                } else {
                    this[field] = object[field];
                }
            }
        }
    }
})();

let extensibleClass = extensible;
let obj1 = new extensibleClass;
let obj2 = new extensibleClass;
let debug = "";