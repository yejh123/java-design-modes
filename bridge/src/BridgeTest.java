import abstraction.Bag;
import abstraction.HandBag;
import abstraction.Wallet;
import implementor.color.Color;
import implementor.color.orange;
import implementor.material.Material;
import implementor.material.Wool;

/**
 * @author yejh
 * @create 2019-07_28 10:44
 *
 * 桥接模式
 * 一、定义
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 更容易理解的表述是：实现系统可从多种维度分类，桥接模式将各维度抽象出来，各维度独立变化，
 * 之后可通过聚合，将各维度组合起来，减少了各维度间的耦合。
 *
 * 二、角色
 * 1、Abstraction（抽象类）
 * 用于定义抽象类的接口，它一般是抽象类而不是接口，
 * 其中定义了一个 Implementor（实现类接口）类型的对象并可以维护该对象，
 * 它与 Implementor 之间具有关联关系，它既可以包含抽象业务方法，也可以包含具体业务方法。
 *
 * 2、RefinedAbstraction（扩充抽象类）
 * 扩充由 Abstraction 定义的接口，通常情况下它不再是抽象类而是具体类，
 * 它实现了在 Abstraction 中声明的抽象业务方法，在 RefinedAbstraction 中可以调用在 Implementor 中定义的业务方法。
 *
 * 3、Implementor（实现类接口）
 * 定义实现类的接口，这个接口不一定要与 Abstraction 的接口完全一致，事实上这两个接口可以完全不同，
 * 一般而言，Implementor 接口仅提供基本操作，而 Abstraction 定义的接口可能会做更多更复杂的操作。
 * Implementor 接口对这些基本操作进行了声明，而具体实现交给其子类。
 * 通过关联关系，在 Abstraction 中不仅拥有自己的方法，还可以调用到 Implementor 中定义的方法，使用关联关系来替代继承关系。
 *
 * 4、ConcreteImplementor（具体实现类）
 * 具体实现 Implementor 接口，在不同的 ConcreteImplementor 中提供基本操作的不同实现，
 * 在程序运行时，ConcreteImplementor 对象将替换其父类对象，提供给抽象类具体的业务操作方法。
 *
 * 三、理解如何将抽象化(Abstraction)与实现化(Implementation)脱耦，使得二者可以独立地变化。
 * 抽象化：抽象化就是忽略一些信息，把不同的实体当作同样的实体对待。
 * 在面向对象中，将对象的共同性质抽取出来形成类的过程即为抽象化的过程。
 *
 * 实现化：针对抽象化给出的具体实现，就是实现化，抽象化与实现化是一对互逆的概念，
 * 实现化产生的对象比抽象化更具体，是对抽象化事物的进一步具体化的产物。
 *
 * 脱耦：脱耦就是将抽象化和实现化之间的耦合解脱开，或者说是将它们之间的强关联改换成弱关联，
 * 将两个角色之间的继承关系改为关联关系。
 *
 * 桥接模式中的所谓脱耦，就是指在一个软件系统的抽象化和实现化之间使用关联关系（组合或者聚合关系）而不是继承关系，
 * 从而使两者可以相对独立地变化，这就是桥接模式的用意。
 *
 * 四、优点
 * 1、分离抽象接口及其实现部分。
 * 2、桥接模式有时类似于多继承方案，但是多继承方案违背了类的单一职责原则（即一个类只有一个变化的原因），复用性比较差，
 * 而且多继承结构中类的个数非常庞大，桥接模式是比多继承方案更好的解决方法。即符合依赖倒置原则。
 * 4、桥接模式提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统，即符合开闭原则。
 * 5、实现细节对客户透明，可以对用户隐藏实现细节。
 *
 * 四、参考资料
 * https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/bridge.html
 */
public class BridgeTest {
    public static void main(String[] args) {
        Bag bag = new HandBag();
        bag.setColor(new orange());
        bag.setMaterial(new Wool());
        System.out.println(bag);

        System.out.println("*********************");
        Bag diyBag = new Wallet();
        diyBag.setColor(new Color() {
            @Override
            public String toString() {
                return "颜色：黑色";
            }
        });
        diyBag.setMaterial(new Material() {
            @Override
            public String toString() {
                return "材料：貂皮";
            }
        });
        System.out.println(diyBag);
    }
}
