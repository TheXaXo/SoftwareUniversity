function printArrayWithDelimeter(arr) {
    let delimiter = arr[arr.length - 1];
    return arr.slice(0, arr.length - 1).join(delimiter);
}

function printEveryNthElement(arr) {
    let n = Number(arr.pop());
    let output = "";

    for (let i = 0; i < arr.length; i += n) {
        output += arr[i] + "\n";
    }

    return output;
}

function addOrRemoveElement(input) {
    let currentNumber = 1;
    let arr = [];

    for (let command of input) {
        if (command === "add") {
            arr.push(currentNumber++);
        } else {
            arr.pop();
            currentNumber++;
        }
    }

    if (arr.length === 0) {
        return "Empty";
    }

    let output = "";
    arr.forEach(element => output += element + "\n");

    return output;
}

function rotateArray(arr) {
    let rotationsCount = Number(arr.pop());

    for (let i = 0; i < rotationsCount % arr.length; i++) {
        arr.unshift(arr.pop());
    }

    return arr.join(" ");
}

function extractIncreasingSubsequence(arr) {
    let currentMaxElement = Number.MIN_SAFE_INTEGER;
    let resultingArray = [];

    for (let element of arr) {
        if (element >= currentMaxElement) {
            resultingArray.push(element);
            currentMaxElement = element;
        }
    }

    return resultingArray.join("\n");
}

function sortArray(arr) {
    return arr
        .sort((a, b) => {
            let output = a.length - b.length;

            if (output === 0) {
                output = a.toLowerCase().localeCompare(b.toLowerCase());
            }

            return output;
        })
        .join("\n");
}

function magicMatrices(matrix) {
    let sum = matrix[0].reduce((a, b) => a + b);

    for (let i = 1; i < matrix.length; i++) {
        if (sum !== matrix[i].reduce((a, b) => a + b)) {
            return false;
        }
    }

    for (let i = 0; i < matrix[0].length; i++) {
        let currentColumnSum = 0;

        for (let j = 0; j < matrix.length; j++) {
            currentColumnSum += matrix[j][i];
        }

        if (currentColumnSum !== sum) {
            return false;
        }
    }

    return true;
}

function spiralMatrix(rows, columns) {
    let matrix = [];

    for (let i = 0; i < rows; i++) {
        matrix[i] = [];
    }

    let currentNumber = 1;
    let columnsToBeDrawn = columns;
    let rowsToBeDrawn = rows - 2;
    let n = 0;

    while (currentNumber <= rows * columns) {
        for (let col = n; col < columnsToBeDrawn + n; col++) {
            matrix[n][col] = currentNumber++;
        }

        for (let row = n + 1; row <= rowsToBeDrawn + n; row++) {
            matrix[row][columns - n - 1] = currentNumber++;
        }

        if (currentNumber >= rows * columns) {
            break;
        }

        for (let col = columns - n - 1; col >= n; col--) {
            matrix[rows - n - 1][col] = currentNumber++;
        }

        for (let row = rows - n - 2; row > n; row--) {
            matrix[row][n] = currentNumber++;
        }

        rowsToBeDrawn -= 2;
        columnsToBeDrawn -= 2;
        n++;
    }

    return matrix.map(row => row.join(" ")).join("\n");
}

function diagonalAttack(arrayOfStrings) {
    let diagonal1Sum = 0;
    let diagonal2Sum = 0;
    let matrix = [];
    let booleanMatrix = [];

    for (let i = 0; i < arrayOfStrings.length; i++) {
        let tokens = arrayOfStrings[i].split(" ");
        matrix[i] = [];
        booleanMatrix[i] = [];

        for (let j = 0; j < tokens.length; j++) {
            matrix[i][j] = Number(tokens[j]);
            booleanMatrix[i][j] = false;
        }
    }

    for (let i = 0; i < matrix.length; i++) {
        diagonal1Sum += matrix[i][i];
        diagonal2Sum += matrix[i][matrix[i].length - 1 - i];

        booleanMatrix[i][i] = true;
        booleanMatrix[i][matrix[i].length - 1 - i] = true;
    }

    if (diagonal1Sum !== diagonal2Sum) {
        return matrix.map(row => row.join(" ")).join("\n");
    }

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (booleanMatrix[i][j] === false) {
                matrix[i][j] = diagonal1Sum;
            }
        }
    }

    return matrix.map(row => row.join(" ")).join("\n");
}

function orbit(input) {
    let columns = input[0];
    let rows = input[1];
    let starRow = input[2];
    let starCol = input[3];

    let matrix = [];

    for (let i = 0; i < rows; i++) {
        matrix[i] = [];

        for (let j = 0; j < columns; j++) {
            if (i === starRow && j === starCol) {
                matrix[i][j] = 1;
            } else {
                matrix[i][j] = 0;
            }
        }
    }

    let number = 2;

    let i = 0;
    while (i < Math.max(rows, columns)) {
        for (let col = starCol - 1 - i; col <= starCol + 1 + i; col++) {
            if (col >= 0 && starRow - 1 - i >= 0 && col < columns) {
                matrix[starRow - 1 - i][col] = number;
            }

            if (col >= 0 && starRow + 1 + i < rows && col < columns) {
                matrix[starRow + 1 + i][col] = number;
            }
        }

        for (let row = starRow - 1 - i; row <= starRow + 1 + i; row++) {
            if (row >= 0 && row < rows && starCol - 1 - i >= 0) {
                matrix[row][starCol - 1 - i] = number;
            }

            if (row >= 0 && row < rows && starCol + 1 + i < columns) {
                matrix[row][starCol + 1 + i] = number;
            }
        }

        number++;
        i++;
    }

    return matrix.map(row => row.join(" ")).join("\n");
}