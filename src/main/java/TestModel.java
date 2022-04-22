public class TestModel {

    public String name;
    public long id;

    public TestModel(String name, long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
