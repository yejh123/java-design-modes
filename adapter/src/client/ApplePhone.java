package client;

import target.Charger;

/**
 * @author yejh
 * @create 2019-07_30 11:05
 */
public class ApplePhone implements Phone {
    private Charger charger;

    public ApplePhone(Charger charger) {
        this.charger = charger;
    }

    @Override
    public void charge(){
        charger.charge();
    }
}
