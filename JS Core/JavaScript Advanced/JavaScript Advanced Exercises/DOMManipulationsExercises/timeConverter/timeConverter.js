function attachEventsListeners() {
    document.getElementById('daysBtn').addEventListener('click', calcFromDays);
    document.getElementById('hoursBtn').addEventListener('click', calcFromHours);
    document.getElementById('minutesBtn').addEventListener('click', calcFromMinutes);
    document.getElementById('secondsBtn').addEventListener('click', calcFromSeconds);

    let daysField = document.getElementById('days');
    let hoursField = document.getElementById('hours');
    let minutesField = document.getElementById('minutes');
    let secondsField = document.getElementById('seconds');

    function calcFromDays() {
        let days = daysField.value;
        hoursField.value = days * 24;
        minutesField.value = days * 1440;
        secondsField.value = days * 86400;
    }

    function calcFromHours() {
        let hours = hoursField.value;
        daysField.value = hours / 24;
        minutesField.value = hours * 60;
        secondsField.value = hours * 3600;
    }

    function calcFromMinutes() {
        let minutes = minutesField.value;
        daysField.value = (minutes / 60) / 24;
        hoursField.value = minutes / 60;
        secondsField.value = minutes * 60;
    }

    function calcFromSeconds() {
        let seconds = secondsField.value;
        daysField.value = seconds / 60 / 60 / 24;
        hoursField.value = seconds / 60 / 60;
        minutesField.value = seconds / 60;
    }
}