package handler;

import request.Request;

/**
 * @author yejh
 * @create 2019-07_29 11:16
 */
public class Manager extends Handler{

    public Manager(String name) {
        super(name);
        setLevel(1);
    }

    @Override
    public void execute(Request request) {
        System.out.println(getName() + "正在处理需求：" + request);
    }


}
