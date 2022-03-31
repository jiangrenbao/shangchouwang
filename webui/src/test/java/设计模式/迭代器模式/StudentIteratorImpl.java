package 设计模式.迭代器模式;


import java.util.List;

/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 具体迭代器
 */
public class StudentIteratorImpl implements StudentIterator {

    private List<Student> list;
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student currentStudent = list.get(position);
        position++;
        return currentStudent;
    }
}
