package state;

import vote.VoteManager;
import vote.Voter;

/**
 * @author yejh
 * @create 2019-07_26 13:59
 */
public class NormalVoteState implements VoteState{
    @Override
    public void vote(Voter voter) {
        int count = voter.getCount();
        //如果是第一次投票
        if(count == 1){
            VoteManager voteManager = voter.getVoteManager();
            voteManager.add(voter.getVoteItem());
            System.out.println("恭喜投票成功");
        }else {
            voter.setState(new RepeatVoteState());
            voter.getState().vote(voter);
        }
    }
}
