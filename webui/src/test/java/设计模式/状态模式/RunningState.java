package 设计模式.状态模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 运行状态(具体状态)
 */
public class RunningState extends LifeState {

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯正在运行...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
