package 设计模式.中介者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 租客(具体同事类)
 */
public class Tenant extends Person {

    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    //与中介者联系
    public void constact(String message) {
        mediator.constact(message, this);
    }

    //获取信息
    public void getMessage(String message) {
        System.out.println("租房者" + name + "获取到的信息：" + message);
    }
}
