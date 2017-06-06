function splitAStringWithDelimiter(string, delimiter) {
    return string.split(delimiter).join("\n");
}

function repeatAStringNTimes(string, times) {
    return string.repeat(times);
}

function startsWith(string, part) {
    return string.startsWith(part);
}

function endsWith(string, part) {
    return string.endsWith(part);
}

function capitalizeTheWords(string) {
    let pattern = /\b([A-Za-z])/g;
    let lowercasePattern = /([A-Z])/g;

    return string
        .replace(lowercasePattern, (match, group1) => group1.toLowerCase())
        .replace(pattern, (match, group1) => group1.toUpperCase());
}

function captureTheNumbers(arr) {
    let numbers = [];

    for (let line of arr) {
        let currentNumbers = line.split(/\D/g).filter(a => a.length > 0);

        for (let number of currentNumbers) {
            numbers.push(number);
        }
    }

    return numbers.join(" ");
}

function findVariableNames(string) {
    let pattern = /_([A-Za-z0-9]+)/g;
    let matches = [];

    let match = pattern.exec(string);

    while (match) {
        matches.push(match[1]);
        match = pattern.exec(string);
    }

    return matches.join(",");
}

function findOccurrences(string, word) {
    let pattern = new RegExp(`\\b${word}\\b`, "ig");
    let matches = string.match(pattern);

    if (matches) {
        return matches.length;
    } else {
        return 0;
    }
}

function extractTheLinks(arr) {
    let links = [];
    let pattern = /(www\.[A-Za-z0-9-]+\.[a-z]+(\.[a-z]+)*)/g;

    for (let line of arr) {
        let match = pattern.exec(line);

        while (match) {
            links.push(match[1]);
            match = pattern.exec(line);
        }
    }

    return links.join("\n");
}

function secretData(lines) {
    let userNamePattern = /(\*[A-Z][A-Za-z]*)(?:(?=\s)|$)/g;
    let phoneNumberPattern = /(\+[\d-]{10})(?:(?=\s)|$)/g;
    let idPattern = /(![A-Za-z0-9]+)(?:(?=\s)|$)/g;
    let secretBasesPattern = /(_[A-Za-z0-9]+)(?:(?=\s)|$)/g;

    let output = "";

    for (let line of lines) {
        line = line
            .replace(userNamePattern, (match, group1) => "|".repeat(group1.length))
            .replace(phoneNumberPattern, (match, group1) => "|".repeat(group1.length))
            .replace(idPattern, (match, group1) => "|".repeat(group1.length))
            .replace(secretBasesPattern, (match, group1) => "|".repeat(group1.length));

        output += `${line}\n`;
    }

    return output;
}