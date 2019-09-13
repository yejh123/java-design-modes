package component;

/**
 * @author yejh
 * @create 2019-07_26 23:31
 */
public class PersonLeaf extends PersonMode{
    @Override
    public void addPerson(PersonMode person) {
        System.out.println("无法向树叶节点添加子节点");
    }

    @Override
    public void showTree(int depth) {
        System.out.println("第" + depth + "层叶节点：" + this);
    }

    //写一个构造函数
    public PersonLeaf(String name, String sex, int age) {
        super(name, sex, age);
    }

}
