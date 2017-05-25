package BorderControl;

public class Robot implements Identifiable {

    private String model;
    private String id;

    public Robot(String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
