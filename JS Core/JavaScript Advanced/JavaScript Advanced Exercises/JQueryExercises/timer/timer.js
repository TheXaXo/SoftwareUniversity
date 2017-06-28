function timer() {
    $('#start-timer').on('click', start);
    $('#stop-timer').on('click', stop);

    let innerTimer = undefined;
    let time = new Date(0, 0, 0, 0, 0, 0);

    function start() {
        if (innerTimer === undefined) {
            innerTimer = setInterval(timerFunction, 1000);
        }
    }

    function stop() {
        clearInterval(innerTimer);
        innerTimer = undefined;
    }

    function timerFunction() {
        time.setTime(time.getTime() + 1000);

        let hours = time.getHours();

        if (hours < 10) {
            hours = "0" + hours;
        }

        let minutes = time.getMinutes();

        if (minutes < 10) {
            minutes = "0" + minutes;
        }

        let seconds = time.getSeconds();

        if (seconds < 10) {
            seconds = "0" + seconds;
        }

        $('#hours').text(hours);
        $('#minutes').text(minutes);
        $('#seconds').text(seconds);
    }
}