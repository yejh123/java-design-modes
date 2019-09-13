package request;

/**
 * @author yejh
 * @create 2019-07_29 11:25
 */
public class LeaveRequest extends Request {
    public LeaveRequest(String content, int number) {
        super();
        this.setContent(content);
        this.setNumber(number);
        if (number <= 2) {
            this.setRequestLevel(1);
        } else {
            this.setRequestLevel(2);
        }
    }
}
