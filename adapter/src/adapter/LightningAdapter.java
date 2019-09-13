package adapter;

import adaptee.PowerPort;
import target.Charger;

/**
 * @author yejh
 * @create 2019-07_30 10:55
 */
public class LightningAdapter implements Charger {
    private PowerPort powerPort;

    public LightningAdapter(PowerPort powerPort) {
        this.powerPort = powerPort;
    }

    @Override
    public void charge() {
        powerPort.outputElectricity();
        System.out.println("使用Lightning数据线对苹果手机充电");
    }
}
