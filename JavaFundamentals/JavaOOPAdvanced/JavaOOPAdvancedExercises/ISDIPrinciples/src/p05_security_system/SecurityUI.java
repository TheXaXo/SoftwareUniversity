package p05_security_system;

public interface SecurityUI extends KeyCardUI, PinCodeUI {

    String requestKeyCard();

    int requestPinCode();
}