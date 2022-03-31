package 设计模式.访问者模式;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiangbao
 * @date 2022/2/16
 * @description
 */
public class Client {

    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());
        Owner owner = new Owner();
        home.action(owner);
        Someone someone = new Someone();
        home.action(someone);
    }
}
