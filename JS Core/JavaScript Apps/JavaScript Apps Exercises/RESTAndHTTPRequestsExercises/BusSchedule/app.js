function solve() {
    let nextStopId = "depot";
    let stopName = "";

    function depart() {
        let departButton = $("#depart");
        let arriveButton = $("#arrive");
        let infoSpan = $("#info").find(".info");

        departButton.prop("disabled", true);
        arriveButton.prop("disabled", false);

        let req = {
            url: `https://judgetests.firebaseio.com/schedule/${nextStopId}.json`,
            success: onSuccess,
            error: () => {
                departButton.prop("disabled", true);
                arriveButton.prop("disabled", true);
                infoSpan.text("Error");
            }
        };

        $.ajax(req);

        function onSuccess(data) {
            stopName = data.name;
            nextStopId = data.next;

            infoSpan.text(`Next stop ${stopName}`);
        }
    }

    function arrive() {
        //We reuse the code because of a limitation in the judge system
        let departButton = $("#depart");
        let arriveButton = $("#arrive");
        let infoSpan = $("#info").find(".info");

        arriveButton.prop("disabled", true);
        departButton.prop("disabled", false);

        infoSpan.text(`Arriving at ${stopName}`);
    }

    return {
        depart,
        arrive
    };
}