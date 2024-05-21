package com.xd.service;

import com.xd.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * @Transactional 可以加到方法或者类
     * 1、只读模式可以提高查询事务的效率，事务中只有查询代码时推荐使用只读模式。
     *      一般情况下，在类上添加注解，
     *      查询方法可以通过再次添加注解，设置为只读模式，提高效率
     * 2、默认永远不超时，-1
     *      设置timeout=时间 单位秒，超时会回滚事务，抛出异常TransactionTimedOutException
     *      如果类上设置了事务属性，方法也设置了事务注解，方法会不会生效？
     *          不会生效，因为方法上的注解会覆盖类的注解
     * 3、指定异常回滚和指定异常不会滚，默认运行时异常才会回滚
     *      norollbackfor 回滚范围内，指定异常不会滚
     *  异常继承树
     *    Throwable
     *      error
     *      Exception
     *          RuntimeException（事务默认指定的回滚异常）
     *          IOException
     * 4、隔离级别，推荐设置READ_COMMITTED，mysql默认为REPEATABLE_READ
     *      脏读：一个事务读取了另一个事务未提交的数据
     *      不可重复读：一个事务读取了另一个事务提交的修改数据
     *      幻读：一个事务读取了另一个事务提交的插入数据
     */
    @Transactional(timeout = 3, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(88,1);
        //int i = 1/0;
        /**
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         **/
        new FileInputStream("xxx");
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }

    @Transactional(readOnly = true)
    public void getStudentInfo() {

    }

    /**
     * 声明两个独立修改数据库的事务业务方法
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeAge(){
        studentDao.updateAgeById(991,1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName(){
        studentDao.updateNameById("test12",1);
        int i = 1/0;
    }
}
