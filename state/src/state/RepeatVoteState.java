package state;

import vote.VoteManager;
import vote.Voter;

/**
 * @author yejh
 * @create 2019-07_26 13:59
 */
public class RepeatVoteState implements VoteState {
    @Override
    public void vote(Voter voter) {
        int count = voter.getCount();
        //如果是投票次数小于5次则警告，否则算作恶意刷票
        if(count < 5){
            System.out.println("请不要重复投票");
        }else {
            voter.setState(new SpiteVoteState());
            voter.getState().vote(voter);
        }
    }
}
