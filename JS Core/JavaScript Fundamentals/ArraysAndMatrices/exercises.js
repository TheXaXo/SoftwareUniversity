function sumFirstAndLast(arr) {
    return Number(arr[0]) + Number(arr[arr.length - 1]);
}

function evenPositionElement(arr) {
    let output = "";

    for (let i = 0; i < arr.length; i += 2) {
        output += arr[i] + " ";
    }

    return output;
}

function negativePositiveNumbers(arr) {
    let newArr = [];

    for (let element of arr) {
        if (element < 0) {
            newArr.unshift(element);
        } else {
            newArr.push(element);
        }
    }

    return newArr;
}

function firstAndLastKNumbers(arr) {
    let k = arr[0];
    arr = arr.slice(1);

    let output = "";
    output += arr.slice(0, k).join(" ") + "\n";
    output += arr.slice(arr.length - k, arr.length).join(" ") + "\n";

    return output;
}

function lastKNumbersSequence(n, k) {
    let arr = [1];

    for (let i = 0; i < n - 1; i++) {
        let sum = 0;
        arr.slice(-k).forEach(item => sum += item);
        arr.push(sum);
    }

    return arr.join(" ");
}

function processOddNumbers(arr) {
    return arr
        .filter((number, index) => index % 2 !== 0)
        .map(element => element * 2)
        .reverse()
        .join(" ");
}

function smallestTwoNumbers(arr) {
    return arr
        .sort((a, b) => a - b)
        .slice(0, 2)
        .join(" ");
}

function biggestElement(matrix) {
    let biggestElement = Number.MIN_SAFE_INTEGER;

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] > biggestElement) {
                biggestElement = matrix[i][j];
            }
        }
    }

    return biggestElement;
}

function diagonalSums(matrix) {
    let diagonal1Sum = 0;
    let diagonal2Sum = 0;

    for (let i = 0; i < matrix.length; i++) {
        diagonal1Sum += matrix[i][i];
        diagonal2Sum += matrix[i][matrix[i].length - 1 - i];
    }

    return diagonal1Sum + " " + diagonal2Sum;
}

function equalNeighbours(matrix) {
    let neighboursCount = 0;

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            let currentElement = matrix[i][j];

            if (i + 1 < matrix.length && matrix[i + 1].length > j && matrix[i + 1][j] === currentElement) {
                neighboursCount++;
            }
            if (j + 1 < matrix[i].length && matrix[i][j + 1] === currentElement) {
                neighboursCount++;
            }
        }
    }

    return neighboursCount;
}