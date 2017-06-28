function calendar(arr) {
    let day = arr[0];
    let month = arr[1] - 1;
    let year = arr[2];
    let dateObject = new Date(year, month, day);
    let monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

    let table = $('<table></table>');
    let caption = $(`<caption>${monthNames[dateObject.getMonth()]} ${dateObject.getFullYear()}</caption>`);
    let monthsRow = $('<tr></tr>');
    monthsRow
        .append($('<th>Mon</th>'))
        .append($('<th>Tue</th>'))
        .append($('<th>Wed</th>'))
        .append($('<th>Thu</th>'))
        .append($('<th>Fri</th>'))
        .append($('<th>Sat</th>'))
        .append($('<th>Sun</th>'));

    table
        .append(caption)
        .append(monthsRow);

    let daysInMonth = new Date(year, month + 1, 0).getDate();
    let firstDayNumber = new Date(year, month, 1).getDay();

    if (firstDayNumber === 0) {
        firstDayNumber = 7;
    }

    let currentDayNumber = 1;
    let currentColNumber = 1;
    let tableRow = $('<tr></tr>');

    for (let i = 1; i < daysInMonth + firstDayNumber; i++) {
        if (i < firstDayNumber) {
            tableRow.append($(`<td></td>`));
        } else {
            let tableCol = $(`<td>${currentDayNumber}</td>`);

            if (currentDayNumber === day) {
                tableCol.addClass("today");
            }

            tableRow.append(tableCol);
            currentDayNumber++;
        }

        if (currentColNumber % 7 === 0) {
            table.append(tableRow);
            tableRow = $('<tr></tr>');
        }

        if (i + 1 !== daysInMonth + firstDayNumber) {
            currentColNumber++;
        }
    }

    while (currentColNumber % 7 !== 0) {
        tableRow.append($('<td></td>'));
        currentColNumber++;
    }

    table.append(tableRow);
    $('#content').append(table);
}