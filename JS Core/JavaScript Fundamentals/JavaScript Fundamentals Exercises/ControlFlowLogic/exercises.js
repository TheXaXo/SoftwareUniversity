function multiplyNumbers(a, b) {
    console.log(a * b);
}

function boxesAndBottles(bottles, capacityOfBox) {
    console.log(Math.ceil(bottles / capacityOfBox));
}

function leapYear(year) {
    console.log((year % 4 === 0 && year % 100 !== 0) || (year % 400 === 0) ? "yes" : "no");
}

function circleArea(radius) {
    let circleArea = Math.PI * (radius ** 2);
    console.log(circleArea);
    console.log(circleArea.toFixed(2));
}

function triangleArea(a, b, c) {
    let semiperimeter = (a + b + c) / 2;
    console.log(Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c)));
}

function coneVolumeAndSurfaceArea(radius, height) {
    let coneVolume = Math.PI * (radius ** 2) * (height / 3);
    let coneArea = Math.PI * radius * (radius + Math.sqrt(height ** 2 + radius ** 2));

    console.log(`volume = ${coneVolume}\narea = ${coneArea}`);
}

function oddEven(number) {
    if (number % 2 === 0) {
        console.log("even");
    } else if (number % 2 !== 0 && Math.round(number) === number) {
        console.log("odd");
    } else {
        console.log("invalid");
    }
}

function fruitOrVegetable(thingToEat) {
    switch (thingToEat) {
        case "banana":
            console.log("fruit");
            break;
        case "apple":
            console.log("fruit");
            break;
        case "kiwi":
            console.log("fruit");
            break;
        case "cherry":
            console.log("fruit");
            break;
        case "lemon":
            console.log("fruit");
            break;
        case "grapes":
            console.log("fruit");
            break;
        case "peach":
            console.log("fruit");
            break;
        case "tomato":
            console.log("vegetable");
            break;
        case "cucumber":
            console.log("vegetable");
            break;
        case "pepper":
            console.log("vegetable");
            break;
        case "onion":
            console.log("vegetable");
            break;
        case "garlic":
            console.log("vegetable");
            break;
        case "parsley":
            console.log("vegetable");
            break;
        default:
            console.log("unknown");
            break;
    }
}

function colorfulNumbers(n) {
    let output = "<ul>\n";
    let currentColor;

    for (let i = 1; i <= n; i++) {
        if (i % 2 === 0) {
            currentColor = "blue";
        } else {
            currentColor = "green"
        }

        output += `\t<li><span style='color:${currentColor}'>${i}</span></li>\n`
    }

    console.log(output + "</ul>");
}

function chessBoard(n) {
    let output = "<div class=\"chessboard\">\n";
    let currentColor = "black";
    let colorOfTheFirstColumnOfTheRowBefore;

    for (let i = 0; i < n; i++) {
        output += "\t<div>\n";

        for (let j = 0; j < n; j++) {
            if (j === 0) {
                colorOfTheFirstColumnOfTheRowBefore = currentColor;
            }

            output += `\t\t<span class="${currentColor}"></span>\n`;

            if (currentColor === "black") {
                currentColor = "white";
            } else {
                currentColor = "black";
            }
        }

        if (colorOfTheFirstColumnOfTheRowBefore === "black") {
            currentColor = "white";
        } else {
            currentColor = "black";
        }

        output += "\t</div>\n";
    }

    output += "</div>";
    console.log(output);
}

function binaryLogarithm(arrayOfNumbers) {
    for (let number of arrayOfNumbers) {
        console.log(Math.log2(number));
    }
}

function isPrime(number) {
    if (number <= 1) {
        return false;
    }

    for (let numberToCheck = 2; numberToCheck < number; numberToCheck++) {
        if (number % numberToCheck === 0) {
            return false;
        }
    }

    return true;
}