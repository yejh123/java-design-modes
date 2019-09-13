package handler;

import request.Request;

/**
 * @author yejh
 * @create 2019-07_29 11:16
 */
public abstract class Handler {
    private String name;
    private Handler successor;
    private int level;

    public Handler(String name){
        this.name = name;
    }

    public abstract void execute(Request request);

    public String getName() {
        return name;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void setLevel(int i){
        this.level = i;
    }

    public Handler getSuccessor() {
        return successor;
    }

    public int getLevel() {
        return level;
    }

    public final void handleRequest(Request request){
        if(level >= request.getRequestLevel()){
            this.execute(request);
        }
        else {
            if(this.successor != null){
                System.out.println(this.name + "：事情太严重，需报告上一级");
                this.successor.handleRequest(request);
            }else{
                System.out.println("以后再说吧");
            }
        }
    }
}
