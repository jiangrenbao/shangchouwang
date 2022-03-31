package 设计模式.迭代器模式;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 容器元素类
 */
public class Student {

    private String name;

    private String number;

    public Student(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
