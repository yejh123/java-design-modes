package colleage;

/**
 * @author yejh
 * @create 2019-07_29 14:19
 */
public class DiamondMember extends Member {
    public DiamondMember(String id) {
        super(id);
    }

    @Override
    public void sendText(String string) {
        System.out.println("【超级会员】" + this.getId() + "发送消息：" + string);
        this.getChatRoom().sendText(string);

    }

    @Override
    public void sendImage() {
        System.out.println("【超级会员】" + this.getId() + "：图片");
        this.getChatRoom().sendImage();

    }

    @Override
    public void receiveText(String string) {
        System.out.println("【超级会员】" + this.getId() + "接收消息：" + string);
    }

    @Override
    public void receiveImage() {
        System.out.println("【超级会员】" + this.getId() + "接收图片：" + "图片");
    }

    @Override
    public String toString() {
        return "【超级会员】" + this.getId() + "进入了" + getChatRoom().getRoomId() + "聊天室";
    }
}
