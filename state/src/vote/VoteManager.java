package vote;

import state.NormalVoteState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author yejh
 * @create 2019-07_26 14:00
 * <p>
 * theme：投票主题
 * voteList：投票列表，记录候选人的票数
 */
public class VoteManager {
    private String theme;
    private HashMap<String, Integer> voteList  = new HashMap<>();
    //private HashSet<Voter> invalid = new HashSet<>();


    public VoteManager(String theme) {
        this.theme = theme;
    }

    public HashMap<String, Integer> getVoteList() {
        return voteList;
    }

    public void add(String voteItem) {
        if (voteList.containsKey(voteItem)) {
            voteList.put(voteItem, voteList.get(voteItem) + 1);
        } else {
            voteList.put(voteItem, 1);
        }
    }

    public void subtract(String voteItem){
        if (voteList.containsKey(voteItem) && voteList.get(voteItem) > 0) {
            voteList.put(voteItem, voteList.get(voteItem) - 1);
        }
    }

    /*public void addInvalid(Voter voter){
        invalid.add(voter);

    }*/

    public Voter newVoterInstance(String id) throws Exception {
        Class<Voter> clazz = (Class<Voter>) Class.forName("vote.Voter");
        Voter voter = clazz.newInstance();
        voter.setId(id);
        voter.setVoteManager(this);
        voter.setState(new NormalVoteState());
        return voter;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for(Map.Entry<String, Integer> entry: this.voteList.entrySet()){
            list.append(entry.getKey() + "：" + entry.getValue() +  "票\n");
        }
        return "投票："  + theme + '\n' + list;
    }
}
