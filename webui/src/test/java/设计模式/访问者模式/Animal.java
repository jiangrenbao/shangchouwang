package 设计模式.访问者模式;

/**
 * @author jiangbao
 * @date 2022/2/16
 * @description 抽象元素
 */
public interface Animal {

    /**
     * 接收人类喂养
     */
    void accept(Person person);
}
