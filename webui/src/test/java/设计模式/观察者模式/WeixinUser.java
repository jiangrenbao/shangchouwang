package 设计模式.观察者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 具体观察者
 */
public class WeixinUser implements Observer {

    // 微信用户名
    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
