package request;

/**
 * @author yejh
 * @create 2019-07_29 11:21
 */
public abstract class Request {
    private int requestLevel;
    private String content;
    private int number;

    public int getRequestLevel() {
        return requestLevel;
    }

    public void setRequestLevel(int requestLevel) {
        this.requestLevel = requestLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  this.getClass().getName() + "{" +
                "requestLevel=" + requestLevel +
                ", content='" + content + '\'' +
                ", number=" + number +
                '}';
    }
}
