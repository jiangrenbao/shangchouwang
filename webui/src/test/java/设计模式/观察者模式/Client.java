package 设计模式.观察者模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 客户端
 */
public class Client {

    public static void main(String[] args) {
        // 创建个微信公众号
        SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
        // 创建微信用户
        WeixinUser user1 = new WeixinUser("张三");
        WeixinUser user2 = new WeixinUser("李四");
        WeixinUser user3 = new WeixinUser("王五");
        //订阅公众号
        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notify("震惊,一男子半夜竟在...");
    }
}
