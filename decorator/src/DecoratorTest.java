/**
 * @author yejh
 * @create 2019-07_24 11:50
 * 装饰模式(Decorator Pattern):
 * 一、定义
 * 动态地给一个对象增加一些额外的职责(Responsibility)，就增加对象功能来说，装饰模式比生成子类实现更为灵活。
 * 其别名也可以称为包装器(Wrapper)，与适配器模式的别名相同，但它们适用于不同的场合。
 * 根据翻译的不同，装饰模式也有人称之为“油漆工模式”，它是一种对象结构型模式。
 *
 * 二、优点
 * 1、比继承灵活，可以动态的给一个对象扩展功能「而不改变原有的对象」，并且不同的装饰器可以实现不同的效果
 * 2、具体的被装饰者和具体的装饰者可以独立变化「新添加一个实现即可」，原有的代码不用改变，符合开--闭原则
 * 3、通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出很多不同行为的组合。
 * 可以使用多个具体装饰类来装饰同一对象，得到功能更为强大的对象。
 *
 * 三、缺点
 * 1、会写更多的代码，生成更多的对象
 * 2、如果是封装的三方类，如果装饰类有多个，那么调用者具体实例化那个不太容易确定「其实文档写清楚，这个就不是问题」
 *
 * 四、适用环境
 * 1、在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 * 2、需要动态地给一个对象增加功能，这些功能也可以动态地被撤销。
 * 3、当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时。
 * 不能采用继承的情况主要有两类：第一类是系统中存在大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长；
 * 第二类是因为类定义不能继承（如final类）.
 *
 * 五、参考资料
 * https://juejin.im/post/5a365557f265da432840f00a#heading-3
 * https://design-patterns.readthedocs.io/zh_CN/latest/structural_patterns/decorator.html
 */


/*使用装饰模式设计一个房屋装修方案*/
public class DecoratorTest {
    public static void main(String[] args) {
        IHouse myHouse1 = new SeaHouse();
        ExtraordinaryDecoration houseWithEDecoration = new ExtraordinaryDecoration(myHouse1);
        houseWithEDecoration.desc();

        System.out.println("****************************");
        IHouse myHouse2 = new CountryHouse();
        OrdinaryDecoration houseWithODecoration = new OrdinaryDecoration(myHouse2);
        houseWithODecoration.desc();
    }
}

//抽象构件接口
interface IHouse{
    void desc();
}

//抽象装饰接口
interface IDecorator extends IHouse{
    void getCost();
}

//具体组件类
class SeaHouse implements IHouse{
    @Override
    public void desc() {
        System.out.println("一间海水环绕的海景房");
    }
}

class CountryHouse implements IHouse{
    @Override
    public void desc() {
        System.out.println("一座背靠青山绿水的乡村田园别墅");
    }
}

class CityHouse implements IHouse{
    @Override
    public void desc() {
        System.out.println("一套处在静谧郊区的公寓房");
    }
}

class ExtraordinaryDecoration implements IDecorator{
    private IHouse house;

    public ExtraordinaryDecoration(IHouse ih){
        this.house = ih;
    }
    @Override
    public void getCost() {
        System.out.println("装修费为二十万，请您付款！");
    }

    @Override
    public void desc() {
        house.desc();
        System.out.println("进行了高档次、全方位的奢华装修");
        this.getCost();
    }
}

class OrdinaryDecoration implements IDecorator{
    private IHouse house;

    public OrdinaryDecoration(IHouse ih){
        this.house = ih;
    }
    @Override
    public void getCost() {
        System.out.println("装修费为十万，请您付款！");
    }

    @Override
    public void desc() {
        house.desc();
        System.out.println("进行了普通的装修");
        this.getCost();
    }
}