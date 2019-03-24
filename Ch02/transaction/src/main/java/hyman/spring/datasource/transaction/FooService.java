package hyman.spring.datasource.transaction;

/**
 * @描述：
 * @Author：huhan
 * @Date: 2019/2/26 21:53
 */
public interface FooService {

    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;

}
