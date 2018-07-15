function notify(message) {
    let notificationDiv = document.getElementById('notification');
    notificationDiv.textContent = message;
    notificationDiv.style.display = 'block';

    setTimeout(hideDiv, 2000);

    function hideDiv() {
        notificationDiv.style.display = 'none';
    }
}