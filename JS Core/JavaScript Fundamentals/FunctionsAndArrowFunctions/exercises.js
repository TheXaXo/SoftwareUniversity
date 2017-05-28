function triangleOfStars(n) {
    let output = "";

    for (let i = 0; i < n; i++) {
        for (let j = 0; j <= i; j++) {
            output += "*";
        }

        output += "\n";
    }

    for (let i = 0; i < n - 1; i++) {
        for (let j = n - 2 - i; j >= 0; j--) {
            output += "*";
        }

        output += "\n";
    }

    return output;
}

function rectangleOfStars(n = 5) {
    let output = "";

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            output += "* ";
        }

        output += "\n";
    }

    return output;
}

function palindrome(word) {
    let currentLetterIndex = 0;

    for (let i = word.length - 1; i >= Math.floor(word.length / 2); i--) {
        if (word[currentLetterIndex++] !== word[i]) {
            return false;
        }
    }

    return true;
}

function dayOfWeek(dayOfWeek) {
    switch (dayOfWeek) {
        case "Monday" :
            return 1;
        case "Tuesday" :
            return 2;
        case "Wednesday" :
            return 3;
        case "Thursday" :
            return 4;
        case "Friday" :
            return 5;
        case "Saturday" :
            return 6;
        case "Sunday" :
            return 7;
        default :
            return "error";
    }
}

function functionalCalculator(a, b, operation) {
    function add() {
        return a + b;
    }

    function subtract() {
        return a - b;
    }

    function multiply() {
        return a * b;
    }

    function divide() {
        return a / b;
    }

    switch (operation) {
        case "+":
            return add();
        case "-":
            return subtract();
        case "*":
            return multiply();
        case "/":
            return divide();
    }
}

function aggregateElements(arr) {
    let sum = 0;
    let inverseSum = 0;
    let concatOut = "";

    arr.forEach(a => {
        sum += a;
        inverseSum += 1 / a;
        concatOut += a;
    });

    console.log(sum);
    console.log(inverseSum);
    console.log(concatOut);
}

function wordsUpperCase(sentence) {
    let pattern = /\w+/g;
    let output = "";

    let match = pattern.exec(sentence);
    while (match) {
        output += (match[0].toUpperCase() + ", ");
        match = pattern.exec(sentence);
    }

    return output.substring(0, output.length - 2);
}