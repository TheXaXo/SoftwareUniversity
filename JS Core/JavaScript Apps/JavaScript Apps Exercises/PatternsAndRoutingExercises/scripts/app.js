$(() => {
    const app = Sammy('#main', function () {
        this.get("index.html", function () {
            this.swap("<p>ASD</p>");
        })
    });

    app.run();
});