package 设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 微信公众号(具体主题, 或者具体被观察者)
 */
public class SubscriptionSubject implements Subject {

    // 储存订阅公众号的微信用户
    private List<Observer> weixinUserlist = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        weixinUserlist.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserlist.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserlist) {
            observer.update(message);
        }
    }

}
