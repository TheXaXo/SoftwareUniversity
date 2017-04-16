package dependencyInversion;

public enum Operation {

    ADDITION('+'), DIVISION('/'), MULTIPLICATION('*'), SUBTRACTION('-');

    private char operationSymbol;

    Operation(char operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public char getOperationSymbol() {
        return this.operationSymbol;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}