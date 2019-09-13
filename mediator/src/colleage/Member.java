package colleage;

import mediator.IChatRoom;


/**
 * @author yejh
 * @create 2019-07_29 14:15
 */
public abstract class Member {
    private String id;
    private IChatRoom chatRoom;

    public Member(String id) {
        this.id = id;
    }

    public void setChatRoom(IChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getId() {
        return id;
    }

    public IChatRoom getChatRoom() {
        return chatRoom;
    }

    public abstract void sendText(String string);

    public abstract void sendImage();

    public abstract void receiveText(String string);

    public abstract void receiveImage();
}
