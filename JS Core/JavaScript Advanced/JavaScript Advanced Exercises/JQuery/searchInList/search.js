function search() {
    let towns = $('#towns li');
    let keyword = $('#searchText').val();
    $('#searchText').val('');
    let count = 0;

    for (let town of towns) {
        if (town.textContent.indexOf(keyword) !== -1) {
            $(town).css("font-weight", "bold");
            count++;
        } else {
            $(town).css("font-weight", "");
        }
    }

    $('#result').text(`${count} matches found.`);
}