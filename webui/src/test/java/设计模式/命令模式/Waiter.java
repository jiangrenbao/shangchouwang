package 设计模式.命令模式;

import java.util.ArrayList;

/**
 * 命令发起人
 */
public class Waiter {

    // 底下有很多订单(命令)
    private ArrayList<Command> commands;

    //可以持有很多的命令对象
    public Waiter() {
        commands = new ArrayList();
    }

    /**
     * 添加订单
     */
    public void setCommand(Command cmd) {
        commands.add(cmd);
    }

    /**
     * 处理底下的订单(交给大厨)
     */
    public void orderUp() {
        System.out.println("大厨，新订单来了.......");
        for (int i = 0; i < commands.size(); i++) {
            Command cmd = commands.get(i);
            if (cmd != null) {
                cmd.execute();
            }
        }
    }
}
