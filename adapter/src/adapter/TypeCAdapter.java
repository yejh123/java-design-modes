package adapter;

import adaptee.PowerPort;
import target.Charger;

/**
 * @author yejh
 * @create 2019-07_30 10:54
 */
public class TypeCAdapter implements Charger {
    private PowerPort powerPort;

    public TypeCAdapter(PowerPort powerPort) {
        this.powerPort = powerPort;
    }

    @Override
    public void charge() {
        powerPort.outputElectricity();
        System.out.println("使用TypeC数据线对新型安卓手机充电");
    }
}
