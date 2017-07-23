class Contact {
    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this._online = false;
    }

    get online() {
        return this._online;
    }

    set online(online) {
        let titleDiv = $(`div:contains(${this.firstName})`)[1];

        if (online === true) {
            $(titleDiv).addClass("online");
        } else {
            $(titleDiv).removeClass("online");
        }

        this._online = online;
    }

    render(id) {
        let article = $('<article>');
        let titleDiv = $(`<div class="title">${this.firstName} ${this.lastName}</div>`);

        if (this.online) {
            titleDiv.addClass("online");
        }

        let button = $('<button>&#8505;</button>');
        button.on('click', toggleInfoBox);

        let infoDiv = $('<div class="info" style="display: none">');
        let phoneSpan = $(`<span>&phone; ${this.phone}</span>`);
        let emailSpan = $(`<span>&#9993; ${this.email}</span>`);

        article.append(titleDiv);
        titleDiv.append(button);
        article.append(infoDiv);
        infoDiv.append(phoneSpan);
        infoDiv.append(emailSpan);

        $(`#${id}`).append(article);

        function toggleInfoBox() {
            let infoDiv = $(this).parent().parent().children().filter('.info')[0];

            if ($(infoDiv).css("display") === "none") {
                $(infoDiv).css("display", "block");
            } else {
                $(infoDiv).css("display", "none");
            }
        }
    }
}

function solution() {
    let contacts = [
        new Contact("Ivan", "Ivanov", "0888 123 456", "i.ivanov@gmail.com"),
        new Contact("Maria", "Petrova", "0899 987 654", "mar4eto@abv.bg"),
        new Contact("Jordan", "Kirov", "0988 456 789", "jordk@gmail.com")
    ];

    for (let contact of contacts) {
        contact.render("main");
    }
    contacts[2].online = true;
}