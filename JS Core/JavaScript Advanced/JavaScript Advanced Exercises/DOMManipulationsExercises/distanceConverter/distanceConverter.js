function attachEventsListeners() {
    document.getElementById('convert').addEventListener('click', convert);

    function convert() {
        let distance = Number(document.getElementById('inputDistance').value);
        let from = document.getElementById('inputUnits').value;
        let to = document.getElementById('outputUnits').value;
        let asMeters = distance;

        switch (from) {
            case 'km':
                asMeters = 1000 * distance;
                break;
            case 'cm':
                asMeters = 0.01 * distance;
                break;
            case 'mm':
                asMeters = 0.001 * distance;
                break;
            case 'mi':
                asMeters = 1609.34 * distance;
                break;
            case 'yrd':
                asMeters = 0.9144 * distance;
                break;
            case 'ft':
                asMeters = 0.3048 * distance;
                break;
            case 'in':
                asMeters = 0.0254 * distance;
                break;
        }

        let resultDistance = asMeters;

        switch (to) {
            case 'km':
                resultDistance = asMeters / 1000;
                break;
            case 'cm':
                resultDistance = asMeters / 0.01;
                break;
            case 'mm':
                resultDistance = asMeters / 0.001;
                break;
            case 'mi':
                resultDistance = asMeters / 1609.34;
                break;
            case 'yrd':
                resultDistance = asMeters / 0.9144;
                break;
            case 'ft':
                resultDistance = asMeters / 0.3048;
                break;
            case 'in':
                resultDistance = asMeters / 0.0254;
                break;
        }

        document.getElementById('outputDistance').value = resultDistance;
    }
}