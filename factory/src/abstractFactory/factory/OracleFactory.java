package abstractFactory.factory;

import abstractFactory.dataBase.OracleDept;
import abstractFactory.dataBase.OracleEmp;

/**
 * @author yejh
 * @create 2019-07_26 10:27
 */
public class OracleFactory implements DBFactory {
    public OracleEmp getEmpInstance() {
        return new OracleEmp();
    }

    public OracleDept getDeptInstance() {
        return new OracleDept();

    }
}
