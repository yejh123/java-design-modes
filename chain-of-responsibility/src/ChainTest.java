import handler.Boss;
import handler.Handler;
import handler.Manager;
import request.LeaveRequest;
import request.PayRiseRequest;
import request.Request;

/**
 * @author yejh
 * @create 2019-07_29 11:16
 */
public class ChainTest {
    public static void main(String[] args) {
        Handler manager = new Manager("捞昌");
        Handler boss = new Boss("昌捞");
        manager.setSuccessor(boss);
        Request request = new LeaveRequest("姥姥请假", 2);
        Request request1 = new LeaveRequest("牢牢请假", 3);
        Request request2 = new PayRiseRequest("捞捞请求加薪", 300);
        manager.handleRequest(request);
        manager.handleRequest(request1);
        manager.handleRequest(request2);
    }
}
