package abstractFactory.dataBase;

import abstractFactory.DAO.Dept;

/**
 * @author yejh
 * @create 2019-07_26 10:21
 */
public class OracleDept implements IDept {
    public void insert(Dept dept){
        System.out.println("使用Oracle数据库插入新部门");

    }
}
