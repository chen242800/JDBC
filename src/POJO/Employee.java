package POJO;

public class Employee {


    private int id;
    private String name;
    private int salay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalay() {
        return salay;
    }

    public void setSalay(int salay) {
        this.salay = salay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salay=" + salay +
                '}';
    }
}

