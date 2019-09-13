import element.Element;
import element.ObjectStructure;
import element.Student;
import element.Teacher;
import visitor.GradeSelection;
import visitor.ResearcherSelection;
import visitor.Visitor;

/**
 * @author yejh
 * @create 2019-07_29 18:24
 *
 * 访问者模式
 * 一、定义
 * 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下定义作用于这些元素的新操作。
 *
 * 二、角色
 * 1、Visitor（抽象访问者）
 * 抽象访问者为对象结构中每一个具体元素类ConcreteElement声明一个访问操作，从这个操作的名称或参数类型可以清楚知道需要访问的具体元素的类型，
 * 具体访问者则需要实现这些操作方法，定义对这些元素的访问操作。
 *
 * 2、ConcreteVisitor（具体访问者）
 * 具体访问者实现了抽象访问者声明的方法，每一个操作作用于访问对象结构中一种类型的元素。
 *
 * 3、Element（抽象元素）
 * 一般是一个抽象类或接口，定义一个Accept方法，该方法通常以一个抽象访问者作为参数。
 *
 * 4、ConcreteElement（具体元素）
 * 具体元素实现了Accept方法，在Accept方法中调用访问者的访问方法以便完成一个元素的操作。
 *
 * 5、ObjectStructure（对象结构）
 * 对象结构是一个元素的集合，用于存放元素对象，且提供便利其内部元素的方法。
 *
 * 三、优点
 * 增加新的访问操作十分方便，符合开闭原则；
 * 将有关元素对象的访问行为集中到一个访问者对象中，而不是分散在一个个的元素类中，类的职责更加清晰，符合单一职责原则
 *
 * 四、缺点
 * 增加新的元素类很困难，需要在每一个访问者类中增加相应访问操作代码，这违背了开闭原则；
 * 元素对象有时候必须暴露一些自己的内部操作和状态，否则无法供访问者访问，这破坏了元素的封装性。
 */
public class VisitorTest {
    public static void main(String[] args) {
        // 初始化元素
        Element stu1 = new Student("Student Jim", 92, 3);
        Element stu2 = new Student("Student Ana", 89, 1);
        Element t1 = new Teacher("Teacher Mike", 83, 10);
        Element t2 = new Teacher("Teacher Lee", 88, 7);
        // 初始化对象结构
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.addElement(stu1);
        objectStructure.addElement(stu2);
        objectStructure.addElement(t1);
        objectStructure.addElement(t2);
        // 定义具体访问者，选拔成绩优秀者
        Visitor gradeSelection = new GradeSelection();
        // 具体的访问操作，打印输出访问结果
        objectStructure.accept(gradeSelection);
        System.out.println("----结构不变，操作易变----");
        // 数据结构是没有变化的，如果我们还想增加选拔科研优秀者的操作，那么如下。
        Visitor researcherSelection = new ResearcherSelection();
        objectStructure.accept(researcherSelection);
    }
}
