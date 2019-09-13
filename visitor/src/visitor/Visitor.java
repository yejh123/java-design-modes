package visitor;
import element.Student;
import element.Teacher;
/**
 * @author yejh
 * @create 2019-07_29 18:31
 * 抽象访问者，为该对象结构中具体元素角色声明一个访问操作接口。
 */



public interface Visitor {

    void visit(Student element);

    void visit(Teacher element);

}