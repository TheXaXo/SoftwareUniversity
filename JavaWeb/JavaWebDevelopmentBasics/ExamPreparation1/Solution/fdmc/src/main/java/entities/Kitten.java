package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "kittens")
public class Kitten {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "breed", nullable = false)
    private String breed;

    public Kitten() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result
                .append("<div class=\"kitten col-md-4 justify-content-center\">")
                .append(String.format("<img src=\"%s.jpg\" class=\"img-thumbnail\">", this.breed.toLowerCase()))
                .append(String.format("<h6 class=\"text-center\">Name: %s</h6>", this.name))
                .append(String.format("<h6 class=\"text-center\">Age: %d</h6>", this.age))
                .append(String.format("<h6 class=\"text-center\">Breed: %s</h6>", this.breed))
                .append("</div>");

        return result.toString();
    }
}