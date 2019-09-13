package abstractFactory;

import abstractFactory.DAO.Dept;
import abstractFactory.DAO.Emp;
import abstractFactory.dataBase.*;
import abstractFactory.factory.DBFactory;
import abstractFactory.factory.OracleFactory;
import abstractFactory.factory.SQLServerFactory;

/**
 * @author yejh
 * @create 2019-07_25 22:32
 * <p>
 * 抽象工厂模式(Abstract Factory Pattern)
 * 一、定义
 * 提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。
 * <p>
 * 二、分析
 * 1、产品族
 * 位于不同产品等级结构中,功能相关的产品组成的家族。
 * <p>
 * 抽象工厂模式提供了一种方式，可以将同一产品族的单独的工厂封装起来。
 * 在正常使用中，客户端程序需要创建抽象工厂的具体实现，然后使用抽象工厂作为接口来创建这一主题的具体对象。
 * 客户端程序不需要知道（或关心）它从这些内部的工厂方法中获得对象的具体类型，因为客户端程序仅使用这些对象的通用接口。
 * 抽象工厂模式将一组对象的实现细节与他们的一般使用分离开来。
 * <p>
 * 三、角色
 * 1、AbstractFactory(抽象工厂)：用于声明生成抽象产品的方法
 * 2、ConcreteFactory(具体工厂)：实现了抽象工厂声明的生成抽象产品的方法，生成一组具体产品，这些产品构成了一个产品族，
 * 每一个产品都位于不同的产品等级结构中；
 * 3、AbstractProduct(抽象产品)：为每种产品声明接口，在抽象产品中定义了产品的抽象业务方法；
 * 4、Product(具体产品)：定义具体工厂生产的具体产品对象，实现抽象产品接口中定义的业务方法。
 * <p>
 * 四、优点
 * 1、继承了简单工厂模式的优点
 * 2、符合开放-封闭原则
 * <p>
 * 五、缺点：
 * 1、增加产品族：需要增加新的工厂类，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性，
 * 但仍然很好的支持了“开闭原则”，对于新增加的产品族，只需要对应增加一个新的具体工厂即可，对已有代码无须做任何修改。
 * <p>
 * 2、增加新的产品等级结构：对于增加新的产品等级结构，需要修改所有的工厂角色，包括抽象工厂类，
 * 在所有的工厂类中都需要增加生产新产品的方法，不能很好地支持“开闭原则”。
 * <p>
 * 抽象工厂模式的这种性质称为“开闭原则”的倾斜性，抽象工厂模式以一种倾斜的方式支持增加新的产品，
 * 它为新产品族的增加提供方便，但不能为新的产品等级结构的增加提供这样的方便。
 * <p>
 * 六、三种工厂模式之间的关系
 * 当抽象工厂模式中每一个具体工厂类只创建一个产品对象，也就是只存在一个产品等级结构时，抽象工厂模式退化成工厂方法模式；
 * <p>
 * 抽象工厂模式与工厂方法模式最大的区别在于，工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构。
 * <p>
 * 当工厂方法模式中抽象工厂与具体工厂合并，提供一个统一的工厂来创建产品对象，并将创建对象的工厂方法设计为静态方法时，工厂方法模式退化成简单工厂模式。
 * <p>
 * 抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形态。
 *
 * https://www.hollischuang.com/archives/1420
 */

public class AbstractFactoryTest {
    public static void main(String[] args) {
        DBFactory sqlServerFactory = new SQLServerFactory();
        IEmp iEmp = sqlServerFactory.getEmpInstance();
        IDept iDept = sqlServerFactory.getDeptInstance();
        iEmp.insert(new Emp());
        iDept.insert(new Dept());

        System.out.println("***********************");
        DBFactory oracleFactory = new OracleFactory();
        IEmp iEmp2 = oracleFactory.getEmpInstance();
        IDept iDept2 = oracleFactory.getDeptInstance();
        iEmp2.insert(new Emp());
        iDept2.insert(new Dept());
    }

}

