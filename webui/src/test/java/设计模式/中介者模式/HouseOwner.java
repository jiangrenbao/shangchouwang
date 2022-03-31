package 设计模式.中介者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 房屋拥有者(具体同事类)
 */
public class HouseOwner extends Person {

    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    //与中介者联系
    public void constact(String message) {
        mediator.constact(message, this);
    }

    //获取信息
    public void getMessage(String message) {
        System.out.println("房主" + name + "获取到的信息：" + message);
    }
}

