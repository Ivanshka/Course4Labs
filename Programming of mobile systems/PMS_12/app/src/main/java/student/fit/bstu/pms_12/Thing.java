package student.fit.bstu.pms_12;

public class Thing {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
