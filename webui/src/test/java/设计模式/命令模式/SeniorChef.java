package 设计模式.命令模式;

/**
 * 命令接受者
 */
public class SeniorChef {

    public void makeFood(int num,String foodName) {
        System.out.println(num + "份" + foodName);
    }
}
