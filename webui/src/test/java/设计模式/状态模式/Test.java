package 设计模式.状态模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 测试
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
