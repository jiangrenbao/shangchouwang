package 设计模式.中介者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description
 */
public class Client {

    public static void main(String[] args) {
        MediatorStructure mediator = new MediatorStructure();
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        Tenant tenant = new Tenant("李四", mediator);
        // 中介结构要知道房主和租房者
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);
        tenant.constact("需要租三室的房子");
        houseOwner.constact("我这有三室的房子，你需要租吗？");
        // 房主张三获取到的信息：需要租三室的房子
        // 租房者李四获取到的信息：我这有三室的房子，你需要租吗？
    }
}
