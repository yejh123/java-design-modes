package state;

import vote.VoteManager;
import vote.Voter;

/**
 * @author yejh
 * @create 2019-07_26 13:58
 *
 * VoteState 抽象状态接口
 */
public interface VoteState {
    void vote(Voter voter);

}
