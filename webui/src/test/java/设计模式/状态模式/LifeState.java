package 设计模式.状态模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 抽象状态
 */
public abstract class LifeState {

    //定义一个环境角色，也就是封装状态的变化引起的功能变化
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    //电梯开门动作
    public abstract void open();

    //电梯关门动作
    public abstract void close();

    //电梯运行动作
    public abstract void run();

    //电梯停止动作
    public abstract void stop();
}
