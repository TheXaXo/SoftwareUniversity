class Player {
    constructor(nickName) {
        this.nickName = nickName;
        this.scores = [];
    }

    addScore(score) {
        let scoreAsNumber = parseInt(score);

        if (isNaN(scoreAsNumber)) {
            return;
        }

        this.scores.push(scoreAsNumber);
        return this;
    }

    get scoreCount() {
        return this.scores.length;
    }

    get highestScore() {
        if (this.scores.length === 0) {
            return undefined;
        }

        return Math.max.apply(null, this.scores);
    }

    get topFiveScore() {
        return this.scores.sort((a, b) => b - a).slice(0, 5);
    }

    toString() {
        return `${this.nickName}: [${this.scores.sort((a, b) => b - a).join(",")}]`
    }
}