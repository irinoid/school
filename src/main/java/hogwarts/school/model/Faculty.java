package hogwarts.school.model;

import nonapi.io.github.classgraph.json.Id;

import java.util.Objects;

//@Entity
public class Faculty {
    @Id
    //@GeneratedValue
    private long id;
    private String name;
    private String color;

    public Faculty (long id, String name, String color){
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Faculty faculty1 = (Faculty) other;
        return id==faculty1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
