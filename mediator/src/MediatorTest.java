import colleage.CommonMember;
import colleage.DiamondMember;
import mediator.ChatGroup;

/**
 * @author yejh
 * @create 2019-07_29 12:13
 *
 * 中介者模式(Mediator Pattern)
 * 一、定义
 * 用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，
 * 而且可以独立地改变它们之间的交互。中介者模式又称为调停者模式，它是一种对象行为型模式。
 *
 * 二、角色
 * 1、Mediator 抽象中介者角色
 * 抽象中介者角色定义统一的接口，用于各同事角色之间的通信。
 *
 * 2、Concrete Mediator 具体中介者角色
 * 具体中介者角色通过协调各同事角色实现协作行为，因此它必须依赖于各个同事角色。
 *
 * 3、Colleague 同事角色
 * 每一个同事角色都知道中介者角色，而且与其他的同事角色通信的时候，一定要通过中介者角色协作。
 * 每个同事类的行为分为两种：
 * 一种是同事本身的行为，比如改变对象本身的状态，处理自己的行为等，这种行为叫做自发行为，与其他的同事类或中介者没有任何的依赖；
 * 第二种是必须依赖中介者才能完成的行为，叫做依赖方法。
 *
 * 三、优点
 * 简化了对象之间的交互。
 * 将各同事解耦。
 * 减少子类生成。
 * 可以简化各同事类的设计和实现。
 *
 * 四、缺点
 * 在具体中介者类中包含了同事之间的交互细节，可能会导致具体中介者类非常复杂，使得系统难以维护。
 *
 * 五、适用环境
 * 系统中对象之间存在复杂的引用关系，产生的相互依赖关系结构混乱且难以理解。
 * 一个对象由于引用了其他很多对象并且直接和这些对象通信，导致难以复用该对象。
 * 想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。可以通过引入中介者类来实现，在中介者中定义对象。
 * 交互的公共行为，如果需要改变行为则可以增加新的中介者类。
 *
 * 六、参考资料
 * https://design-patterns.readthedocs.io/zh_CN/latest/behavioral_patterns/mediator.html
 * https://juejin.im/post/5a72c05951882522b552ad3b#heading-26
 *
 * 七、实例
 * 某论坛系统欲增加一个虚拟聊天室，允许论坛会员通过该聊天室进行信息交流。
 * 普通会员(CommonMember)可以给其他会员发送文本信息，
 * 钻石会员(DiamondMember)既可以给其他会员发送文本信息，还可以发送图片信息。
 * 该聊天室可以对不雅字符进行过滤，如“日”等字符；还可以对发送的图片大小进行控制。
 * 用中介者模式设计该虚拟聊天室。
 */
public class MediatorTest {
    public static void main(String[] args) {
        ChatGroup chatGroup = new ChatGroup("6324直播间");
        CommonMember commonMember1 = new CommonMember("孙狗孙笑川");
        CommonMember commonMember2 = new CommonMember("孙笑川258");
        CommonMember commonMember3 = new CommonMember("老莱莱");
        CommonMember commonMember4 = new CommonMember("蔡徐坤");
        CommonMember commonMember5 = new CommonMember("激光笔");
        CommonMember commonMember6 = new CommonMember("臭弟弟");
        CommonMember commonMember7 = new CommonMember("抽象圣经");

        DiamondMember diamondMember1 = new DiamondMember("深海哥");

        chatGroup.register(commonMember1);
        chatGroup.register(commonMember2);
        chatGroup.register(commonMember3);
        chatGroup.register(commonMember4);
        chatGroup.register(commonMember5);
        chatGroup.register(commonMember6);
        chatGroup.register(commonMember7);
        chatGroup.register(diamondMember1);

        commonMember1.sendText("孙狗你吗死了你吗你吗");

        System.out.println("************************");

        commonMember2.sendText("孙狗nmsl");

        System.out.println("************************");

        commonMember5.sendText("孙狗n.m$l");

        System.out.println("************************");

        diamondMember1.sendText("孙狗我来辣");

    }
}
