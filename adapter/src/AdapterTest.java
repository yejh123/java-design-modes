import adaptee.PowerPort;
import adapter.LightningAdapter;
import adapter.TypeCAdapter;
import adapter.USBAdapter;
import client.AndroidPhone;
import client.ApplePhone;
import client.Phone;
import target.Charger;

/**
 * @author yejh
 * @create 2019-07_30 10:19
 *
 * 适配器模式(Adapter Pattern)
 * 一、定义
 * 将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。
 * 适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。
 *
 * 二、角色
 * 1、Target：目标抽象类
 * 目标抽象类定义客户要用的特定领域的接口
 *
 * 2、Adapter：适配器类
 * 适配器类可以调用另一个接口，作为一个转换器，对适配者和抽象目标类进行适配，它是适配器模式的核心
 *
 * 3、Adaptee：适配者类
 * 被适配的角色，它定义了一个已经存在的接口，这个接口需要适配
 *
 * 4、Client：客户类
 * 针对目标抽象类进行编程，调用在目标抽象类中定义的业务方法。
 *
 * 三、分类
 * 1、类的适配器模式（Adapter与Adaptee是继承关系，这决定了这个适配器模式是类的）
 * 类的适配器模式是把适配的类的API转换成为目标类的API。
 * 冲突：Target期待调用Request方法，而Adaptee并没有（这就是所谓的不兼容了）。
 * 解决方案：为使Target能够使用Adaptee类里的SpecificRequest方法，故提供一个中间环节Adapter类（继承Adaptee & 实现Target接口），
 * 把Adaptee的API与Target的API衔接起来（适配）。
 *
 * 2、对象的适配器模式（Adapter与Adaptee是委派关系，这决定了适配器模式是对象的）
 * 与类的适配器模式相同，对象的适配器模式也是把适配的类的API转换成为目标类的API。
 * 与类的适配器模式不同的是，对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类，符合合成/聚合复用原则
 *
 * 四、适配器模式优缺点
 * （一）优点
 * 1、更好的复用性
 * 系统需要使用现有的类，而此类的接口不符合系统的需要。那么通过适配器模式就可以让这些功能得到更好的复用。
 * 2、透明、简单
 * 客户端可以调用同一接口，因而对客户端来说是透明的。这样做更简单 & 更直接
 * 3、更好的扩展性
 * 在实现适配器功能的时候，可以调用自己开发的功能，从而自然地扩展系统的功能。
 * 4、解耦性
 * 将目标类和适配者类解耦，通过引入一个适配器类重用现有的适配者类，而无需修改原有代码
 * 5、符合开放-关闭原则
 * 同一个适配器可以把适配者类和它的子类都适配到目标接口；可以为不同的目标接口实现不同的适配器，而不需要修改待适配类
 *
 * （二）缺点
 * 过多的使用适配器，会让系统非常零乱，不易整体进行把握
 *
 *
 * 五、类的适配器模式
 * （一）优点
 * 使用方便，代码简化：仅仅引入一个对象，并不需要额外的字段来引用Adaptee实例
 *
 * （二）缺点
 * 高耦合，灵活性低：使用对象继承的方式，是静态的定义方式
 *
 *
 * 六、对象的适配器模式
 * （一）优点
 * 灵活性高、低耦合：采用 “对象组合”的方式，是动态组合方式
 *
 * （二）缺点
 * 使用复杂：需要引入对象实例
 *
 *
 * 七、适用场景
 * 系统需要复用现有类，而该类的接口不符合系统的需求，可以使用适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 * 多个组件功能类似，但接口不统一且可能会经常切换时，可使用适配器模式，使得客户端可以以统一的接口使用它们
 * https://www.jianshu.com/p/9d0575311214
 */
public class AdapterTest {
    public static void main(String[] args) {
        PowerPort powerPort = new PowerPort();
        Phone androidPhone = new AndroidPhone(new TypeCAdapter(powerPort));
        androidPhone.charge();

        Phone oldAndroidPhone = new AndroidPhone(new USBAdapter(powerPort));
        oldAndroidPhone.charge();

        Phone applePhone = new ApplePhone(new LightningAdapter(powerPort));
        applePhone.charge();
    }
}
