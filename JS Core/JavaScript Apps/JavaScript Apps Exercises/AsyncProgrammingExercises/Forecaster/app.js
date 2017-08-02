function attachEvents() {
    $("#submit").on("click", getWeather);

    let locationField = $("#location");
    let currentConditionsDiv = $("#current");
    let upcomingDiv = $("#upcoming");
    let forecastDiv = $("#forecast");

    function getWeather() {
        emptyDivs();

        $.ajax({
            url: "https://judgetests.firebaseio.com/locations.json"
        }).then(getWeatherInfo);

        function getWeatherInfo(data) {
            let locationCode = "";

            for (let location of data) {
                if (location.name === locationField.val()) {
                    locationCode = location.code;
                }
            }

            let currentConditions = $.ajax({
                url: `https://judgetests.firebaseio.com/forecast/today/${locationCode}.json`
            });

            let threeDayForecast = $.ajax({
                url: `https://judgetests.firebaseio.com/forecast/upcoming/${locationCode}.json`
            });

            Promise.all([currentConditions, threeDayForecast]).then(renderForecast);

            function renderForecast(data) {
                let currentConditionsData = data[0];
                let threeDayForecastData = data[1];

                forecastDiv.show();
                let symbol = getSymbolForConditionName(currentConditionsData.forecast.condition);

                currentConditionsDiv.append(`<span class="condition symbol">${symbol}</span>`);

                let conditionSpan = $('<span class="condition">');
                currentConditionsDiv.append(conditionSpan);

                conditionSpan.append(`<span class="forecast-data">${currentConditionsData.name}</span>`);
                conditionSpan.append(`<span class="forecast-data">${currentConditionsData.forecast.low}&#176/${currentConditionsData.forecast.high}&#176</span>`);
                conditionSpan.append(`<span class="forecast-data">${currentConditionsData.forecast.condition}</span>`);

                for (let day of threeDayForecastData.forecast) {
                    let currentDaySymbol = getSymbolForConditionName(day.condition);
                    let upcomingSpan = $("<span class='upcoming'></span>");

                    upcomingDiv.append(upcomingSpan);
                    upcomingSpan.append(`<span class="symbol">${currentDaySymbol}</span>`);
                    upcomingSpan.append(`<span class="forecast-data">${day.low}&#176/${day.high}&#176</span>`);
                    upcomingSpan.append(`<span class="forecast-data">${day.condition}</span>`);
                }
            }
        }
    }

    function getSymbolForConditionName(conditionName) {
        switch (conditionName) {
            case "Sunny":
                return "&#x2600";
            case "Partly sunny":
                return "&#x26C5";
            case "Overcast":
                return "&#x2601";
            case "Rain":
                return "&#x2614";
        }
    }

    function emptyDivs() {
        let currentWeatherChildren = $(currentConditionsDiv).children();
        let upcomingForecastChildren = $(upcomingDiv).children();

        for (let i = 1; i < currentWeatherChildren.length; i++) {
            $(currentWeatherChildren[i]).detach();
        }

        for (let i = 1; i < upcomingForecastChildren.length; i++) {
            $(upcomingForecastChildren[i]).detach();
        }
    }
}