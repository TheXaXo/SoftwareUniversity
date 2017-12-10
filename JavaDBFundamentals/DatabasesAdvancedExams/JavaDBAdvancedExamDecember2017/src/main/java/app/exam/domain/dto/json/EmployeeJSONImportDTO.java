package app.exam.domain.dto.json;

import app.exam.domain.entities.Position;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EmployeeJSONImportDTO implements Serializable {
    @Expose
    private String name;

    @Expose
    private int age;

    @SerializedName(value = "position")
    @Expose
    private String positionName;

    private Position position;

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

    public String getPositionName() {
        return this.positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}