package 设计模式.中介者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 抽象中介者
 */
public abstract class Mediator {

    //申明一个联络方法
    public abstract void constact(String message,Person person);
}
