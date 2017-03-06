package MethodOverriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle() {

    }

    public Rectangle(double sideA, double sideB) {
        this.setSideA(sideA);
        this.setSideB(sideB);
    }

    protected double getSideA() {
        return this.sideA;
    }

    protected void setSideA(double sideA) {
        this.sideA = sideA;
    }

    private double getSideB() {
        return this.sideB;
    }

    private void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double area() {
        return this.getSideA() * this.getSideB();
    }
}