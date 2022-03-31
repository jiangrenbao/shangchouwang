package 设计模式.状态模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 环境角色
 */
public class Context {

    // 开门状态，这时候电梯只能关闭
    public final static OpenningState openningState = new OpenningState();
    // 关闭状态，这时候电梯可以运行、停止和开门
    public final static ClosingState closeingState = new ClosingState();
    // 运行状态，这时候电梯只能停止
    public final static RunningState runningState = new RunningState();
    // 停止状态，这时候电梯可以开门、运行
    public final static StoppingState stoppingState = new StoppingState();
    // 当前环境的电梯状态
    private LifeState lifeState;


    public void setLiftState(LifeState liftState) {
        // 当前环境改变
        this.lifeState = liftState;
        // 把当前的环境通知到各个实现类中
        this.lifeState.setContext(this);
    }

    public LifeState getLiftState() {
        return this.lifeState;
    }

    public void open() {
        this.lifeState.open();
    }

    public void close() {
        this.lifeState.close();
    }

    public void run() {
        this.lifeState.run();
    }

    public void stop() {
        this.lifeState.stop();
    }
}

