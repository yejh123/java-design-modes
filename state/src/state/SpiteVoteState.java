package state;

import vote.VoteManager;
import vote.Voter;

/**
 * @author yejh
 * @create 2019-07_26 14:00
 */
public class SpiteVoteState implements VoteState {
    @Override
    public void vote(Voter voter) {
        int count = voter.getCount();
        if(count < 9){
            VoteManager voteManager = voter.getVoteManager();
            voteManager.subtract(voter.getVoteItem());  //减去票数
            System.out.println("你有恶意刷屏行为，取消投票资格");
        }else {
            voter.setState(new BlackVoteState());
            voter.getState().vote(voter);
        }
    }
}
