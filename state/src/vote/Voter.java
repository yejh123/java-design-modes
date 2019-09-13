package vote;

import state.VoteState;

/**
 * @author yejh
 * @create 2019-07_26 14:04
 * <p>
 * Voter环境类
 * id：投票者的标识
 * count：投票次数
 * voteItem：投票选项
 * state：状态
 */
public class Voter {
    private String id;
    private int count;
    private String voteItem;
    private VoteState state;
    private VoteManager voteManager;


    public void vote(String voteItem) {
        this.voteItem = voteItem;
        ++count;
        state.vote(this);
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public String getVoteItem() {
        return voteItem;
    }

    public VoteState getState() {
        return state;
    }

    public VoteManager getVoteManager() {
        return voteManager;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setState(VoteState state) {
        this.state = state;
    }

    public void setVoteManager(VoteManager voteManager) {
        this.voteManager = voteManager;
    }
}
