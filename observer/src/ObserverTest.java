import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author yejh
 * @create 2019-07_25 11:41
 *
 * 观察者模式(Observer Pattern)
 * 一、定义
 * 定义对象间的一种一对多依赖关系，使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新。
 * 观察者模式又叫做发布-订阅（Publish/Subscribe）模式、模型-视图（Model/View）模式、源-监听器（Source/Listener）模式或从属者（Dependents）模式。
 *
 * 二、角色
 * 1、Subject：抽象主题（抽象被观察者）
 * 抽象主题角色把所有观察者对象保存在一个集合里，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加和删除观察者对象。
 *
 * 2、ConcreteSubject：具体主题（具体被观察者）
 * 该角色将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知。
 *
 * 3、Observer：抽象观察者
 * 是观察者者的抽象类，它定义了一个更新接口，使得在得到主题更改通知时更新自己。
 *
 * 4、ConcreteObserver：具体观察者
 * 实现抽象观察者定义的更新接口，以便在得到主题更改通知时更新自身的状态。
 *
 * 三、分析
 * 观察者模式描述了如何建立对象与对象之间的依赖关系，如何构造满足这种需求的系统。
 * 作为对这个通知的响应，每个观察者都将即时更新自己的状态，以与目标状态同步，这种交互也称为发布-订阅(publishsubscribe)。
 * 目标是通知的发布者，它发出通知时并不需要知道谁是它的观察者，可以有任意数目的观察者订阅它并接收通
 *
 * 四、优点
 * 1、观察者模式可以实现表示层和数据逻辑层的分离，并定义了稳定的消息更新传递机制，抽象了更新接口，使得可以有各种各样不同的表示层作为具体观察者角色。
 * 2、观察者模式在观察目标和观察者之间建立一个抽象的耦合。
 * 3、观察者模式支持广播通信。
 * 4、观察者模式符合“开闭原则”的要求。
 */

/* 使用观察者模式设计一个监听系统 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Listener("事件源已触发");
        Observer person1 = new Person("捞昌");
        Observer person2 = new Person("拉昌");
        subject.attach(person1);
        subject.attach(person2);
        subject.myNotify();

    }
}

interface Subject{
    void myNotify();
    void attach(Observer observer);
    void detach(Observer observer);
    String getSubjectState();
}

interface Observer{
    void update(Subject subject);
}

class Listener implements Subject{
    private ArrayList<Observer> observers = new ArrayList<>();
    private String subjectState;

    public Listener(String subjectState) {
        this.subjectState = subjectState;
    }

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }

    @Override
    public void myNotify() {
        Iterator<Observer> iterator = this.observers.iterator();
        while(iterator.hasNext()){
            iterator.next().update(this);
        }
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }
}

class Person implements Observer{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject)
    {
        System.out.println("观察者: " + name + ", 状态发生了改变：" + subject.getSubjectState() );
    }
}