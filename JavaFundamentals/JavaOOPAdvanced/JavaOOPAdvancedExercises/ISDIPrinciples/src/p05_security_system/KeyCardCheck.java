package p05_security_system;

public class KeyCardCheck extends SecurityCheck {

    private KeyCardUI keyCardUI;

    public KeyCardCheck(KeyCardUI keyCardUI) {
        this.keyCardUI = keyCardUI;
    }

    private boolean isValid(String code) {
        return true;
    }

    @Override
    public boolean validateUser() {
        String code = this.keyCardUI.requestKeyCard();

        if (this.isValid(code)) {
            return true;
        }
        return false;
    }
}