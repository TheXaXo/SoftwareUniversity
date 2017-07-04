function sortArray(arr, criteria) {
    function ascendingComparator(a, b) {
        if (a > b) {
            return -1;
        } else if (a < b) {
            return 1;
        } else {
            return 0;
        }
    }

    function descendingComparator(a, b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }

    if (criteria === 'desc') {
        return arr.sort(ascendingComparator);
    } else {
        return arr.sort(descendingComparator);
    }
}

function argumentInfo() {
    let argumentTypeCount = new Map();

    for (let argument of arguments) {
        let argumentType = typeof argument;
        console.log(`${argumentType}: ${argument}`);

        if (!argumentTypeCount.has(argumentType)) {
            argumentTypeCount.set(argumentType, 1);
        } else {
            argumentTypeCount.set(argumentType, argumentTypeCount.get(argumentType) + 1);
        }
    }

    let sorted = [...argumentTypeCount.entries()].sort((a, b) => {
        if (a[1] > b[1]) {
            return -1;
        } else if (a[1] < b[1]) {
            return 1;
        } else {
            return 0;
        }
    });

    for (let pair of sorted) {
        console.log(`${pair[0]} = ${pair[1]}`)
    }
}

let sum = (function () {
    let totalSum = 0;

    return function add(number) {
        totalSum += number;
        add.toString = () => {
            return totalSum
        };
        return add;
    }
})();

function personalBMI(name, age, weight, height) {
    let bmi = weight / Math.pow(height / 100, 2);
    let status = "";

    if (bmi < 18.5) {
        status = "underweight";
    } else if (bmi < 25) {
        status = "normal";
    } else if (bmi < 30) {
        status = "overweight";
    } else {
        status = "obese";
    }

    let personObject = {
        name: name,
        personalInfo: {
            age: Math.round(age),
            weight: Math.round(weight),
            height: Math.round(height)
        },
        BMI: Math.round(bmi),
        status: status
    };

    if (status === "obese") {
        personObject["recommendation"] = 'admission required';
    }

    return personObject;
}

let vectorMath = {
    add: function (vec1, vec2) {
        let arr = [];
        arr.push(vec1[0] + vec2[0]);
        arr.push(vec1[1] + vec2[1]);
        return arr;
    },

    multiply: function (vec1, scalar) {
        let arr = [];
        arr.push(vec1[0] * scalar);
        arr.push(vec1[1] * scalar);
        return arr;
    },

    length: function (vec1) {
        return Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2));
    },

    dot: function (vec1, vec2) {
        return vec1[0] * vec2[0] + vec1[1] * vec2[1];
    },

    cross: function (vec1, vec2) {
        return vec1[0] * vec2[1] - vec1[1] * vec2[0];
    }
};

function breakfastRobot() {
    let protein = 0;
    let carbohydrate = 0;
    let fat = 0;
    let flavour = 0;

    return function performAction(string) {
        let tokens = string.split(" ");

        switch (tokens[0]) {
            case "restock":
                let itemToRestock = tokens[1];
                let quantity = Number(tokens[2]);

                switch (itemToRestock) {
                    case "protein":
                        protein += quantity;
                        break;
                    case "carbohydrate":
                        carbohydrate += quantity;
                        break;
                    case "fat":
                        fat += quantity;
                        break;
                    case "flavour":
                        flavour += quantity;
                        break;
                }

                return "Success";
            case "prepare":
                let itemToPrepare = tokens[1];
                let quantityToPrepare = Number(tokens[2]);

                switch (itemToPrepare) {
                    case "apple":
                        if (carbohydrate < quantityToPrepare) {
                            return "Error: not enough carbohydrate in stock";
                        }

                        if (flavour < quantityToPrepare * 2) {
                            return "Error: not enough flavour in stock";
                        }

                        carbohydrate -= quantityToPrepare;
                        flavour -= quantityToPrepare * 2;
                        return "Success";
                    case "coke":
                        if (carbohydrate < quantityToPrepare * 10) {
                            return "Error: not enough carbohydrate in stock";
                        }

                        if (flavour < quantityToPrepare * 20) {
                            return "Error: not enough flavour in stock";
                        }

                        carbohydrate -= quantityToPrepare * 10;
                        flavour -= quantityToPrepare * 20;
                        return "Success";
                    case "burger":
                        if (carbohydrate < quantityToPrepare * 5) {
                            return "Error: not enough carbohydrate in stock";
                        }

                        if (fat < quantityToPrepare * 7) {
                            return "Error: not enough fat in stock";
                        }

                        if (flavour < quantityToPrepare * 3) {
                            return "Error: not enough flavour in stock";
                        }

                        carbohydrate -= quantityToPrepare * 5;
                        fat -= quantityToPrepare * 7;
                        flavour -= quantityToPrepare * 3;
                        return "Success";
                        break;
                    case "omelet":
                        if (protein < quantityToPrepare * 5) {
                            return "Error: not enough protein in stock";
                        }

                        if (fat < quantityToPrepare) {
                            return "Error: not enough fat in stock";
                        }

                        if (flavour < quantityToPrepare * 2) {
                            return "Error: not enough flavour in stock";
                        }

                        protein -= quantityToPrepare * 5;
                        fat -= quantityToPrepare;
                        flavour -= quantityToPrepare;
                        return "Success";
                    case "cheverme":
                        if (protein < quantityToPrepare * 10) {
                            return "Error: not enough protein in stock";
                        }

                        if (carbohydrate < quantityToPrepare * 10) {
                            return "Error: not enough carbohydrate in stock";
                        }

                        if (fat < quantityToPrepare * 10) {
                            return "Error: not enough fat in stock";
                        }

                        if (flavour < quantityToPrepare * 10) {
                            return "Error: not enough flavour in stock";
                        }

                        protein -= quantityToPrepare * 10;
                        carbohydrate -= quantityToPrepare * 10;
                        fat -= quantityToPrepare * 10;
                        flavour -= quantityToPrepare * 10;
                        return "Success";
                        break;
                }
                break;
            case "report":
                return `protein=${protein} carbohydrate=${carbohydrate} fat=${fat} flavour=${flavour}`;
        }
    }
}

function monkeyPatcher(action) {
    switch (action) {
        case "upvote":
            this.upvotes += 1;
            break;
        case "downvote":
            this.downvotes += 1;
            break;
        case "score":
            let totalVotes = this.upvotes + this.downvotes;
            let upvotesToReport = this.upvotes;
            let downvotesToReport = this.downvotes;

            if (totalVotes > 50) {
                let numberToAdd = Math.ceil(Math.max(this.upvotes, this.downvotes) * 0.25);
                upvotesToReport += numberToAdd;
                downvotesToReport += numberToAdd;
            }

            let rating = "";
            let balance = this.upvotes - this.downvotes;

            if (totalVotes < 10) {
                rating = "new";
            } else if (this.upvotes > (66 / 100) * totalVotes) {
                rating = "hot";
            } else if ((this.upvotes > 100 || this.downvotes > 100) && balance >= 0) {
                rating = "controversial";
            } else if (balance < 0) {
                rating = "unpopular";
            } else {
                rating = "new";
            }

            return [upvotesToReport, downvotesToReport, balance, rating];
    }
}

function euclidsAlgorithm(a, b) {
    if (!b) {
        return a;
    }

    return euclidsAlgorithm(b, a % b);
}