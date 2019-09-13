/**
 * @author yejh
 * @create 2019-07_23 20:45
 *
 * 一、定义
 * 针对一组算法，将每一个算法封装到具有共同接口的独立的类中，使得它们可以互相替换。
 *
 * 二、角色
 * 1、Context（环境类）：环境类是使用算法的角色，它在解决某个问题（即实现某个方法）时可以采用多种策略。
 * 在环境类中维持一个对抽象策略类的引用实例，用于定义所采用的策略。
 *
 * 2、Strategy（抽象策略类）：它为所支持的算法声明了抽象方法，是所有策略类的父类，
 * 它可以是抽象类或具体类，也可以是接口。环境类通过抽象策略类中声明的方法在运行时调用具体策略类中实现的算法。
 *
 * 3、ConcreteStrategy（具体策略类）：它实现了在抽象策略类中声明的算法，
 * 在运行时，具体策略类将覆盖在环境类中定义的抽象策略类对象，使用一种具体的算法实现某个业务处理。
 *
 * 三、优点
 * 策略模式提供了对“开闭原则”的完美支持，用户可以在不修改原有系统的基础上选择算法或行为，也可以灵活地增加新的算法或行为。
 * 策略模式提供了管理相关的算法族的办法。
 * 策略模式提供了可以替换继承关系的办法。
 * 使用策略模式可以避免使用多重条件转移语句。
 *
 * 四、缺点
 * 客户端必须知道所有策略类，并自行决定使用哪一种策略类。如果算法较多，则会造成很多的策略类。
 *
 * 五、使用时机
 * 如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 * 一个系统需要动态地在几种算法中选择一种。
 * 如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 * 不希望客户端知道复杂的、与算法相关的数据结构，在具体策略类中封装算法和相关的数据结构，提高算法的保密性与安全性。
 *
 * ---------------------
 */

/*使用策略模式设计一个商场打折销售模型*/


public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context("买300返50");
        double resultPrice = context.getResultPrice(800);
        System.out.println(resultPrice);

        System.out.println("*********************");
        Discount discount = (price) -> price * 0.7;
        Context context1 = new Context(discount);
        System.out.println(context1.getResultPrice(2000));
    }
}

interface Discount {

    double getResult(double price);
}

class Context{
    private Discount dis;

    public Context(String str){
        switch (str){
            case ("打八折"):
                this.dis = new Dis1();
                break;
            case ("买300返50"):
                this.dis = new Dis2();
                break;
        }
    }

    public Context(Discount discount){
        this.dis = discount;
    }

    public double getResultPrice(double price){
       return this.dis.getResult(price);
    }

    public void setDis(String str) {
        switch (str){
            case ("打八折"):
                this.dis = new Dis1();
                break;
            case ("买300返50"):
                this.dis = new Dis2();
                break;
        }
    }
}

//策略一：打八折
class Dis1 implements Discount{
    @Override
    public double getResult(double price) {
        return price * 0.8;
    }
}

//策略二：买300返50
class Dis2 implements Discount{
    @Override
    public double getResult(double price) {
        if(price >= 300){
            return price - (int)(price / 300) * 50;
        }
        return price;
    }
}