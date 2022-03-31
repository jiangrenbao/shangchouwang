package 设计模式.迭代器模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 测试类
 */
public class Client {

    public static void main(String[] args) {
        // 创建一个容器
        StudentAggregateImpl aggregate = new StudentAggregateImpl();
        // 添加学生
        aggregate.addStudent(new Student("张三","1"));
        aggregate.addStudent(new Student("李四","2"));
        aggregate.addStudent(new Student("王五","3"));
        // 创建迭代器
        StudentIterator iterator = aggregate.getStudentIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
