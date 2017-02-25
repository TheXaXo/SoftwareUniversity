package ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalStateException("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalStateException("Height cannot be zero or negative.");
        }

        this.height = height;
    }

    public double getSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }

    public double getLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }
}