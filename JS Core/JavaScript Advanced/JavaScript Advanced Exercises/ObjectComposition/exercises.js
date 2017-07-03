function orderRectangles(arr) {
    let rectangles = [];

    for (let rectTokens of arr) {
        let rectObject = {
            width: rectTokens[0],
            height: rectTokens[1],
            area: function () {
                return this.width * this.height
            },
            compareTo: function (other) {
                let result = other.area() - this.area();

                if (result === 0) {
                    result = other.width - this.width;
                }

                return result;
            }
        };

        rectangles.push(rectObject);
    }

    return rectangles.sort((a, b) => a.compareTo(b));
}

let fibonacci = (function () {
    let a = 0;
    let b = 1;

    return function fibonacci(n) {
        let arr = [];

        for (let i = 0; i < n; i++) {
            let c = a + b;
            a = b;
            b = c;

            arr.push(a);
        }

        return arr;
    };
})();

let listProcessor = (function () {
    let items = [];

    return function (arr) {
        for (let command of arr) {
            let tokens = command.split(" ");

            switch (tokens[0]) {
                case "add":
                    items.push(tokens[1]);
                    break;
                case "remove":
                    let itemIndex = items.indexOf(tokens[1]);

                    while (itemIndex >= 0) {
                        items.splice(itemIndex, 1);
                        itemIndex = items.indexOf(tokens[1]);
                    }
                    break;
                case "print":
                    console.log(items.join(","));
                    break;
            }
        }
    }
})();

let cars = (function () {
    let objects = new Map();

    return function (commands) {
        for (let command of commands) {
            let tokens = command.split(" ");

            switch (tokens[0]) {
                case "create":
                    if (tokens.length === 2) {
                        objects.set(tokens[1], {});
                    } else {
                        objects.set(tokens[1], Object.create(objects.get(tokens[3])));
                    }
                    break;
                case "set":
                    objects.get(tokens[1])[tokens[2]] = tokens[3];
                    break;
                case "print":
                    let pairsAsString = [];
                    let object = objects.get(tokens[1]);

                    for (let key in object) {
                        pairsAsString.push(`${key}:${object[key]}`);
                    }

                    console.log(pairsAsString.join(", "));
                    break;
            }
        }
    }
})();