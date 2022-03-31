package 设计模式.状态模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 关闭状态(具体状态)
 */
public class ClosingState extends LifeState {

    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.open();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
    
