function heroicInventory(heroes) {
    let allHeroes = [];

    for (let hero of heroes) {
        let heroTokens = hero.split(" / ").filter(a => a.length > 0);
        let heroName = heroTokens[0];
        let heroLevel = Number(heroTokens[1]);
        let heroItems = [];

        if (heroTokens.length === 3) {
            heroItems = heroTokens[2].split(", ").filter(a => a.length > 0);
        }

        let currentHero = {name: heroName, level: heroLevel, items: heroItems};
        allHeroes.push(currentHero);
    }

    return JSON.stringify(allHeroes);
}

function JSONTable(arr) {
    let output = "<table>\n";

    for (let line of arr) {
        let employeeObject = JSON.parse(line);
        let name = employeeObject.name;
        let position = employeeObject.position;
        let salary = employeeObject.salary;

        output += `\t<tr>\n\t\t<td>${name}</td>\n\t\t<td>${position}</td>\n\t\t<td>${salary}</td>\n\t<tr>\n`;
    }

    output += "</table>";
    return output;
}

function cappyJuice(arr) {
    let juiceBottles = new Map();
    let juiceQuantity = new Map();

    for (let line of arr) {
        let juiceTokens = line.split(" => ");
        let juiceType = juiceTokens[0];
        let quantity = Number(juiceTokens[1]);

        if (!juiceQuantity.has(juiceType)) {
            juiceQuantity.set(juiceType, quantity);
        } else {
            juiceQuantity.set(juiceType, juiceQuantity.get(juiceType) + quantity);
        }

        let bottles = 0;

        while (juiceQuantity.get(juiceType) >= 1000) {
            bottles++;
            juiceQuantity.set(juiceType, juiceQuantity.get(juiceType) - 1000);
        }

        if (bottles > 0) {
            if (!juiceBottles.has(juiceType)) {
                juiceBottles.set(juiceType, bottles);
            } else {
                juiceBottles.set(juiceType, juiceBottles.get(juiceType) + bottles);
            }
        }
    }

    let output = "";

    for (let pair of juiceBottles) {
        output += `${pair[0]} => ${pair[1]}\n`;
    }

    return output;
}

function storeCatalogue(arr) {
    let productPrice = new Map();

    for (let line of arr) {
        let tokens = line.split(" : ");
        let name = tokens[0];
        let price = Number(tokens[1]);

        productPrice.set(name, price);
    }

    let entriesArr = [...productPrice.entries()]
        .sort((a, b) => {
            if (a[0].toLowerCase() < b[0].toLowerCase()) {
                return -1;
            } else {
                return 1;
            }
        });

    let currentLetter = entriesArr[0][0][0];

    let output = `${currentLetter}\n`;

    for (let pair of entriesArr) {
        if (pair[0][0] !== currentLetter) {
            currentLetter = pair[0][0];
            output += `${currentLetter}\n`;
        }

        output += ` ${pair[0]}: ${pair[1]}\n`;
    }

    return output;
}

function autoEngineeringCompany(arr) {
    let brandModels = new Map();

    for (let line of arr) {
        let tokens = line.split(" | ");
        let brand = tokens[0];
        let model = tokens[1];
        let producedCars = Number(tokens[2]);

        if (!brandModels.has(brand)) {
            brandModels.set(brand, new Map());
        }

        if (!brandModels.get(brand).has(model)) {
            brandModels.get(brand).set(model, producedCars);
        } else {
            brandModels.get(brand).set(model, brandModels.get(brand).get(model) + producedCars);
        }
    }

    let output = "";

    for (let brandModelsPair of brandModels) {
        output += `${brandModelsPair[0]}\n`;

        for (let modelProductionPair of brandModelsPair[1]) {
            output += `###${modelProductionPair[0]} -> ${modelProductionPair[1]}\n`;
        }
    }

    return output;
}

function systemComponents(arr) {
    let systemComponents = new Map();

    for (let line of arr) {
        let tokens = line.split(" | ");
        let systemName = tokens[0];
        let componentName = tokens[1];
        let subComponentName = tokens[2];

        if (!systemComponents.has(systemName)) {
            systemComponents.set(systemName, new Map());
        }

        if (!systemComponents.get(systemName).has(componentName)) {
            systemComponents.get(systemName).set(componentName, []);
        }

        systemComponents.get(systemName).get(componentName).push(subComponentName);
    }

    let output = "";

    [...systemComponents.entries()]
        .sort((a, b) => {
            let result = b[1].size - a[1].size;

            if (result === 0) {
                if (a[0].toLowerCase() > b[0].toLowerCase()) {
                    result = 1;
                } else {
                    result = -1;
                }
            }

            return result;
        })
        .forEach(systemComponentsPair => {
            output += `${systemComponentsPair[0]}\n`;

            [...systemComponentsPair[1].entries()]
                .sort((a, b) => {
                    return b[1].length - a[1].length;
                })
                .forEach(componentsSubComponentsPair => {
                    output += `|||${componentsSubComponentsPair[0]}\n`;

                    for (let subComponent of componentsSubComponentsPair[1]) {
                        output += `||||||${subComponent}\n`;
                    }
                })
        });

    return output;
}

function usernames(arr) {
    let usernames = new Set();

    for (let username of arr) {
        usernames.add(username);
    }

    let output = "";

    [...usernames.entries()]
        .sort((a, b) => {
            let result = a[1].length - b[1].length;

            if (result === 0) {
                if (a[1] > b[1]) {
                    result = 1;
                } else {
                    result = -1;
                }
            }

            return result;
        })
        .forEach(usernameEntry => output += `${usernameEntry[1]}\n`);

    return output;
}

function uniqueSequences(arr) {
    let uniqueArrays = [];

    for (let line of arr) {
        let array = JSON.parse(line);
        let isUnique = true;

        for (let currentArray of uniqueArrays) {
            if (currentArray.length !== array.length) {
                continue;
            }

            let currentArraySorted = currentArray.sort((a, b) => a - b);
            let arraySorted = array.sort((a, b) => a - b);

            let areEqual = true;

            for (let i = 0; i < currentArraySorted.length; i++) {
                if (currentArraySorted[i] !== arraySorted[i]) {
                    areEqual = false;
                    break;
                }
            }

            if (areEqual) {
                isUnique = false;
                break;
            }
        }

        if (isUnique) {
            uniqueArrays.push(array);
        }
    }

    let output = "";

    uniqueArrays = uniqueArrays.sort((a, b) => a.length - b.length);

    for (let array of uniqueArrays) {
        array = array.sort((a, b) => b - a);

        output += `[${array.join(", ")}]\n`;
    }

    return output;
}