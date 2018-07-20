function timer() {
    let startButton = $('button#start-timer');
    let stopButton = $('button#stop-timer');
    let hoursSpan = $('span#hours');
    let minutesSpan = $('span#minutes');
    let secondsSpan = $('span#seconds');

    startButton.on('click', startTimer);
    stopButton.on('click', stopTimer);

    let timer;

    function startTimer() {
        clearInterval(timer);
        timer = setInterval(step, 1000);

        function step() {
            let seconds = Number($(secondsSpan).text()) + 1;
            let minutes = Number($(minutesSpan).text());
            let hours = Number($(hoursSpan).text());

            if (seconds > 59) {
                seconds = 0;
                minutes++;
            }

            if (minutes > 59) {
                minutes = 0;
                hours++;
            }

            hoursSpan.text(pad(hours, 2));
            minutesSpan.text(pad(minutes, 2));
            secondsSpan.text(pad(seconds, 2));
        }
    }

    function stopTimer() {
        clearInterval(timer);
    }

    function pad(str, max) {
        str = str.toString();
        return str.length < max ? pad("0" + str, max) : str;
    }
}