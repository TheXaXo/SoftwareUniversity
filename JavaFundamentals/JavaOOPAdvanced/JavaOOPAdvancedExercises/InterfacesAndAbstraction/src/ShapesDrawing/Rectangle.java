package ShapesDrawing;

public class Rectangle implements Drawable {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public int getWidth() {
        return this.width;
    }

    private void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    private void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String draw() {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < this.getHeight(); i++) {
            if (i == 0 || i == this.getHeight() - 1) {
                for (int j = 0; j < this.getWidth(); j++) {
                    out.append("* ");
                }
            } else {
                out.append("* ");

                for (int j = 0; j < this.getWidth() - 2; j++) {
                    out.append("  ");
                }

                out.append("*");
            }
            out.append("\n");
        }

        return out.toString();
    }
}