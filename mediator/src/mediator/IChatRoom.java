package mediator;

import colleage.Member;

/**
 * @author yejh
 * @create 2019-07_29 14:18
 */
public interface IChatRoom {
    void sendText(String string );

    void sendImage();

    void register(Member member);

    String getRoomId();
}
