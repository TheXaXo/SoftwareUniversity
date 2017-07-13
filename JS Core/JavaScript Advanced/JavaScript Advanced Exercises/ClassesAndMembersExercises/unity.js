class Rat {
    constructor(name) {
        this.name = name;
        this.rats = [];
    }

    unite(rat) {
        if (!(rat instanceof Rat)) {
            return;
        }

        this.rats.push(rat);
    }

    getRats() {
        return this.rats;
    }

    toString() {
        let ratsToReturn = this.rats.map(a => "##" + a.name + "\n").join("");
        return this.name + "\n" + ratsToReturn;
    }
}