package 设计模式.责任链模式;

/**
 * @author jiangbao
 * @date 2022/2/14
 * @description 抽象处理者
 */
public abstract class Handler {

    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;
    // 具体领导能批准的请假天数的区间
    private int numStart;
    private int numEnd;

    //领导上面的领导
    private Handler nextHandler;

    // 提交请假条
    public final void submit(LeaveRequest leave) {
        if (0 == this.numStart) {
            return;
        }
        // 如果请假天数达到该领导者的处理要求(第三种情况是上不封顶的那个大领导)
        if (leave.getNum() <= this.numStart || (leave.getNum() > this.numStart && leave.getNum() < this.numEnd) || this.numEnd == 0) {
            this.handleLeave(leave);
        }
        // 请假天数未达到领导有资格审批的标准
        else{
            if (this.nextHandler != null){
                this.nextHandler.submit(leave);
            }
        }
    }

    // 领导处理请假条的方法
    protected abstract void handleLeave(LeaveRequest leave);


    // 设置请假天数范围 上不封顶
    public Handler(int numStart) {
        this.numStart = numStart;
    }

    //设置请假天数范围
    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    //设置上级领导
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

}
