function printLetters(string) {
    let output = "";

    for (let i = 0; i < string.length; i++) {
        output += `str[${i}] -> ${string[i]}\n`
    }

    return output.substring(0, output.length - 1);
}

function concatAndReverseStrings(arr) {
    let stringToReverse = "";

    for (let string of arr) {
        stringToReverse += string;
    }

    let output = "";

    for (let i = stringToReverse.length - 1; i >= 0; i--) {
        output += stringToReverse[i];
    }

    return output;
}

function countOccurrences(word, string) {
    let occurrences = 0;
    let lastOccurrenceIndex = string.indexOf(word);

    while (lastOccurrenceIndex !== -1) {
        occurrences++;
        lastOccurrenceIndex = string.indexOf(word, lastOccurrenceIndex + 1);

    }

    return occurrences;
}

function extractTextFromParenthesis(string) {
    let matches = [];
    let pattern = /\((.+?)\)/g;

    let matchesFromRegex = pattern.exec(string);
    while (matchesFromRegex) {
        matches.push(matchesFromRegex[1]);
        matchesFromRegex = pattern.exec(string);
    }

    return matches.join(", ");
}

function aggregateTable(arr) {
    let towns = [];
    let sum = 0;

    for (let pair of arr) {
        let tokens = pair.split(/[\s\\|]/g).filter(match => match.length > 0);

        if (tokens.length > 2) {
            let townName = "";

            for (let i = 0; i < tokens.length - 1; i++) {
                townName += tokens[i] + " ";
            }

            towns.push(townName.substring(0, townName.length - 1));
        } else {
            towns.push(tokens[0]);
        }

        sum += Number(tokens[tokens.length - 1]);
    }

    return towns.join(", ") + "\n" + sum;
}

function restaurantBill(arr) {
    let output = "You purchased ";
    let items = [];
    let totalPrice = 0;

    for (let i = 0; i < arr.length; i += 2) {
        items.push(arr[i]);
    }

    for (let i = 1; i < arr.length; i += 2) {
        totalPrice += Number(arr[i]);
    }

    output += items.join(", ") + ` for a total sum of ${totalPrice}`;
    return output;
}

function usernames(arr) {
    let usernames = [];

    for (let email of arr) {
        let username = email.substring(0, email.indexOf("@")) + ".";
        let tokens = email.split("@")[1].split(".");

        for (let i = 0; i < tokens.length; i++) {
            username += tokens[i][0];
        }

        usernames.push(username);
    }

    return usernames.join(", ");
}

function censorship(string, blacklistedWords) {
    for (let word of blacklistedWords) {
        let occurrenceIndex = string.indexOf(word);
        let replacementString = "";

        for (let i = 0; i < word.length; i++) {
            replacementString += "-";
        }

        while (occurrenceIndex !== -1) {
            let endIndex = occurrenceIndex + word.length;

            string = string.substring(0, occurrenceIndex) + replacementString + string.substring(endIndex);
            occurrenceIndex = string.indexOf(word, occurrenceIndex + 1);
        }
    }

    return string;
}

function escaping(arr) {
    let output = "<ul>\n";

    for (let string of arr) {
        string = string
            .replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;")
            .replace(/"/g, "&quot;");

        output += `\t<li>${string}</li>\n`
    }

    output += "</ul>";
    return output;
}

function matchAllWords(string) {
    return string.split(/\W+/g).filter(match => match.length > 0).join("|");
}

function emailValidation(email) {
    let pattern = /^[A-Za-z0-9]+@[a-z]+\.[a-z]+$/g;
    return pattern.test(email) ? "Valid" : "Invalid";
}

function expressionSplit(string) {
    return string.split(/[\s(),;.]+/g).filter(a => a.length > 0).join("\n");
}

function matchTheDates(arr) {
    let output = "";
    let pattern = /(?:\s|^)(\d{1,2})-([A-Z][a-z]{2})-(\d{4})/g;

    for (let string of arr) {
        let match = pattern.exec(string);

        while (match) {
            output += `${match[0]} (Day: ${match[1]}, Month: ${match[2]}, Year: ${match[3]})\n`;
            match = pattern.exec(string);
        }
    }

    return output;
}

function parseEmployeeData(arr) {
    let output = "";
    let pattern = /^([A-Z][A-Za-z]*) - ([1-9][0-9]*) - ([A-Za-z0-9\-]+(?:\s[A-Za-z0-9\-]+)*)$/;

    for (let line of arr) {
        let match = pattern.exec(line);

        if (match) {
            output += `Name: ${match[1]}\nPosition: ${match[3]}\nSalary: ${match[2]}\n`;
        }
    }

    return output;
}

function formFiller(username, email, phoneNumber, arr) {
    let output = [];

    for (let line of arr) {
        line = line
            .replace(/<![A-Za-z]+!>/g, username)
            .replace(/<@[A-Za-z]+@>/g, email)
            .replace(/<\+[A-Za-z]+\+>/g, phoneNumber);

        output.push(line);
    }

    console.log(output.join("\n"));
}

function matchMultiplication(string) {
    let pattern = /(-*\d+)\s*\*\s*(-*\d+(?:\.\d+)*)/g;

    string = string.replace(pattern, (match, num1, num2) => Number(num1) * Number(num2));
    return string;
}