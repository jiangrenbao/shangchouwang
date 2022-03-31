package 设计模式.责任链模式;

/**
 * @author jiangbao
 * @date 2022/2/14
 * @description 小组长(具体处理者)
 */
public class GroupLeader extends Handler {

    public GroupLeader() {
        //小组长处理[1,3)天的请假
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("小组长审批：同意。");
    }
}
