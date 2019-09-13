package adapter;

import adaptee.PowerPort;
import target.Charger;

/**
 * @author yejh
 * @create 2019-07_30 10:55
 */
public class USBAdapter implements Charger {
    private PowerPort powerPort;

    public USBAdapter(PowerPort powerPort) {
        this.powerPort = powerPort;
    }

    @Override
    public void charge() {
        powerPort.outputElectricity();
        System.out.println("使用USB数据线对老式安卓手机充电");
    }
}
