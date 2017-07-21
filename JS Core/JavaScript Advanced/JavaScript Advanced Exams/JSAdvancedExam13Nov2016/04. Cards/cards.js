function cardDeckBuilder(selector) {
    return {
        cards: [],

        addCard: function (face, suit) {
            let suitAsSymbol = "";

            switch (suit) {
                case "C":
                    suitAsSymbol = "\u2663";
                    break;
                case "D":
                    suitAsSymbol = "\u2666";
                    break;
                case "H":
                    suitAsSymbol = "\u2665";
                    break;
                case "S":
                    suitAsSymbol = "\u2660";
                    break;
            }

            let cardElement = $(`<div class="card">${face} ${suitAsSymbol}</div>`);
            $(cardElement).on("click", reverseCards);
            $(selector).append(cardElement);

            function reverseCards() {
                $(selector).append($(`${selector} .card`).get().reverse());
            }
        }
    }
}

function solution() {
    let builder = cardDeckBuilder("#main");
    builder.addCard("10", "D");
    builder.addCard("K", "S");
    builder.addCard("Q", "H");
    builder.addCard("4", "C");
}