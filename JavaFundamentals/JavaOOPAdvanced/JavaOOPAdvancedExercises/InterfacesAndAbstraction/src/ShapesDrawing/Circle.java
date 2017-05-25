package ShapesDrawing;

public class Circle implements Drawable {

    private int radius;
    private int centerX;
    private int centerY;

    public Circle(int radius, int centerX, int centerY) {
        this.setRadius(radius);
        this.setCenterX(centerX);
        this.setCenterY(centerY);
    }

    public int getRadius() {
        return this.radius;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return this.centerX;
    }

    private void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    private void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    @Override
    public String draw() {
        StringBuilder out = new StringBuilder();

        double rIn = this.getRadius() - 0.4;
        double rOut = this.getRadius() + 0.4;

        for (double y = this.getRadius(); y >= -this.getRadius(); --y) {
            for (double x = -this.getRadius(); x < rOut; x += 0.5) {
                double value = x * x + y * y;

                if (value >= rIn * rIn && value <= rOut * rOut) {
                    out.append("*");
                } else {
                    out.append(" ");
                }
            }
            out.append("\n");
        }

        return out.toString();
    }
}