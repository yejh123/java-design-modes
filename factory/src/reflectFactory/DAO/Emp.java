package reflectFactory.DAO;

/**
 * @author yejh
 * @create 2019-07_25 23:26
 */
public class Emp {
    private String id;
    private String name;

    public Emp(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
