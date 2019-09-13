package abstraction;

import implementor.color.Color;
import implementor.material.Material;

/**
 * @author yejh
 * @create 2019-07_28 10:52
 */
public abstract class Bag {
    private Color color;
    private Material material;
    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
