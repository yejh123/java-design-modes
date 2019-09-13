package component;

/**
 * @author yejh
 * @create 2019-07_26 23:31
 */
public abstract class PersonMode {
    //人名
    private String name;
    //性别
    private String sex;
    //年龄
    private int age;

    public abstract void addPerson(PersonMode person);

    public abstract void showTree(int depth);

    public PersonMode(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    //个人信息
    public String toString(){
        String info="姓名:"+name+"\t性别:"+sex+"\t年龄:"+age;
        return info;
    }
}
