function attachGradientEvents() {
    let gradient = document.getElementById("gradient");
    let result = document.getElementById("result");
    gradient.addEventListener('mousemove', onMouseOver);
    gradient.addEventListener('mouseout', onMouseOut);
    let boxWidth = 299;

    function onMouseOver(event) {
        let eventX = event.offsetX;
        result.textContent = Math.trunc((eventX / boxWidth) * 100) + "%";
    }

    function onMouseOut() {
        result.textContent = "";
    }
}