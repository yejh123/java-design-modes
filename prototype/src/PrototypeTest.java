/**
 * @author yejh
 * @create 2019-07_24 15:29
 *
 * 原型模式
 * 一、定义
 * 通过给出一个原型对象来指明所创建的对象的类型，然后用这个原型对象提供的复制办法创建出更多同类型的对象。
 *
 * 二、角色
 * 1、客户(Client)角色：客户类提出创建对象的请求；
 * 2、抽象原型(Prototype)角色：这是一个抽象角色，通常由一个Java接口或者Java抽象类实现。
 * 此角色定义了的具体原型类所需的实现的方法。
 * 3、具体原型(Concrete Prototype)角色：此角色需要实现抽象原型角色要求的克隆相关的接口。
 *
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume1 = new Resume("捞昌", 24);
        resume1.setWorkExperience("2017-2019", "富土康");
        Resume resume2 = (Resume) resume1.clone();
        resume2.setWorkExperience("2018-2020", "工地");
        System.out.println(resume1);
        System.out.println(resume2);
    }
}


class Resume implements Cloneable {
    private String name;
    private int age;
    private WorkExperience workExperience;

    public Resume(String name, int age) {
        this.name = name;
        this.age = age;
        this.workExperience = new WorkExperience();
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workExperience=" + workExperience +
                '}';
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkExperience(String data, String company) {
        this.workExperience.setWorkDate(data);
        this.workExperience.setCompany(company);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume obj = (Resume) super.clone();
        obj.workExperience = (WorkExperience) this.workExperience.clone();
        return obj;
    }
}

class WorkExperience implements Cloneable {
    private String workDate;
    private String company;

    public WorkExperience(String workDate, String company) {
        this.workDate = workDate;
        this.company = company;
    }

    public WorkExperience() {
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "workDate='" + workDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public String getWorkDate() {
        return workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}