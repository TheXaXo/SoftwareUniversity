function helloJavaScript(name) {
    return `Hello, ${name}, I am JavaScript!`
}

function areaAndPerimeterOfRectangle(a, b) {
    return a * b + "\n" + 2 * (a + b);
}

function distanceOverTime(arr) {
    let v1 = arr[0];
    let v2 = arr[1];
    let time = arr[2];

    let timeInHours = time / 60 / 60;

    let distance1InMeters = v1 * timeInHours * 1000;
    let distance2InMeters = v2 * timeInHours * 1000;

    return Math.abs(distance1InMeters - distance2InMeters);
}

function distanceIn3D(arr) {
    let x1 = arr[0];
    let y1 = arr[1];
    let z1 = arr[2];

    let x2 = arr[3];
    let y2 = arr[4];
    let z2 = arr[5];

    return Math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2 + (z2 - z1) ** 2);
}

function convert(grads) {
    let converted = (grads * 0.9) % 360;

    if (converted < 0) {
        console.log(converted + 360);
    } else {
        console.log(converted);
    }
}

function compoundInterest(arr) {
    let principalSum = arr[0];
    let interestRate = arr[1];
    let compoundingPeriod = arr[2];
    let totalSpanInYears = arr[3];

    let frequency = 12 / compoundingPeriod;

    return (principalSum * Math.pow((1 + ((interestRate / 100) / frequency)), frequency * totalSpanInYears)).toFixed(2)
}

function rounding(arr) {
    let number = arr[0];
    let precision = arr[1];

    number = number * 10 ** precision;
    return Math.round(number) / 10 ** precision;
}

function imperialUnits(inches) {
    let feet = Math.floor(inches / 12);
    let leftOverFeet = ((inches / 12 - feet) * 12).toFixed(0);

    return `${feet}'-${leftOverFeet}"`;
}

function nowPlaying(arr) {
    let nameOfTrack = arr[0];
    let nameOfArtist = arr[1];
    let duration = arr[2];

    return `Now Playing: ${nameOfArtist} - ${nameOfTrack} [${duration}]`;
}

function composeTag(arr) {
    let location = arr[0];
    let text = arr[1];

    return `<img src="${location}" alt="${text}">`;
}

function binaryToDecimal(binary) {
    let powerOfTwo = 0;
    let sum = 0;

    for (let i = binary.length - 1; i >= 0; i--) {
        let currentNumber = Number(binary[i]);

        if (currentNumber === 1) {
            sum += 2 ** powerOfTwo;
        }

        powerOfTwo++;
    }

    return sum;
}

function assignProperties(arr) {
    let key1 = arr[0];
    let val1 = arr[1];
    let key2 = arr[2];
    let val2 = arr[3];
    let key3 = arr[4];
    let val3 = arr[5];

    return {[key1]: val1, [key2]: val2, [key3]: val3};
}

function lastMonth(arr) {
    let month = Number(arr[1]);
    let year = Number(arr[2]);

    if (month === 1) {
        month = 12;
        year -= 1;
    } else if (month === 12) {
        month = 1;
        year += 1;
    } else {
        month -= 1;
    }

    let date = new Date(year, month, 0);
    return date.getDate();
}

function biggestOfThreeNumbers(arr) {
    let biggestNumber = Number.MIN_SAFE_INTEGER;

    for (let number of arr) {
        if (number > biggestNumber) {
            biggestNumber = number;
        }
    }

    return biggestNumber;
}

function pointInRectangle(arr) {
    let pointX = arr[0];
    let pointY = arr[1];
    let minX = arr[2];
    let maxX = arr[3];
    let minY = arr[4];
    let maxY = arr[5];

    if (pointX >= minX && pointX <= maxX && pointY >= minY && pointY <= maxY) {
        return "inside";
    }

    return "outside";
}

function oddNumbersToN(n) {
    let output = "";

    for (let i = 1; i <= n; i += 2) {
        output = output + i + "\n";
    }

    return output;
}

function triangleOfDollars(n) {
    let output = "";

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < i + 1; j++) {
            output += "$";
        }

        output += "\n";
    }

    return output;
}

function moviePrices(arr) {
    let movieTitle = arr[0].toLowerCase();
    let dayOfWeek = arr[1].toLowerCase();

    switch (movieTitle) {
        case "the godfather":
            switch (dayOfWeek) {
                case "monday":
                    return 12;
                case "tuesday":
                    return 10;
                case "wednesday":
                    return 15;
                case "thursday":
                    return 12.50;
                case "friday":
                    return 15;
                case "saturday":
                    return 25;
                case "sunday":
                    return 30;
                default :
                    return "error"
            }
        case "schindler's list":
            switch (dayOfWeek) {
                case "monday":
                    return 8.50;
                case "tuesday":
                    return 8.50;
                case "wednesday":
                    return 8.50;
                case "thursday":
                    return 8.50;
                case "friday":
                    return 8.50;
                case "saturday":
                    return 15;
                case "sunday":
                    return 15;
                default :
                    return "error"
            }
        case "casablanca":
            switch (dayOfWeek) {
                case "monday":
                    return 8;
                case "tuesday":
                    return 8;
                case "wednesday":
                    return 8;
                case "thursday":
                    return 8;
                case "friday":
                    return 8;
                case "saturday":
                    return 10;
                case "sunday":
                    return 10;
                default :
                    return "error"
            }
        case "the wizard of oz":
            switch (dayOfWeek) {
                case "monday":
                    return 10;
                case "tuesday":
                    return 10;
                case "wednesday":
                    return 10;
                case "thursday":
                    return 10;
                case "friday":
                    return 10;
                case "saturday":
                    return 15;
                case "sunday":
                    return 15;
                default :
                    return "error"
            }
        default:
            return "error";
    }
}

function quadraticEquation(a, b, c) {
    let discriminant = b ** 2 - (4 * a * c);

    if (discriminant > 0) {
        let x1 = ((b * -1) + Math.sqrt(discriminant)) / (2 * a);
        let x2 = ((b * -1) - Math.sqrt(discriminant)) / (2 * a);

        console.log(Math.min(x1, x2) + "\n" + Math.max(x1, x2));
    } else if (discriminant === 0) {
        console.log((b * -1) / (2 * a));
    } else {
        console.log("No");
    }
}

function multiplicationTable(n) {
    let output = "<table border=\"1\">\n";
    output += "\t<tr><th>x</th>";

    for (let i = 0; i < n; i++) {
        output += `<th>${i + 1}</th>`
    }

    output += "</tr>\n";

    for (let i = 1; i <= n; i++) {
        output += `\t<tr><th>${i}</th>`;

        for (let j = 1; j <= n; j++) {
            output += `<td>${i * j}</td>`
        }

        output += "</tr>\n"
    }

    output += "</table>";
    return output;
}

function figureOf4Squares(n) {
    let output = "";

    if (n % 2 === 0) {
        for (let i = 0; i < n - 1; i++) {
            if ((i === 0 || i === n - 2) || (i === n / 2 - 1)) {
                output += "+";

                for (let j = 0; j < n - 2; j++) {
                    output += "-";
                }

                output += "+";

                for (let j = 0; j < n - 2; j++) {
                    output += "-";
                }

                output += "+";
            } else {
                output += "|";

                for (let j = 0; j < n - 2; j++) {
                    output += " ";
                }

                output += "|";

                for (let j = 0; j < n - 2; j++) {
                    output += " ";
                }

                output += "|";
            }

            output += "\n";
        }
    } else {
        for (let i = 0; i < n; i++) {
            if ((i === 0 || i === n - 1) || (i === Math.floor(n / 2))) {
                output += "+";

                for (let j = 0; j < n - 2; j++) {
                    output += "-";
                }

                output += "+";

                for (let j = 0; j < n - 2; j++) {
                    output += "-";
                }

                output += "+";
            } else {
                output += "|";

                for (let j = 0; j < n - 2; j++) {
                    output += " ";
                }

                output += "|";

                for (let j = 0; j < n - 2; j++) {
                    output += " ";
                }

                output += "|";
            }

            output += "\n";
        }
    }
    return output;
}