package 设计模式.责任链模式;

/**
 * @author jiangbao
 * @date 2022/2/14
 * @description 测试
 */
public class Test {

    public static void main(String[] args) {
        // 请假条
        LeaveRequest leave = new LeaveRequest("小花", 100, "身体不适");
        // 各位领导
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();
        // 小组长的领导是部门经理
        groupLeader.setNextHandler(manager);
        // 部门经理的领导是总经理
        manager.setNextHandler(generalManager);
        // 提交申请
        groupLeader.submit(leave);
    }
}
