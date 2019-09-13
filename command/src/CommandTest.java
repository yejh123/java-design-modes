import command.MacroCommand;
import command.PlayCommand;
import command.RewindCommand;
import command.StopCommand;
import receiver.Player;

/**
 * @author yejh
 * @create 2019-07_28 22:57
 *
 * 命令模式
 * 一、定义
 * 将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤销的操作。
 * 命令模式是一种对象行为型模式，其别名为动作(Action)模式或事务(Transaction)模式。
 *
 * 二、角色
 * 客户端角色(Client)：创建一个具体命令ConcreteCommand对象并确定其接收者。
 *
 * 命令角色(Command)： 声明一个给所有具体命令类的抽象接口。
 *
 * 具体命令角色(ConcreteCommand)：定义一个接收者和行为之间的弱耦合；实现execute()方法，负责调用接收者的相应操作。execute()方法通常叫做执行方法。
 *
 * 请求者角色(Invoker)：负责调用命令对象执行请求，相关的方法叫做行动方法。
 *
 * 接收者角色(Receiver)：负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 *
 * 三、优点
 * 1、更松散的耦合
 * 命令模式是的发起命令的对象——客户端，和具体实现命令的对象——接收者对象完全解耦，
 * 也就是说发起命令的对象完全不知道具体实现对象是谁，也不知道如何实现。
 *
 * 2、更动态的控制
 * 命令模式把请求封装起来，可以动态的对它进行参数化、队列化和日志化等操作，从而使得系统更灵活。
 *
 * 3、很自然的复合命令
 * 命令模式中的命令对象能够很容易的组合成复合命令，也就是宏命令，从而是系统操作更简单，功能更强大。
 *
 * 4、更好的拓展性
 * 由于发起命令的对象和具体的实现完全解耦，因此拓展新的命令就很容易，只需要实现新的命令对象，然后在装配的时候，
 * 把具体的实现对象设置到命令对象中，然后就可以使用这个命令对象，已有的实现完全不用变化。
 *
 * 四、缺点
 * 使用命令模式可能会导致某些系统有过多的具体命令类。
 * 因为针对每一个命令都需要设计一个具体命令类，因此某些系统可能需要大量具体命令类，这将影响命令模式的使用。
 *
 * 五、适用环境
 * 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
 * 系统需要在不同的时间指定请求、将请求排队和执行请求。
 * 系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作。
 * 系统需要将一组操作组合在一起，即支持宏命令
 */

public class CommandTest {
    public static void main(String[] args) {
        Player player = new Player();
        MacroCommand commands = new MacroCommand();
        commands.addCommand(new PlayCommand(player));
        commands.addCommand(new RewindCommand(player));
        commands.addCommand(new StopCommand(player));
        commands.removeCommand(new StopCommand(player));
        commands.execute();

    }
}
