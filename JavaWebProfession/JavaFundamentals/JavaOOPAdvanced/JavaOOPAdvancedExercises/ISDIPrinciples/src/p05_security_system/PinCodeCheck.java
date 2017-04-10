package p05_security_system;

public class PinCodeCheck extends SecurityCheck {

    private PinCodeUI pinCodeUI;

    public PinCodeCheck(PinCodeUI pinCodeUI) {
        this.pinCodeUI = pinCodeUI;
    }

    private boolean isValid(int pin) {
        return true;
    }

    @Override
    public boolean validateUser() {
        int pin = this.pinCodeUI.requestPinCode();

        if (this.isValid(pin)) {
            return true;
        }
        return false;
    }
}