package 设计模式.中介者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 抽象同事类
 */
public abstract class Person {

    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
