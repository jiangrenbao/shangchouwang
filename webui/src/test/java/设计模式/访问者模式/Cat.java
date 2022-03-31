package 设计模式.访问者模式;

/**
 * @author jiangbao
 * @date 2022/2/16
 * @description 具体元素
 */
public class Cat implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃，喵喵喵！！！");
    }
}
