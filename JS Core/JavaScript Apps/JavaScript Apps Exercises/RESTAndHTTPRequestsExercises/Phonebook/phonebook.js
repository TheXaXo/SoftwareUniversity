$(() => {
    let listOfPeople = $("#phonebook");
    let loadButton = $("#btnLoad");
    let createButton = $("#btnCreate");

    loadButton.on("click", loadContacts);
    createButton.on("click", createContact);

    function loadContacts() {
        loadButton.prop("disabled", true);

        let req = {
            url: "https://phonebook-nakov.firebaseio.com/phonebook.json",
            success: renderContacts,
            complete: () => loadButton.prop("disabled", false)
        };

        $.ajax(req);

        function renderContacts(contacts) {
            listOfPeople.empty();

            for (let contact in contacts) {
                let listItem = $(`<li>${contacts[contact].person}: ${contacts[contact].phone}  </li>`);
                let deleteButton = $('<button>[Delete]</button>');

                deleteButton.on("click", deleteContact(contact));
                listItem.append(deleteButton);
                listOfPeople.append(listItem);
            }
        }
    }

    function createContact() {
        createButton.prop("disabled", true);

        let nameField = $("#person");
        let phoneField = $("#phone");

        if (nameField.val() === "" || phoneField.val() === "") {
            console.log("Name or phone field is empty!");
            return;
        }

        let name = nameField.val();
        nameField.val("");
        let phone = phoneField.val();
        phoneField.val("");

        let data = {
            name,
            phone
        };

        let req = {
            url: "https://phonebook-nakov.firebaseio.com/phonebook.json",
            method: "POST",
            data: JSON.stringify(data),
            success: loadContacts,
            complete: () => createButton.prop("disabled", false)
        };

        $.ajax(req);
    }

    function deleteContact(id) {
        return function () {
            let req = {
                url: `https://phonebook-nakov.firebaseio.com/phonebook/${id}.json`,
                method: "DELETE",
                success: loadContacts
            };

            $.ajax(req);
        }
    }
});