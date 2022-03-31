package 设计模式.责任链模式;

/**
 * @author jiangbao
 * @date 2022/2/14
 * @description 部门经理(具体处理者)
 */
public class Manager extends Handler {

    public Manager() {
        //部门经理处理[3,7)天的请假
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("部门经理审批：同意。");
    }
}
