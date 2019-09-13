package component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yejh
 * @create 2019-07_26 23:31
 */
public class PersonBranch extends PersonMode {
    private List<PersonMode> personModeList=new ArrayList<>();

    public PersonBranch(String name, String sex, int age) {
        super(name, sex, age);
    }

    public void addPerson(PersonMode person){
        this.personModeList.add(person);
    }

    @Override
    public void showTree(int depth) {
        System.out.println("第" + depth + "层枝节点：" + this);
        Iterator<PersonMode> iterator = this.personModeList.iterator();
        while(iterator.hasNext()){
            iterator.next().showTree(depth +1);
        }
    }

    public List<PersonMode> getPersonModeList(){
        return this.personModeList;
    }
}

