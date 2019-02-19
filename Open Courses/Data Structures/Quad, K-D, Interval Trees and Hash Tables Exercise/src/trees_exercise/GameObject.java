package trees_exercise;

public class GameObject implements Boundable, Comparable<GameObject> {
    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;

    private Rectangle rectangle;
    private String name;

    public GameObject(String name, int x1, int y1) {
        this(name, x1, y1, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public GameObject(String name, int x1, int y1, int width, int height) {
        this.setBounds(new Rectangle(x1, y1, width, height));
        this.name = name;
    }

    @Override
    public Rectangle getBounds() {
        return this.rectangle;
    }

    @Override
    public void setBounds(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public boolean intersects(GameObject gameObject) {
        return this.rectangle.intersects(gameObject.getBounds());
    }

    @Override
    public int compareTo(GameObject o) {
        return Integer.compare(this.rectangle.getX1(), o.rectangle.getX1());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getName() {
        return this.name;
    }
}