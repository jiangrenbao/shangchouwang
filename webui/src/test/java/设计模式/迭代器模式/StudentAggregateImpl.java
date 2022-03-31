package 设计模式.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 具体容器类
 */
public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> list = new ArrayList<Student>();

    // 学生列表
    @Override
    public void addStudent(Student student) {
        this.list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        this.list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }

}
