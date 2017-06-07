function townsToJSON(arr) {
    let objects = [];

    for (let i = 1; i < arr.length; i++) {
        let tokens = arr[i].split("|").filter(a => a.length > 0).map(a => a.trim());
        let townName = tokens[0];
        let latitude = Number(tokens[1]);
        let longitude = Number(tokens[2]);

        let object = {Town: townName, Latitude: latitude, Longitude: longitude};
        objects.push(object);
    }

    return JSON.stringify(objects);
}

function scoreToHTML(arrayOfObjectsAsJSON) {
    let objects = JSON.parse(arrayOfObjectsAsJSON);
    let html = "<table>\n\t<tr><th>name</th><th>score</th></tr>\n";

    for (let object of objects) {
        let name = object["name"]
            .replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;")
            .replace(/"/g, "&quot;")
            .replace(/'/g, "&#39;");

        let score = object["score"];

        html += `\t<tr><td>${name}</td><td>${score}</td></tr>\n`;
    }

    html += "</table>";
    return html;
}

function JSONToHTML(objectsAsJSON) {
    let objects = JSON.parse(objectsAsJSON);
    let fieldsEscaped = [];
    let fieldsNonEscaped = [];

    for (let field in objects[0]) {
        fieldsNonEscaped.push(field);

        if (typeof field === "number") {
            fieldsEscaped.push(field);
        } else {
            fieldsEscaped.push(
                field
                    .replace(/&/g, "&amp;")
                    .replace(/</g, "&lt;")
                    .replace(/>/g, "&gt;")
                    .replace(/"/g, "&quot;")
                    .replace(/'/g, "&#39;")
            );
        }
    }

    let html = "<table>\n\t<tr>";

    for (let field of fieldsEscaped) {
        html += `<th>${field}</th>`;
    }

    html += "</tr>\n";

    for (let object of objects) {
        html += "\t<tr>";

        for (let key in object) {
            let valueEscaped = undefined;

            if (typeof object[key] === "number") {
                valueEscaped = object[key];
            } else {
                valueEscaped = object[key]
                    .replace(/&/g, "&amp;")
                    .replace(/</g, "&lt;")
                    .replace(/>/g, "&gt;")
                    .replace(/"/g, "&quot;")
                    .replace(/'/g, "&#39;");
            }

            html += `<td>${valueEscaped}</td>`;
        }

        html += "</tr>\n";
    }

    html += "</table>";
    return html;
}

function sumByTown(arr) {
    let towns = {};

    for (let i = 0; i < arr.length; i += 2) {
        let townName = arr[i];
        let townPopulation = Number(arr[i + 1]);

        if (townName in towns) {
            towns[townName] += townPopulation;
        } else {
            towns[townName] = townPopulation;
        }
    }

    return JSON.stringify(towns);
}

function countWordsInText(string) {
    let words = string[0].split(/\W+/g).filter(a => a.length > 0);

    let wordsCount = {};

    for (let word of words) {
        if (word in wordsCount) {
            wordsCount[word]++;
        } else {
            wordsCount[word] = 1;
        }
    }

    return JSON.stringify(wordsCount);
}

function countWordsInTextWithMaps(string) {
    let output = "";
    let tokens = string[0].split(/\W+/g).filter(a => a.length > 0).map(a => a.toLowerCase());
    let wordCount = new Map();

    for (let word of tokens) {
        if (wordCount.has(word)) {
            wordCount.set(word, wordCount.get(word) + 1);
        } else {
            wordCount.set(word, 1)
        }
    }

    let mapEntriesSorted = [...wordCount].sort();

    for (let pair of mapEntriesSorted) {
        output += `'${pair[0]}' -> ${pair[1]} times\n`;
    }

    return output;
}

function populationsInTowns(arr) {
    let townsPopulations = new Map();

    for (let line of arr) {
        let tokens = line.split(" <-> ");
        let townName = tokens[0];
        let townPopulation = Number(tokens[1]);

        if (!townsPopulations.has(townName)) {
            townsPopulations.set(townName, 0);
        }

        townsPopulations.set(townName, townsPopulations.get(townName) + townPopulation);
    }

    let output = "";

    for (let pair of townsPopulations) {
        output += `${pair[0]} : ${pair[1]}\n`;
    }

    return output;
}

function cityMarkets(arr) {
    let townProducts = new Map();

    for (let line of arr) {
        let tokens = line.split(/ -> | : /g).filter(a => a.length > 0);
        let townName = tokens[0];
        let productName = tokens[1];
        let productPrice = Number(tokens[2]) * Number(tokens[3]);

        if (!townProducts.has(townName)) {
            townProducts.set(townName, new Map());
        }

        if (!townProducts.get(townName).has(productName)) {
            townProducts.get(townName).set(productName, 0);
        }

        townProducts.get(townName).set(productName, townProducts.get(townName).get(productName) + productPrice);
    }

    let output = "";

    for (let townProductsPair of townProducts) {
        output += `Town - ${townProductsPair[0]}\n`;

        for (let productPricePair of townProductsPair[1]) {
            output += `$$$${productPricePair[0]} : ${productPricePair[1]}\n`;
        }
    }

    return output;
}

function lowestPricesInCities(arr) {
    let productLowestPrice = new Map();

    for (let line of arr) {
        let tokens = line.split(" | ");
        let townName = tokens[0];
        let productName = tokens[1];
        let price = Number(tokens[2]);

        if (!productLowestPrice.has(productName)) {
            productLowestPrice.set(productName, new Map());
        }

        if (productLowestPrice.get(productName).size === 0) {
            productLowestPrice.get(productName).set(price, townName);
        } else {
            let currentPrice = [...productLowestPrice.get(productName)][0][0];

            if (price < currentPrice) {
                productLowestPrice.get(productName).delete(currentPrice);
                productLowestPrice.get(productName).set(price, townName);
            }
        }
    }

    let output = "";

    for (let productPricePair of productLowestPrice) {
        output += `${productPricePair[0]} -> ${[...productPricePair[1]][0][0]} (${[...productPricePair[1]][0][1]})\n`;
    }

    return output;
}

function extractUniqueWords(arr) {
    let uniqueWords = new Set();

    for (let line of arr) {
        let words = line.split(/\W+/g).filter(a => a.length > 0).map(word => word.toLowerCase());

        for (let word of words) {
            uniqueWords.add(word);
        }
    }

    return Array.from(uniqueWords).join(", ");
}