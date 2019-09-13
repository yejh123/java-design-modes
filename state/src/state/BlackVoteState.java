package state;

import vote.Voter;

/**
 * @author yejh
 * @create 2019-07_26 14:00
 */
public class BlackVoteState implements VoteState {
    @Override
    public void vote(Voter voter) {
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
