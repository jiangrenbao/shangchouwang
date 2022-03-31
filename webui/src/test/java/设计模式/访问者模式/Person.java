package 设计模式.访问者模式;

/**
 * @author jiangbao
 * @date 2022/2/16
 * @description 抽象访问者
 */
public interface Person {

    void feed(Cat cat);

    void feed(Dog dog);
}
