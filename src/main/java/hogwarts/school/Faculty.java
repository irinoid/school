package hogwarts.school;

import java.util.Objects;

public class Faculty {
    private final Long id;
    private final String name;
    private final String color;

    public Faculty(Long id, String name, String color){
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Faculty name1 = (Faculty) other;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
