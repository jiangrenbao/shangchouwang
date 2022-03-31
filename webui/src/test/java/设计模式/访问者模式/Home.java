package 设计模式.访问者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbao
 * @date 2022/2/16
 * @description 主人家(对象结构)
 */
public class Home {

    private List<Animal> nodeList = new ArrayList<Animal>();

    public void action(Person person) {
        for (Animal node : nodeList) {
            node.accept(person);
        }
    }

    //添加操作
    public void add(Animal animal) {
        nodeList.add(animal);
    }
}
