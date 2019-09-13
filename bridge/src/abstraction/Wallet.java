package abstraction;

/**
 * @author yejh
 * @create 2019-07_28 10:53
 */
public class Wallet extends Bag{
    @Override
    public String toString() {
        return "Wallet{" + this.getColor() + "，" + this.getMaterial() + "}";
    }
}
