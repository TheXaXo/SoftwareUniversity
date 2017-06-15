function medenkaWars(arr) {
    arr = arr.filter(a => a.length > 0);

    let vitkorDealtDamage = 0;
    let naskorDealtDamage = 0;

    let vitkorAttackNumber = 0;
    let naskorAttackNumber = 0;

    let vitkorLastDamage = Number.MIN_SAFE_INTEGER;
    let naskorLastDamage = Number.MIN_SAFE_INTEGER;

    for (let line of arr) {
        let tokens = line.split(/\s+/g).filter(a => a.length > 0);
        let medenkaCount = Number(tokens[0]);
        let medenkaType = tokens[1];
        let dealtDamage = medenkaCount * 60;

        if (medenkaType === "white") {
            if (vitkorLastDamage === Number.MIN_SAFE_INTEGER) {
                vitkorLastDamage = dealtDamage;
                vitkorAttackNumber++;
                vitkorDealtDamage += dealtDamage;

                continue;
            }

            if (vitkorLastDamage === dealtDamage) {
                vitkorAttackNumber++;

                if (vitkorAttackNumber === 2) {
                    dealtDamage *= 2.75;
                    vitkorAttackNumber = 1;
                }
            } else {
                vitkorAttackNumber = 1;
            }

            vitkorLastDamage = dealtDamage;
            vitkorDealtDamage += dealtDamage;
        } else {
            if (naskorLastDamage === Number.MIN_SAFE_INTEGER) {
                naskorLastDamage = dealtDamage;
                naskorAttackNumber++;
                naskorDealtDamage += dealtDamage;

                continue;
            }

            if (naskorLastDamage === dealtDamage) {
                naskorAttackNumber++;

                if (naskorAttackNumber === 5) {
                    dealtDamage *= 4.5;
                    naskorAttackNumber = 1;
                }
            } else {
                naskorAttackNumber = 1;
            }

            naskorLastDamage = dealtDamage;
            naskorDealtDamage += dealtDamage;
        }

    }

    if (vitkorDealtDamage > naskorDealtDamage) {
        console.log(`Winner - Vitkor\nDamage - ${vitkorDealtDamage}`);
    } else {
        console.log(`Winner - Naskor\nDamage - ${naskorDealtDamage}`);
    }
}

function bunnyKill(arr) {
    arr = arr.filter(a => a.length > 0);

    let matrix = [];

    for (let i = 0; i < arr.length - 1; i++) {
        let tokens = arr[i].split(" ").map(a => Number(a));
        matrix.push([]);

        for (let bunny of tokens) {
            matrix[i].push(bunny);
        }
    }

    let bombIndexes = arr[arr.length - 1].split(" ");
    let bunniesDamageTaken = 0;
    let bunniesKilled = 0;

    for (let bombIndex of bombIndexes) {
        let tokens = bombIndex.split(",").map(a => Number(a));
        let bombRow = tokens[0];
        let bombCol = tokens[1];
        let bombPower = matrix[bombRow][bombCol];

        if (bombPower <= 0) {
            continue;
        }

        for (let row = bombRow - 1; row <= bombRow + 1; row++) {
            for (let col = bombCol - 1; col <= bombCol + 1; col++) {
                if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
                    continue;
                }

                matrix[row][col] -= bombPower;
            }
        }

        bunniesKilled++;
        bunniesDamageTaken += bombPower;
    }

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col] > 0) {
                bunniesDamageTaken += matrix[row][col];
                bunniesKilled++;
            }
        }
    }

    console.log(`${bunniesDamageTaken}\n${bunniesKilled}`);
}

function AJAXRequestValidator(arr) {
    arr = arr.filter(a => a.length > 0);

    let hashPattern = arr.pop();
    let output = "";

    let methodPattern = /^Method: (GET|POST|PUT|DELETE)$/g;
    let credentialsPattern = /^Credentials: (Basic|Bearer)\s([A-Za-z0-9]+)$/g;
    let contentPattern = /^Content: ([A-Za-z0-9.]+)$/g;

    for (let i = 0; i < arr.length; i += 3) {
        let methodString = arr[i];
        let credentialsString = arr[i + 1];
        let contentString = arr[i + 2];

        methodPattern.lastIndex = 0;
        credentialsPattern.lastIndex = 0;
        contentPattern.lastIndex = 0;

        let methodMatch = methodPattern.exec(methodString);
        let credentialsMatch = credentialsPattern.exec(credentialsString);
        let contentMatch = contentPattern.exec(contentString);

        if (!methodMatch || !credentialsMatch || !contentMatch) {
            output += "Response-Code:400\n";
            continue;
        }

        let authorizationType = credentialsMatch[1];
        let methodType = methodMatch[1];

        if (authorizationType === "Basic" && methodType !== "GET") {
            output += `Response-Method:${methodType}&Code:401\n`;
            continue;
        }

        let isHashPatternValid = true;

        for (let j = 0; j < hashPattern.length; j += 2) {
            let numberOfOccurrences = Number(hashPattern[j]);
            let letter = hashPattern[j + 1];

            let pattern = new RegExp(`${letter}`, 'g');
            pattern.lastIndex = 0;

            let currentNumberOfOccurrences = 0;
            let authorizationCode = credentialsMatch[2];
            let match = pattern.exec(authorizationCode);

            while (match) {
                currentNumberOfOccurrences++;
                match = pattern.exec(authorizationCode);
            }

            if (numberOfOccurrences === currentNumberOfOccurrences) {
                break;
            } else {
                isHashPatternValid = false;
            }
        }

        if (!isHashPatternValid) {
            output += `Response-Method:${methodType}&Code:403\n`;
        } else {
            output += `Response-Method:${methodType}&Code:200&Header:${credentialsMatch[2]}\n`;
        }
    }

    console.log(output);
}

function angularParser(arr) {
    arr = arr.filter(a => a.length > 0);

    let registeredApps = new Map();
    let nonRegisteredApps = new Map();

    for (let line of arr) {
        let tokens = line.split("&");

        if (tokens.length === 1) {
            let appPattern = /\$.+?='(.+?)'/g;
            let appName = appPattern.exec(tokens[0])[1];

            if (nonRegisteredApps.has(appName)) {
                let object = nonRegisteredApps.get(appName);
                nonRegisteredApps.delete(appName);
                registeredApps.set(appName, object);

                continue;
            }

            registeredApps.set(appName, {controllers: [], models: [], views: []});
        } else {
            let pattern = /\$(.+?)='(.+?)'&app='(.+?)'/g;
            let match = pattern.exec(line);

            let elementType = match[1];
            let elementName = match[2];
            let appName = match[3];

            if (registeredApps.has(appName)) {
                let currentAppObject = registeredApps.get(appName);

                if (elementType === "controller") {
                    currentAppObject.controllers.push(elementName);
                } else if (elementType === "model") {
                    currentAppObject.models.push(elementName);
                } else {
                    currentAppObject.views.push(elementName);
                }
            } else {
                let object = {controllers: [], models: [], views: []};

                if (nonRegisteredApps.has(appName)) {
                    object = nonRegisteredApps.get(appName);
                }

                if (elementType === "controller") {
                    object.controllers.push(elementName);
                } else if (elementType === "model") {
                    object.models.push(elementName);
                } else {
                    object.views.push(elementName);
                }

                nonRegisteredApps.set(appName, object);
            }
        }
    }

    let orderedModules = [...registeredApps.entries()].sort((a, b) => {
        let result = b[1].controllers.length - a[1].controllers.length;

        if (result === 0) {
            result = a[1].models.length - b[1].models.length;
        }

        return result;
    });

    for (let appPair of orderedModules) {
        appPair[1].controllers = appPair[1].controllers.sort((a, b) => {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        });

        appPair[1].models = appPair[1].models.sort((a, b) => {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        });

        appPair[1].views = appPair[1].views.sort((a, b) => {
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    let output = "{";

    for (let sortedPair of orderedModules) {
        output += `\"${sortedPair[0]}\":${JSON.stringify(sortedPair[1])},`;
    }

    output = output.substring(0, output.length - 1);
    output += "}";
    console.log(output);
}