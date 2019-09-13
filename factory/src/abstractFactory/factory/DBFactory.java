package abstractFactory.factory;

import abstractFactory.dataBase.IDept;
import abstractFactory.dataBase.IEmp;

/**
 * @author yejh
 * @create 2019-07_26 10:27
 */
public interface DBFactory {
    IEmp getEmpInstance();

    IDept getDeptInstance();
}
