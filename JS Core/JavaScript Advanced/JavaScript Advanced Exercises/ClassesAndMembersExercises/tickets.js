function solution(arr, sortingCriteria) {
    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let tickets = [];

    for (let ticketArgs of arr) {
        let tokens = ticketArgs.split("|");
        tickets.push(new Ticket(tokens[0], Number(tokens[1]), tokens[2]));
    }

    let sortingFunction = function (a, b) {
        if (a[sortingCriteria] > b[sortingCriteria]) {
            return 1;
        } else if (a[sortingCriteria] < b[sortingCriteria]) {
            return -1;
        } else {
            return 0;
        }
    };

    tickets = tickets.sort(sortingFunction);
    return tickets;
}