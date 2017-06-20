function thePyramidOfKingDjoser(base, increment) {
    let stepCount = 0;
    let stoneCount = 0;
    let marbleCount = 0;
    let lapisCount = 0;
    let goldCount = 0;

    while (true) {
        let wholeArea = base ** 2;
        stepCount++;

        if (base < 3) {
            goldCount += wholeArea * increment;
            break;
        }

        let stoneArea = (base - 2) ** 2;
        let decorativeMaterialArea = wholeArea - stoneArea;

        let stoneRequired = stoneArea * increment;
        let decorativeMaterialRequired = decorativeMaterialArea * increment;

        if (stepCount % 5 === 0) {
            lapisCount += decorativeMaterialRequired;
        } else {
            marbleCount += decorativeMaterialRequired;
        }

        stoneCount += stoneRequired;
        base -= 2;
    }

    console.log(`Stone required: ${Math.ceil(stoneCount)}\nMarble required: ${Math.ceil(marbleCount)}\nLapis Lazuli required: ${Math.ceil(lapisCount)}\nGold required: ${Math.ceil(goldCount)}\nFinal pyramid height: ${Math.floor(stepCount * increment)}`);
}

function jansNottation(arr) {
    let numbersStack = [];

    for (let item of arr) {
        if (typeof item === "number") {
            numbersStack.push(item);
        } else {
            if (numbersStack.length < 2) {
                console.log("Error: not enough operands!");
                return;
            }

            let number2 = numbersStack.pop();
            let number1 = numbersStack.pop();

            switch (item) {
                case "+":
                    numbersStack.push(number1 + number2);
                    break;
                case "-":
                    numbersStack.push(number1 - number2);
                    break;
                case "*":
                    numbersStack.push(number1 * number2);
                    break;
                case "/":
                    numbersStack.push(number1 / number2);
                    break;
            }
        }
    }

    if (numbersStack.length > 1) {
        console.log("Error: too many operands!");
        return;
    }

    console.log(numbersStack.pop());
}

function xmlMessenger(message) {
    let pattern = /^<message\s((?:[a-z]+="[A-Za-z0-9\s.]+"\s)*[a-z]+="[A-Za-z0-9\s.]+")>((?:.|\n)+)<\/message>$/gm;
    let match = pattern.exec(message);

    if (!match) {
        console.log("Invalid message format");
        return;
    }

    let attributesPattern = /([a-z]+)="([A-Za-z0-9\s.]+)"/g;
    let attributesMatch = attributesPattern.exec(match[1]);
    let attributesMap = new Map();

    while (attributesMatch) {
        let key = attributesMatch[1];
        let value = attributesMatch[2];

        if (!attributesMap.has(key)) {
            attributesMap.set(key, value);
        }

        attributesMatch = attributesPattern.exec(match[1]);
    }

    if (!attributesMap.has("to") || !attributesMap.has("from")) {
        console.log("Missing attributes");
        return;
    }

    let to = attributesMap.get("to");
    let from = attributesMap.get("from");
    let textMessage = match[2];
    let newLines = textMessage.split(/\n/).filter(a => a.length > 0);

    let output = "";
    output += `<article>\n\t<div>From: <span class="sender">${from}</span></div>\n\t<div>To: <span class="recipient">${to}</span></div>\n\t<div>\n`;

    for (let textLine of newLines) {
        output += `\t\t<p>${textLine}</p>\n`;
    }

    output += "\t</div>\n</article>";
    console.log(output);
}

function galacticElections(arr) {
    let systemCandidates = new Map();

    for (let line of arr) {
        let object = line;
        let system = object.system;
        let candidateName = object.candidate;

        if (!systemCandidates.has(system)) {
            systemCandidates.set(system, new Map());
        }

        if (!systemCandidates.get(system).has(candidateName)) {
            systemCandidates.get(system).set(candidateName, object);
        } else {
            systemCandidates.get(system).get(candidateName).votes += object.votes;
        }

    }

    for (let pair of systemCandidates) {
        let systemName = pair[0];
        let candidatesPairsSortedByVotes = [...pair[1].entries()];

        candidatesPairsSortedByVotes = candidatesPairsSortedByVotes.sort((a, b) => {
            return b[1].votes - a[1].votes;
        });

        let totalVotes = 0;

        for (let candidatePair of candidatesPairsSortedByVotes) {
            totalVotes += candidatePair[1].votes;
        }

        let winner = candidatesPairsSortedByVotes[0][1];
        winner.votes = totalVotes;

        systemCandidates.set(systemName, winner);
    }

    let personResults = new Map();

    for (let systemWinnerPair of systemCandidates) {
        let systemName = systemWinnerPair[0];
        let winnerObject = systemWinnerPair[1];
        let winnerName = winnerObject.candidate;
        let votes = winnerObject.votes;

        if (!personResults.has(winnerName)) {
            personResults.set(winnerName, {votes: votes, systemsVotes: new Map()});
            personResults.get(winnerName).systemsVotes.set(systemName, votes);
        } else {
            let personObjectInMap = personResults.get(winnerName);
            personObjectInMap.votes += votes;
            personObjectInMap.systemsVotes.set(systemName, votes);
        }
    }

    if (personResults.size === 1) {
        let winnerPair = [...personResults.entries()][0];
        console.log(`${winnerPair[0]} wins with ${winnerPair[1].votes} votes\n${winnerPair[0]} wins unopposed!`);
        return;
    }

    let personResultsOrdered = [...personResults.entries()].sort((a, b) => b[1].votes - a[1].votes);
    let totalVotes = 0;
    personResultsOrdered.forEach(a => totalVotes += a[1].votes);
    let personWithMostVotesPair = personResultsOrdered[0];
    let secondPersonPair = personResultsOrdered[1];

    if (personWithMostVotesPair[1].votes > totalVotes / 2) {
        let secondPersonSystemsWonOrdered = [...secondPersonPair[1].systemsVotes.entries()].sort((a, b) => b[1] - a[1]);
        let output = `${personWithMostVotesPair[0]} wins with ${personWithMostVotesPair[1].votes} votes\nRunner up: ${secondPersonPair[0]}\n`;

        for (let systemWon of secondPersonSystemsWonOrdered) {
            output += `${systemWon[0]}: ${systemWon[1]}\n`;
        }

        console.log(output);
    } else {
        let firstPersonVotes = personWithMostVotesPair[1].votes;
        let secondPersonVotes = secondPersonPair[1].votes;
        console.log(`Runoff between ${personWithMostVotesPair[0]} with ${Math.floor((firstPersonVotes / totalVotes) * 100)}% and ${secondPersonPair[0]} with ${Math.floor((secondPersonVotes / totalVotes) * 100)}%`)
    }
}