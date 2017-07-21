class TitleBar {
    constructor(title) {
        this.title = title;
        this.links = [];
    }

    addLink(href, name) {
        this.links.push($(`<a class="menu-link" href="${href}">${name}</a>`))
    }

    appendTo(selector) {
        let header = $('<header class="header"></header>');
        let headerRow = $('<div class="header-row"></div>');

        let button = $('<a class="button">&#9776;</a>');
        $(button).on("click", toggleMenu);

        let title = $(`<span class="title">${this.title}</span>`);
        let drawer = $('<div class="drawer" style="display: none"></div>');
        let menu = $(`<nav class="menu">`);

        for (let link of this.links) {
            $(menu).append(link);
        }

        $(header).append(headerRow);
        $(headerRow).append(button);
        $(headerRow).append(title);
        $(header).append(drawer);
        $(drawer).append(menu);

        $(selector).append(header);

        function toggleMenu() {
            let drawer = $('.drawer');

            if (drawer.css('display') === 'none') {
                drawer.css('display', 'block');
            } else {
                drawer.css('display', 'none');
            }
        }
    }
}

function solution() {
    let header = new TitleBar('Title Bar Problem');
    header.addLink('/', 'Home');
    header.addLink('about', 'About');
    header.addLink('results', 'Results');
    header.addLink('faq', 'FAQ');
    header.appendTo('#container');
}