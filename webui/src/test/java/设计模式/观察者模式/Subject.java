package 设计模式.观察者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 抽象主题类
 */
public interface Subject {

    // 增加订阅者
    public void attach(Observer observer);

    // 删除订阅者
    public void detach(Observer observer);

    // 通知订阅者更新消息
    public void notify(String message);
}
