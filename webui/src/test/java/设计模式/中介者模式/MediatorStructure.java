package 设计模式.中介者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 中介机构(具体中介者)
 */
public class MediatorStructure extends Mediator {

    // 中介结构必须知道所有房主和租房者的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public void constact(String message, Person person) {
        if (person == houseOwner) {
            //如果是房主，则租房者获得信息
            tenant.getMessage(message);
        } else {
            //反则是房主获得信息
            houseOwner.getMessage(message);
        }
    }

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

}

