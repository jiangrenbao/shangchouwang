package 设计模式.状态模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 停止状态(具体状态)
 */
public class StoppingState extends LifeState {

    @Override
    public void open() {
        // 状态修改
        super.context.setLiftState(Context.openningState);
        // 动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.closeingState);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}

