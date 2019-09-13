/**
 * @author yejh
 * @create 2019-07_24 14:00
 * <p>
 * 代理模式：
 * 一、定义
 * 为其他对象提供一种代理以控制对这个对象的访问
 * <p>
 * 二、角色
 * 1、Subject（主体）
 * Subject角色定义了使proxy和realSubject角色之间具有一致性的接口。
 * 这个接口提供了一个使用的好处，就是client不必却分它使用的是代理对象还是真实对象。
 * <p>
 * 2、Proxy（代理人）
 * Proxy角色会尽量处理来自Client角色的请求。只有当自己不能处理的时候，就交给工作交给真实对象。
 * 代理对象只有在有必要时才会生成真实的对象。
 * <p>
 * 3、RealSubject(真实对象)
 * 就是实际完成工作的对象。
 */

/*以下Java示例解释"虚拟代理"模式。ProxyImage 类别用来访问远程方法。*/
public class ProxyTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");

        image1.displayImage(); // loading necessary
        image2.displayImage(); // loading necessary
    }
}

interface Image {
    public void displayImage();
}

//on System A
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
    }

    public void displayImage() {
        System.out.println("Displaying " + filename);
    }
}

//on System B
class ProxyImage implements Image {
    private String filename;
    private Image image;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void displayImage() {
        prepare();
        if (image == null) {
            image = new RealImage(filename);
        }
        image.displayImage();
    }

    private void prepare(){
        System.out.println("为加载" + filename + "图片做准备（在网页中提前加载图片框）");
    }
}

