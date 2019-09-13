package reflectFactory.factory;

import reflectFactory.dataBase.IDept;
import reflectFactory.dataBase.IEmp;
import reflectFactory.dataBase.SQLServerDept;

/**
 * @author yejh
 * @create 2019-07_26 10:31
 */
public class DataAccess {
    private static final String PACKAGE = "reflectFactory.dataBase.";

    public static IEmp getEmpInstance(String db) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<IEmp> clazz = (Class<IEmp>) Class.forName(PACKAGE + db + "Emp");
        return clazz.newInstance();
    }

    public static IDept getDeptInstance(String db) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<IDept> clazz = (Class<IDept>) Class.forName(PACKAGE + db + "Dept");
        return clazz.newInstance();
    }
}
