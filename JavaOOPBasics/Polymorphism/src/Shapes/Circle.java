package Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * this.getRadius() * this.getRadius());
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.getRadius());
    }
}