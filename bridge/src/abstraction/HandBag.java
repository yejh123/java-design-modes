package abstraction;

/**
 * @author yejh
 * @create 2019-07_28 10:53
 */
public class HandBag extends Bag{
    @Override
    public String toString() {
        return "HandBag{" + this.getColor() + "，" + this.getMaterial() + "}";
    }
}
