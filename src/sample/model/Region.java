package sample.model;



public class Region {

    private Integer id;
    private String name;

    public Region(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
