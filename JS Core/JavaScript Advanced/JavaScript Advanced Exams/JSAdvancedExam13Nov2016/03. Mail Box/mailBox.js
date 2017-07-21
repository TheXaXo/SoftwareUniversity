class MailBox {
    constructor() {
        this.messages = [];
    }

    addMessage(subject, text) {
        this.messages.push({subject: subject, text: text});
        return this;
    }

    get messageCount() {
        return this.messages.length;
    }

    deleteAllMessages() {
        this.messages = [];
    }

    findBySubject(substr) {
        return this.messages.filter(messageObj => messageObj.subject.includes(substr));
    }

    toString() {
        if (this.messages.length === 0) {
            return '* (empty mailbox)';
        }

        let output = "";

        for (let messageObj of this.messages) {
            output += `* [${messageObj.subject}] ${messageObj.text}\n`;
        }

        return output.substring(0, output.length - 1);
    }
}

let mb = new MailBox();

mb.addMessage("meeting", "Let's meet at 17/11");
mb.addMessage("beer", "Wanna drink beer tomorrow?");
mb.addMessage("question", "How to solve this problem?");
mb.addMessage("Sofia next week", "I am in Sofia next week.");

console.log(mb.toString());