function insideVolume(arr) {
    let output = "";

    let x1 = 10;
    let x2 = 50;
    let y1 = 20;
    let y2 = 80;
    let z1 = 15;
    let z2 = 50;

    for (let i = 0; i < arr.length; i += 3) {
        let pointX = arr[i];
        let pointY = arr[i + 1];
        let pointZ = arr[i + 2];

        if (pointX >= x1 && pointX <= x2
            && pointY >= y1 && pointY <= y2
            && pointZ >= z1 && pointZ <= z2) {
            output += "inside\n";
        } else {
            output += "outside\n";
        }
    }

    return output;
}

function roadRadar(arr) {
    let currentSpeed = arr[0];
    let currentRoadType = arr[1];

    let speedOverLimit = 0;
    let typeOfSpeeding = undefined;

    switch (currentRoadType) {
        case "motorway":
            speedOverLimit = currentSpeed - 130;
            break;
        case "interstate":
            speedOverLimit = currentSpeed - 90;
            break;
        case "city":
            speedOverLimit = currentSpeed - 50;
            break;
        case "residential":
            speedOverLimit = currentSpeed - 20;
            break;
    }

    if (speedOverLimit > 40) {
        typeOfSpeeding = "reckless driving";
    } else if (speedOverLimit > 20) {
        typeOfSpeeding = "excessive speeding";
    } else if (speedOverLimit > 0) {
        typeOfSpeeding = "speeding";
    } else {
        typeOfSpeeding = "";
    }

    return typeOfSpeeding;
}

function templateFormat(arr) {
    let output = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<quiz>\n";

    for (let i = 0; i < arr.length; i += 2) {
        let question = arr[i];
        let answer = arr[i + 1];

        output += `\t<question>\n\t\t${question}\n\t</question>\n\t<answer>\n\t\t${answer}\n\t</answer>\n`;
    }

    output += "</quiz>";
    return output;
}

function cookingByNumbers(arr) {
    let output = "";
    let number = Number(arr[0]);

    for (let i = 1; i < arr.length; i++) {
        let operation = arr[i];

        switch (operation) {
            case "chop":
                number /= 2;
                break;
            case "dice":
                number = Math.sqrt(number);
                break;
            case "spice":
                number += 1;
                break;
            case "bake":
                number *= 3;
                break;
            case "fillet":
                number *= 0.8;
                break;
        }

        output += `${number}\n`;
    }

    return output;
}

function modifyAverage(number) {
    let numberStr = "" + number;

    while (getAverageFromDigits(numberStr) <= 5) {
        numberStr += "9";
    }

    function getAverageFromDigits(numberStr) {
        let sum = 0;

        for (let digitStr of numberStr) {
            sum += Number(digitStr);
        }

        return sum / numberStr.length;
    }

    return numberStr;
}

function validityChecker(arr) {
    let output = "";

    let x1 = Number(arr[0]);
    let y1 = Number(arr[1]);
    let x2 = Number(arr[2]);
    let y2 = Number(arr[3]);

    if (isValidDistance(x1, y1, 0, 0)) {
        output += `{${x1}, ${y1}} to {0, 0} is valid\n`;
    } else {
        output += `{${x1}, ${y1}} to {0, 0} is invalid\n`;
    }

    if (isValidDistance(x2, y2, 0, 0)) {
        output += `{${x2}, ${y2}} to {0, 0} is valid\n`;
    } else {
        output += `{${x2}, ${y2}} to {0, 0} is invalid\n`;
    }

    if (isValidDistance(x1, y1, x2, y2)) {
        output += `{${x1}, ${y1}} to {${x2}, ${y2}} is valid\n`;
    } else {
        output += `{${x1}, ${y1}} to {${x2}, ${y2}} is invalid\n`
    }

    function isValidDistance(x1, y1, x2, y2) {
        let distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        let fakeNum = "" + distance;
        return fakeNum.indexOf(".") === -1;
    }

    return output;
}

function treasureLocator(arr) {
    let output = "";

    for (let i = 0; i < arr.length; i += 2) {
        let treasureX = arr[i];
        let treasureY = arr[i + 1];

        if (treasureX >= 0 && treasureX <= 2
            && treasureY >= 6 && treasureY <= 8) {
            output += "Tonga\n";
        } else if (treasureX >= 1 && treasureX <= 3
            && treasureY >= 1 && treasureY <= 3) {
            output += "Tuvalu\n";
        } else if (treasureX >= 5 && treasureX <= 7
            && treasureY >= 3 && treasureY <= 6) {
            output += "Samoa\n";
        } else if (treasureX >= 4 && treasureX <= 9
            && treasureY >= 7 && treasureY <= 8) {
            output += "Cook\n";
        } else if (treasureX >= 8 && treasureX <= 9
            && treasureY >= 0 && treasureY <= 1) {
            output += "Tokelau\n";
        } else {
            output += "On the bottom of the ocean\n";
        }
    }

    return output;
}

function tripLength(arr) {
    let x1 = arr[0];
    let y1 = arr[1];
    let x2 = arr[2];
    let y2 = arr[3];
    let x3 = arr[4];
    let y3 = arr[5];

    let point1 = {name: 1, x: x1, y: y1};
    let point2 = {name: 2, x: x2, y: y2};
    let point3 = {name: 3, x: x3, y: y3};

    let points = [point1, point2, point3];

    let minLength = Number.MAX_SAFE_INTEGER;
    let minOutput = "";
    let minFirstPointName = 0;

    for (let firstPoint of points) {
        for (let secondPoint of points) {
            if (firstPoint === secondPoint) {
                continue;
            }

            for (let thirdPoint of points) {
                if (secondPoint === thirdPoint || firstPoint === thirdPoint) {
                    continue;
                }

                let length = distanceBetweenPoints(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y) +
                    distanceBetweenPoints(secondPoint.x, secondPoint.y, thirdPoint.x, thirdPoint.y);

                if (length < minLength || (length === minLength && firstPoint.name < minFirstPointName)) {
                    minLength = length;
                    minOutput = `${firstPoint.name}->${secondPoint.name}->${thirdPoint.name}: ${length}`;
                    minFirstPointName = firstPoint.name;
                }
            }
        }
    }

    function distanceBetweenPoints(x1, y1, x2, y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    return minOutput;
}

function radioCrystals(arr) {
    let output = "";
    let desiredThickness = arr[0];

    for (let i = 1; i < arr.length; i++) {
        let chunkThickness = arr[i];
        output += `Processing chunk ${chunkThickness} microns\n`;

        let timesCut = 0;
        while (chunkThickness * 0.25 >= desiredThickness || (chunkThickness * 0.25 === desiredThickness - 1)) {
            chunkThickness *= 0.25;
            timesCut++;
        }

        if (timesCut > 0) {
            output += `Cut x${timesCut}\nTransporting and washing\n`;
            chunkThickness = Math.floor(chunkThickness);
        }

        if (chunkThickness === desiredThickness - 1) {
            output += `X-ray x1\nFinished crystal ${desiredThickness} microns\n`;
            return output;
        }

        let timesLapped = 0;
        while (chunkThickness * 0.8 >= desiredThickness || (chunkThickness * 0.8 === desiredThickness - 1)) {
            chunkThickness *= 0.8;
            timesLapped++;
        }

        if (timesLapped > 0) {
            output += `Lap x${timesLapped}\nTransporting and washing\n`;
            chunkThickness = Math.floor(chunkThickness);
        }

        if (chunkThickness === desiredThickness - 1) {
            output += `X-ray x1\nFinished crystal ${desiredThickness} microns\n`;
            return output;
        }

        let timesGrinded = 0;
        while (chunkThickness - 20 >= desiredThickness || (chunkThickness - 20 === desiredThickness - 1)) {
            chunkThickness -= 20;
            timesGrinded++;
        }

        if (timesGrinded > 0) {
            output += `Grind x${timesGrinded}\nTransporting and washing\n`;
            chunkThickness = Math.floor(chunkThickness);
        }

        if (chunkThickness === desiredThickness - 1) {
            output += `X-ray x1\nFinished crystal ${desiredThickness} microns\n`;
            return output;
        }

        let timesEtched = 0;
        while (chunkThickness - 2 >= desiredThickness || (chunkThickness - 2 === desiredThickness - 1)) {
            chunkThickness -= 2;
            timesEtched++;
        }

        if (timesEtched > 0) {
            output += `Etch x${timesEtched}\nTransporting and washing\n`;
            chunkThickness = Math.floor(chunkThickness);
        }

        if (chunkThickness === desiredThickness - 1) {
            output += `X-ray x1\nFinished crystal ${desiredThickness} microns\n`;
            return output;
        }

        output += `Finished crystal ${desiredThickness} microns\n`;
    }

    return output;
}

function dnaHelix(n) {
    let output = "";

    let letters = ["A", "T", "C", "G", "T", "T", "A", "G", "G", "G"];
    let starsCount = [2, 1, 0, 1];
    let dashesCount = [0, 2, 4, 2];

    for (let i = 0; i < n; i++) {
        let currentStarsCount = starsCount.shift();
        let currentDashesCount = dashesCount.shift();

        starsCount.push(currentStarsCount);
        dashesCount.push(currentDashesCount);

        for (let j = 0; j < currentStarsCount; j++) {
            output += "*";
        }

        let currentLetter = letters.shift();
        letters.push(currentLetter);

        output += currentLetter;

        for (let j = 0; j < currentDashesCount; j++) {
            output += "-";
        }

        currentLetter = letters.shift();
        letters.push(currentLetter);

        output += currentLetter;

        for (let j = 0; j < currentStarsCount; j++) {
            output += "*";
        }

        output += "\n";
    }

    return output;
}