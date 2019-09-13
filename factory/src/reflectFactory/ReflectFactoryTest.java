package reflectFactory;

import reflectFactory.DAO.Dept;
import reflectFactory.DAO.Emp;
import reflectFactory.dataBase.IDept;
import reflectFactory.dataBase.IEmp;
import reflectFactory.factory.DataAccess;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author yejh
 * @create 2019-07_26 10:16
 */
public class ReflectFactoryTest {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(".//factory//src//reflectFactory//config.properties");
        properties.load(fileInputStream);
        String db = properties.getProperty("db");
        System.out.println(db);

        IEmp iEmp = DataAccess.getEmpInstance(db);
        iEmp.insert(new Emp("001", "捞昌"));
        IDept iDept = DataAccess.getDeptInstance(db);
        iDept.insert(new Dept("a01", "富土康"));
    }
}


