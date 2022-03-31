package 设计模式.迭代器模式;


import java.util.List;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 抽象容器类
 */
public interface StudentAggregate {

    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getStudentIterator();
}
