$(() => {
    renderCatTemplate();

    function renderCatTemplate() {
        let html = $("#cat-template").html();
        let template = Handlebars.compile(html);
        let allCatsDiv = $("#allCats");

        for (let cat of window.cats) {
            allCatsDiv.html(allCatsDiv.html() + template(cat));
        }

        $(".btn-primary").on("click", onClick);

        function onClick() {
            let button = event.target;
            let statusDiv = $(button).next();

            if ($(button).text() === "Show status code") {
                $(button).text("Hide status code");
                statusDiv.show();

            } else {
                $(button).text("Show status code");
                statusDiv.hide();
            }
        }
    }
});