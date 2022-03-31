package 设计模式.访问者模式;

/**
 * @author jiangbao
 * @date 2022/2/16
 * @description 具体访问者(客人)
 */
public class Someone implements Person {

    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂食狗");
    }
}
