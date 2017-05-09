package avatar.models.monuments;

public abstract class Monument {

    private String name;

    protected Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getAffinity();
}