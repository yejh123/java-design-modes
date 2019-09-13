package reflectFactory.DAO;

/**
 * @author yejh
 * @create 2019-07_25 23:26
 */
public class Dept {
    private String id;
    private String dName;

    public Dept(String id, String dName) {
        this.id = id;
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", dName='" + dName + '\'' +
                '}';
    }
}
