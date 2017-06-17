function daggersAndSwords(arr) {
    let output = "<table border=\"1\">\n<thead>\n<tr><th colspan=\"3\">Blades</th></tr>\n<tr><th>Length [cm]</th><th>Type</th><th>Application</th></tr>\n</thead>\n<tbody>\n";

    for (let line of arr) {
        let length = Math.floor(Number(line));

        if (length < 11) {
            continue;
        }

        let type = "dagger";

        if (length > 40) {
            type = "sword";
        }

        let lengthConverted = length % 5;
        let application = "";

        switch (lengthConverted) {
            case 1:
                application = "blade";
                break;
            case 2:
                application = "quite a blade";
                break;
            case 3:
                application = "pants-scraper";
                break;
            case 4:
                application = "frog-butcher";
                break;
            case 0:
                application = "*rap-poker";
                break;
        }

        output += `<tr><td>${length}</td><td>${type}</td><td>${application}</td></tr>\n`
    }

    output += "</tbody>\n</table>";
    console.log(output);
}

function xRemove(arr) {
    let matrix = [];
    let booleanMatrix = [];

    for (let i = 0; i < arr.length; i++) {
        matrix.push([]);
        booleanMatrix.push([]);

        for (let symbol of arr[i]) {
            matrix[i].push(symbol);
            booleanMatrix[i].push(true);
        }
    }


    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            let isFormedCross = true;
            let symbol = matrix[row][col];
            let rowCount = 0;

            for (let innerRow = row; innerRow <= row + 2; innerRow++) {
                let leftDiagonalIndex = col + rowCount;
                let rightDiagonalIndex = col + 2 - rowCount;

                if (innerRow >= matrix.length
                    || leftDiagonalIndex >= matrix[innerRow].length
                    || rightDiagonalIndex < 0
                    || matrix[innerRow][leftDiagonalIndex] === undefined
                    || matrix[innerRow][rightDiagonalIndex] === undefined) {
                    isFormedCross = false;
                    break;
                }

                if (!(matrix[innerRow][leftDiagonalIndex].toLowerCase() === matrix[innerRow][rightDiagonalIndex].toLowerCase()
                    && matrix[innerRow][leftDiagonalIndex].toLowerCase() === symbol.toLowerCase())) {
                    isFormedCross = false;
                    break;
                }

                rowCount++;
            }

            if (isFormedCross) {
                let rowCount = 0;

                for (let innerRow = row; innerRow <= row + 2; innerRow++) {
                    let leftDiagonalIndex = col + rowCount;
                    let rightDiagonalIndex = col + 2 - rowCount;

                    booleanMatrix[innerRow][leftDiagonalIndex] = false;
                    booleanMatrix[innerRow][rightDiagonalIndex] = false;

                    rowCount++;
                }
            }
        }
    }

    let output = "";

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (booleanMatrix[row][col] === true) {
                output += matrix[row][col]
            }
        }

        output += "\n";
    }

    console.log(output);
}

function queryMess(arr) {
    let output = "";

    for (let line of arr) {
        line = line.replace(/(\+|%20)/g, " ");

        let items = new Map();
        let tokens = line.split("?");

        for (let token of tokens) {
            let parts = token.split("&");

            for (let part of parts) {
                part = part.replace(/\s+/g, " ");

                let pair = part.split("=");

                if (pair.length === 1) {
                    continue;
                }

                let key = pair[0].trim();
                let value = pair[1].trim();

                if (!items.has(key)) {
                    items.set(key, []);
                }

                items.get(key).push(value);
            }
        }

        for (let pair of items) {
            output += `${pair[0]}=[${pair[1].join(", ")}]`;
        }

        output += "\n";
    }

    console.log(output);
}

function vladkoNotebook(arr) {
    arr = arr.filter(a => a.length > 0);

    let colorObject = new Map();

    for (let line of arr) {
        let tokens = line.split("|");

        let color = tokens[0];
        let type = tokens[1];
        let value = tokens[2];

        if (!colorObject.has(color)) {
            colorObject.set(color, {age: undefined, name: undefined, opponents: [], wins: 0, looses: 0});
        }

        let object = colorObject.get(color);

        if (type === "name") {
            object.name = value;
        } else if (type === "age") {
            object.age = value;
        } else if (type === "win") {
            object.wins++;
            object.opponents.push(value);
        } else if (type === "loss") {
            object.looses++;
            object.opponents.push(value);
        }
    }

    let output = "{";
    let colorObjectsSorted = [...colorObject.entries()].sort((a, b) => {
        if (a[0] > b[0]) {
            return 1;
        } else if (a[0] < b[0]) {
            return -1;
        } else {
            return 0;
        }
    });

    for (let pair of colorObjectsSorted) {
        let color = pair[0];
        let object = pair[1];

        if (object.name === undefined || object.age === undefined) {
            continue;
        }

        output += `\"${color}\":{`;
        output += `\"age\":\"${object.age}\",`;
        output += `\"name\":\"${object.name}\",`;

        let opponentsSorted = object.opponents.sort((a, b) => {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        });

        output += `\"opponents\":${JSON.stringify(opponentsSorted)},\"rank\":`;
        let rank = ((object.wins + 1) / (object.looses + 1)).toFixed(2);
        output += `\"${rank}\"},`;
    }

    output = output.substring(0, output.length - 1);
    output += "}";

    console.log(output);
}