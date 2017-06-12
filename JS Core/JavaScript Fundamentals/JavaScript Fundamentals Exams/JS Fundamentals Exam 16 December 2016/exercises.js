function spiceMustFlow(arr) {
    let yield = Number(arr[0]);
    let daysPassed = 0;
    let totalSpice = 0;

    while (yield >= 100) {
        daysPassed++;
        totalSpice += yield;
        totalSpice -= 26;
        yield -= 10;
    }

    if (totalSpice >= 26) {
        totalSpice -= 26;
    }

    console.log(`${daysPassed}\n${totalSpice}`)
}

function buildAWall(segmentsHeight) {
    segmentsHeight = segmentsHeight.map(a => Number(a));
    let allCompleted = false;
    let daysConcreteUsed = [];

    while (!allCompleted) {
        allCompleted = true;
        let currentDayConcreteUsed = 0;

        for (let i = 0; i < segmentsHeight.length; i++) {
            let currentSegmentHeight = segmentsHeight[i];

            if (currentSegmentHeight < 30) {
                segmentsHeight[i]++;
                currentDayConcreteUsed += 195;
                allCompleted = false;
            }
        }

        if (currentDayConcreteUsed > 0) {
            daysConcreteUsed.push(currentDayConcreteUsed);
        }
    }

    console.log(`${daysConcreteUsed.join(", ")}\n${daysConcreteUsed.reduce((a, b) => a + b) * 1900} pesos`)
}

function formatHelper(arr) {
    let text = arr[0];
    let pattern1 = /([.,!?:;])(\s*)/g;
    let pattern2 = /(\s*)([.,!?:;])/g;
    let pattern3 = /((?:\.\s*)+!)/g;
    let pattern4 = /((\.\s*\d+)+)/g;
    let pattern5 = /"\s*(.+?)\s*"/g;

    text = text
        .replace(pattern1, "$1 ")
        .replace(pattern2, "$2")
        .replace(pattern3, "$1".replace(/\s+/g, ""))
        .replace(pattern4, (match, group1, group2) => group1.replace(/\s+/g, ""))
        .replace(pattern5, "\"" + "$1" + "\"");

    return text;
}

function airport(arr) {
    let planesAtAirport = new Map();
    let towns = new Map();

    for (let line of arr) {
        let tokens = line.split(" ");

        let id = tokens[0];
        let town = tokens[1];
        let passengersCount = Number(tokens[2]);
        let action = tokens[3];

        if (action === "depart" && planesAtAirport.has(id)) {
            if (!towns.has(town)) {
                towns.set(town, {arrivals: 0, departures: passengersCount, planes: new Set().add(id)})
            } else {
                towns.get(town).planes.add(id);
                towns.get(town).departures += passengersCount;
            }

            planesAtAirport.delete(id);
        } else if (action === "land" && !(planesAtAirport.has(id))) {
            if (!towns.has(town)) {
                towns.set(town, {arrivals: passengersCount, departures: 0, planes: new Set().add(id)})
            } else {
                towns.get(town).planes.add(id);
                towns.get(town).arrivals += passengersCount;
            }

            planesAtAirport.set(id, id);
        }
    }

    let planesAtAirportSorted = [...planesAtAirport.entries()].sort((a, b) => {
        if (a[0].toLowerCase() > b[0].toLowerCase()) {
            return 1;
        } else if (a[0].toLowerCase() < b[0].toLowerCase()) {
            return -1;
        }

        return 0;
    });

    let output = "Planes left:\n";

    for (let planePair of planesAtAirportSorted) {
        output += `- ${planePair[0]}\n`;
    }

    let townsSorted = [...towns.entries()].sort((a, b) => {
        let result = b[1].arrivals - a[1].arrivals;

        if (result === 0) {
            if (a[0] > b[0]) {
                result = 1;
            } else if (a[0] < b[0]) {
                result = -1;
            } else {
                result = 0;
            }
        }

        return result;
    });

    for (let townsPair of townsSorted) {
        let townObject = townsPair[1];

        output += `${townsPair[0]}\nArrivals: ${townObject.arrivals}\nDepartures: ${townObject.departures}\nPlanes:\n`;

        let planesSorted = [...townObject.planes.entries()].sort((a, b) => {
            if (a[1].toLowerCase() > b[1].toLowerCase()) {
                return 1;
            } else if (a[1].toLowerCase() < b[1].toLowerCase()) {
                return -1;
            }

            return 0;
        });

        for (let planePair of planesSorted) {
            output += `-- ${planePair[1]}\n`;
        }
    }

    return output;
}