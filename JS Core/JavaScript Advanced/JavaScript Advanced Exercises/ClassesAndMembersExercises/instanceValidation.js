class CheckingAccount {
    constructor(clientId, email, firstName, lastName) {
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get clientId() {
        return this._clientId;
    }

    set clientId(clientId) {
        let pattern = /^[0-9]{6}$/g;
        let match = pattern.exec(clientId);

        if (!match) {
            throw new TypeError("Client ID must be a 6-digit number")
        }

        this._clientId = clientId;
    }

    get email() {
        return this._email;
    }

    set email(email) {
        let pattern = /^[0-9A-Za-z]+@[A-Za-z.]+$/g;
        let match = pattern.exec(email);

        if (!match) {
            throw new TypeError("Invalid e-mail");
        }

        this._email = email;
    }

    get firstName() {
        return this._firstName;
    }

    set firstName(firstName) {
        if (this.checkName(firstName, "First")) {
            this._firstName = firstName;
        }
    }

    get lastName() {
        return this._lastName;
    }

    set lastName(lastName) {
        if (this.checkName(lastName, "Last")) {
            this._lastName = lastName;
        }
    }

    checkName(name, typeOfName) {
        if (name.length < 3 || name.length > 20) {
            throw new TypeError(`${typeOfName} name must be between 3 and 20 characters long`);
        }

        let pattern = /^[A-Za-z]+$/g;
        let match = pattern.exec(name);

        if (!match) {
            throw new TypeError(`${typeOfName} name must contain only Latin characters`);
        }

        return true;
    }
}