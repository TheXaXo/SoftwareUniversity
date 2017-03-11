package MethodOverriding;

public class Square extends Rectangle {
    public Square(double sideA) {
        super.setSideA(sideA);
    }

    @Override
    public double area() {
        return super.getSideA() * super.getSideA();
    }
}