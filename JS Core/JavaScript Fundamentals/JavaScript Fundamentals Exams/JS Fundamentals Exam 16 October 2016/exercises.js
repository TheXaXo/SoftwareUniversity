function arithmephile(arr) {
    arr = arr.map(a => Number(a));

    let biggestProduct = Number.MIN_SAFE_INTEGER;

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < 0 || arr[i] > 9) {
            continue;
        }

        let currentProduct = 1;

        for (let j = 0; j < arr[i]; j++) {
            currentProduct *= arr[i + j + 1];
        }

        if (currentProduct > biggestProduct) {
            biggestProduct = currentProduct;
        }
    }

    console.log(biggestProduct);
}

function rosettaStone(arr) {
    let templateLength = Number(arr[0]);
    let template = [];

    for (let i = 0; i < templateLength; i++) {
        template[i] = [];
        let currentRowElements = arr[i + 1].split(" ").map(a => Number(a));

        for (let element of currentRowElements) {
            template[i].push(element);
        }
    }

    let decodedMessage = [];
    let currentRow = 0;

    for (let i = templateLength + 1; i < arr.length; i++) {
        decodedMessage[currentRow] = [];

        let currentRowElements = arr[i].split(" ").map(a => Number(a));

        for (let element of currentRowElements) {
            decodedMessage[currentRow].push(element);
        }

        currentRow++;
    }

    let finalStringAsArray = [];

    for (let i = 0; i < decodedMessage.length; i += templateLength) {
        for (let j = 0; j < decodedMessage[i].length; j += template[0].length) {
            for (let row = 0; row < templateLength; row++) {
                for (let col = 0; col < template[row].length; col++) {
                    if (i + row >= decodedMessage.length || j + col >= decodedMessage[i + row].length) {
                        continue;
                    }

                    let currentNumber = decodedMessage[i + row][j + col] + template[row][col];
                    let letterIndex = currentNumber % 27;

                    if (letterIndex === 0) {
                        decodedMessage[i + row][j + col] = " ";
                    } else {
                        decodedMessage[i + row][j + col] = String.fromCharCode(64 + letterIndex);
                    }
                }
            }
        }
    }

    for (let i = 0; i < decodedMessage.length; i++) {
        for (let j = 0; j < decodedMessage[i].length; j++) {
            finalStringAsArray.push(decodedMessage[i][j]);
        }
    }

    console.log(finalStringAsArray.join(""));
}

function spyMaster(arr) {
    let key = arr.shift();
    let pattern = new RegExp(`((?:\\s|^)${key}\\s+)([!%$#A-Z]{8,})(\\s|\\.|,|$)`, 'ig');
    let decodedMessages = [];

    for (let line of arr) {
        let decodedMessage = line.replace(pattern, (match, group1, group2, group3) => {
            if (group2.toUpperCase() !== group2) {
                return match;
            }

            return group1 + group2.toLowerCase().replace(/!/g, "1").replace(/%/g, "2").replace(/#/g, "3").replace(/\$/g, "4") + group3;
        });

        decodedMessages.push(decodedMessage);
    }

    console.log(decodedMessages.join("\n"));
}

function radicalMarketing(arr) {
    let peopleSubscribers = new Map();

    for (let line of arr) {
        let tokens = line.split("-");

        if (tokens.length === 1) {
            if (!peopleSubscribers.has(tokens[0])) {
                peopleSubscribers.set(tokens[0], new Set());
            }
        } else {
            let person1 = tokens[0];
            let person2 = tokens[1];

            if (!peopleSubscribers.has(person1)
                || !peopleSubscribers.has(person2)
                || person1 === person2) {
                continue;
            }

            peopleSubscribers.get(person2).add(person1);
        }
    }

    let personWithMostSubscribers = [...peopleSubscribers.entries()].sort((a, b) => {
        let result = b[1].size - a[1].size;

        if (result === 0) {
            let person1SubscribedTo = 0;
            let person2SubscribedTo = 0;

            for (let pair of peopleSubscribers) {
                if (pair[1].has(a[0])) {
                    person1SubscribedTo++;
                }
                if (pair[1].has(b[0])) {
                    person2SubscribedTo++;
                }
            }

            result = person2SubscribedTo - person1SubscribedTo;
        }

        return result;
    })[0];

    let output = `${personWithMostSubscribers[0]}\n`;

    if (personWithMostSubscribers[1].size > 0) {
        for (let i = 0; i < personWithMostSubscribers[1].size; i++) {
            output += `${i + 1}. ${[...personWithMostSubscribers[1].entries()][i][0]}\n`;
        }
    }

    console.log(output);
}