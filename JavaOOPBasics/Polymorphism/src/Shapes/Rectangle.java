package Shapes;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    private double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void calculateArea() {
        super.setArea(this.getWidth() * this.getHeight());
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * this.getHeight() + 2 * this.getWidth());
    }
}