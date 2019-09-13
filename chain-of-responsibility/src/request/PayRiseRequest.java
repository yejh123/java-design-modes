package request;

/**
 * @author yejh
 * @create 2019-07_29 11:30
 */
public class PayRiseRequest extends Request{
    public PayRiseRequest(String content, int number) {
        super();
        this.setContent(content);
        this.setNumber(number);
        if (number <= 500) {
            this.setRequestLevel(3);
        } else {
            this.setRequestLevel(4);
        }
    }
}
