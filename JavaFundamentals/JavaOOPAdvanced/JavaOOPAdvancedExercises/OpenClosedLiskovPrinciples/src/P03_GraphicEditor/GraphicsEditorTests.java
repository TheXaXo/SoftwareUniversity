package P03_GraphicEditor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphicsEditorTests {

    private static final String EXPECTED_CIRCLE_VALUE = "I'm a Circle";
    private static final String EXPECTED_RECTANGLE_VALUE = "I'm a Rectangle";

    private GraphicEditor editor;

    @Before
    public void initializeObject() {
        this.editor = new GraphicEditor();
    }

    @Test
    public void testDrawingCircle() {
        String output = this.editor.drawShape(new Circle());

        Assert.assertEquals(EXPECTED_CIRCLE_VALUE, output);
    }

    @Test
    public void testDrawingRectangle() {
        String output = this.editor.drawShape(new Rectangle());

        Assert.assertEquals(EXPECTED_RECTANGLE_VALUE, output);
    }
}