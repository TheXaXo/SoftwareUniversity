function aggregates(arr) {
    return `Sum = ${arr.reduce((a, b) => a + b)}\nMin = ${Math.min.apply(null, arr)}\nMax = ${Math.max.apply(null, arr)}\nProduct = ${arr.reduce((a, b) => a * b)}\nJoin = ${arr.join("")}`;
}

function currencyFormatter(separator, symbol, symbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2, 2);
    if (symbolFirst) return symbol + ' ' + result;
    else return result + ' ' + symbol;
}

function result(formatter) {
    return function (value) {
        return formatter(",", "$", true, value);
    }
}

function commandProcessor(arr) {
    let string = "";

    for (let item of arr) {
        let tokens = item.split(" ");

        switch (tokens[0]) {
            case "append":
                string += tokens[1];
                break;
            case "removeStart":
                let charsToRemoveFromStart = Number(tokens[1]);
                string = string.substring(charsToRemoveFromStart);
                break;
            case "removeEnd":
                let charsToRemoveFromEnd = Number(tokens[1]);
                string = string.substring(0, string.length - charsToRemoveFromEnd);
                break;
            case "print":
                console.log(string);
                break;
        }
    }
}

function maxElement(arr) {
    return Math.max.apply(null, arr);
}