function attachEvents() {
    $(".add").on("click", addCatch);
    $(".load").on("click", loadCatches);

    let addForm = $("#addForm");
    let catchesDiv = $("#catches");

    function addCatch() {
        let angler = addForm.find(".angler").val();
        let weight = Number(addForm.find(".weight").val());
        let species = addForm.find(".species").val();
        let location = addForm.find(".location").val();
        let bait = addForm.find(".bait").val();
        let captureTime = Number(addForm.find(".captureTime").val());

        let dataObject = {
            angler,
            weight,
            species,
            location,
            bait,
            captureTime
        };

        $.ajax({
            url: "https://baas.kinvey.com/appdata/kid_rkCmKbJw-/biggestCatches",
            method: "POST",
            headers: {"Authorization": `Basic ${btoa("admin:admin")}`},
            data: JSON.stringify(dataObject),
            contentType: "application/json"
        }).then(loadCatches);
    }

    function loadCatches() {
        catchesDiv.empty();

        $.ajax({
            url: "https://baas.kinvey.com/appdata/kid_rkCmKbJw-/biggestCatches",
            headers: {"Authorization": `Basic ${btoa("admin:admin")}`}
        }).then(renderCatches);

        function renderCatches(data) {
            for (let catchInfo of data) {
                let catchDiv = $(`<div class="catch" data-id="${catchInfo._id}"></div>`);
                let anglerLabel = $("<label>Angler</label>");
                let anglerInput = $(`<input type="text" class="angler" value="${catchInfo.angler}">`);
                let weightLabel = $("<label>Weight</label>");
                let weightInput = $(`<input type="number" class="weight" value="${catchInfo.weight}">`);
                let speciesLabel = $("<label>Species</label>");
                let speciesInput = $(`<input type="text" class="species" value="${catchInfo.species}">`);
                let locationLabel = $("<label>Location</label>");
                let locationInput = $(`<input type="text" class="location" value="${catchInfo.location}">`);
                let baitLabel = $("<label>Bait</label>");
                let baitInput = $(`<input type="text" class="bait" value="${catchInfo.bait}">`);
                let captureTimeLabel = $("<label>Capture Time</label>");
                let captureTimeInput = $(`<input type="number" class="captureTime" value="${catchInfo.captureTime}">`);
                let updateButton = $('<button class="update">Update</button>');
                let deleteButton = $('<button class="delete">Delete</button>');

                updateButton.on("click", updateCatchInfo);
                deleteButton.on("click", deleteCatch);

                catchDiv.append([
                    anglerLabel, anglerInput, weightLabel, weightInput,
                    speciesLabel, speciesInput, locationLabel, locationInput,
                    baitLabel, baitInput, captureTimeLabel, captureTimeInput,
                    updateButton, deleteButton]);

                catchesDiv.append(catchDiv);
            }
        }
    }

    function updateCatchInfo() {
        let catchId = $(this).parent().attr("data-id");

        let angler = $(this).parent().find(".angler").val();
        let weight = $(this).parent().find(".weight").val();
        let species = $(this).parent().find(".species").val();
        let location = $(this).parent().find(".location").val();
        let bait = $(this).parent().find(".bait").val();
        let captureTime = $(this).parent().find(".captureTime").val();

        let data = {
            angler,
            weight,
            species,
            location,
            bait,
            captureTime
        };

        $.ajax({
            url: `https://baas.kinvey.com/appdata/kid_rkCmKbJw-/biggestCatches/${catchId}`,
            method: "PUT",
            headers: {"Authorization": `Basic ${btoa("admin:admin")}`},
            contentType: "application/json",
            data: JSON.stringify(data)
        }).then(loadCatches);
    }

    function deleteCatch() {
        let catchId = $(this).parent().attr("data-id");

        $.ajax({
            url: `https://baas.kinvey.com/appdata/kid_rkCmKbJw-/biggestCatches/${catchId}`,
            method: "DELETE",
            headers: {"Authorization": `Basic ${btoa("admin:admin")}`}
        }).then(loadCatches);
    }
}