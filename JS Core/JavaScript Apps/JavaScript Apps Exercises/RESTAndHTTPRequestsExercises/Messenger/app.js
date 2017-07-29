$(() => {
    $("#refresh").on("click", refreshMessages);
    $("#submit").on("click", sendMessage);

    function refreshMessages() {
        let messagesField = $("#messages");

        let req = {
            url: "https://messanger-94ef5.firebaseio.com/messenger.json",
            success: refresh
        };

        $.ajax(req);

        function refresh(data) {
            data = Object.values(data)
                .filter(a => a !== null)
                .sort((a, b) => {
                    return a.timestamp - b.timestamp;
                });

            messagesField.empty();

            for (let message of data) {
                messagesField.append(`${message.author}: ${message.content}\n`);
            }
        }
    }

    function sendMessage() {
        let nameField = $("#author");
        let contentField = $("#content");

        if (nameField.val() === "" || contentField.val() === "") {
            return;
        }

        let data = {
            author: nameField.val(),
            content: contentField.val(),
            timestamp: Date.now()
        };

        let req = {
            url: "https://messanger-94ef5.firebaseio.com/messages.json",
            method: "POST",
            data: JSON.stringify(data),
            success: () => {
                contentField.val("");
                refreshMessages();
            }
        };

        $.ajax(req);
    }
});