package abstractFactory.factory;

import abstractFactory.dataBase.SQLServerDept;
import abstractFactory.dataBase.SQLServerEmp;

/**
 * @author yejh
 * @create 2019-07_26 10:27
 */
public class SQLServerFactory implements DBFactory {
    public SQLServerEmp getEmpInstance() {
        return new SQLServerEmp();
    }

    public SQLServerDept getDeptInstance() {
        return new SQLServerDept();
    }

}
