function getInfo() {
    let stopIDField = $("#stopId");
    let stopNameDiv = $("#stopName");
    let busesList = $("#buses");

    let req = {
        url: `https://judgetests.firebaseio.com/businfo/${stopIDField.val()}.json`,
        success: renderInfo,
        error: renderError
    };

    $.ajax(req);

    function renderInfo(data) {
        busesList.empty();

        let stopName = data.name;
        let buses = data.buses;

        stopNameDiv.text(stopName);

        for (let bus in buses) {
            busesList.append(`<li>Bus ${bus} arrives in ${buses[bus]} minutes</li>`);
        }
    }

    function renderError() {
        busesList.empty();
        stopNameDiv.text("Error");
    }
}