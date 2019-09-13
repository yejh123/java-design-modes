package element;

import visitor.Visitor;

/**
 * @author yejh
 * @create 2019-07_29 18:31
 */
public interface Element {
    //接受一个抽象访问者访问
    void accept(Visitor visitor);
}
