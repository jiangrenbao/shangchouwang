package 设计模式.命令模式;

/**
 * @author jiangbao
 * @date 2022/2/14
 * @description
 */
public class Test {

    public static void main(String[] args) {
        // 创建两个订单
        Order o1 = new Order();
        o1.setDiningTable(1);
        o1.setFoodDic("炒鸡蛋", 1);
        Order o2 = new Order();
        o2.setDiningTable(1);
        o2.setFoodDic("炒面", 3);
        // 创建一个厨子
        SeniorChef chef = new SeniorChef();
        // 创建两个具体订单命令
        OrderCommand oc1 = new OrderCommand(chef, o1);
        OrderCommand oc2 = new OrderCommand(chef, o2);
        // 创建一个服务员,并将两个订单命令放到list集合中
        Waiter waiter = new Waiter();
        waiter.setCommand(oc1);
        waiter.setCommand(oc2);
        // 执行订单命令
        waiter.orderUp();
    }
}
