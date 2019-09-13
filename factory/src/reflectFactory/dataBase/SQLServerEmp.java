package reflectFactory.dataBase;

import reflectFactory.DAO.Emp;

/**
 * @author yejh
 * @create 2019-07_26 10:21
 */
public class SQLServerEmp implements IEmp {
    public void insert(Emp emp) {
        System.out.println("使用SQLServer数据库插入新职员" + emp);

    }

}
