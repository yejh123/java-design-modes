package mediator;

import colleage.Member;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author yejh
 * @create 2019-07_29 14:16
 */
public class ChatGroup implements IChatRoom {
    private String roomId;
    private ArrayList<Member> members = new ArrayList<>();

    private static final String[] muteWords = {"操", "草", "尼玛", "你妈", "你吗", "nm"};

    public ChatGroup(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public void register(Member member) {
        this.members.add(member);
        member.setChatRoom(this);
    }

    @Override
    public void sendText(String string) {
        for (int i = 0; i < muteWords.length; ++i) {
            int index = 0;
            String muteWord = muteWords[i];
            while ((index = string.indexOf(muteWord, index)) != -1) {
                string = string.replaceAll(muteWord, "**");

            }
        }
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            iterator.next().receiveText(string);
        }
    }

    @Override
    public void sendImage() {
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            iterator.next().receiveImage();
        }
    }

    public String getRoomId() {
        return roomId;
    }
}
