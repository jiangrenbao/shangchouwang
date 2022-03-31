package 设计模式.迭代器模式;



/**
 * @author jiangbao
 * @date 2022/2/15
 * @description 抽象迭代器
 */
public interface StudentIterator {

    boolean hasNext();

    Student next();
}
