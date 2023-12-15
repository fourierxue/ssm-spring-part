package com.xd.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.xd.controller.StudentController;
import com.xd.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {
    /**
     * jdbctemplate只简化crud，不提供连接池
     * druidDataSource负责连接池的创建和数据库驱动的注册等
     */
    public void testForJava() {
        /**
         *     <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
         *         <property name="url" value="jdbc:mysql://112.124.23.63"/>
         *         <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
         *         <property name="username" value="root"/>
         *         <property name="password" value="SpnDb0914"/>
         *     </bean>
         *     <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate"/>
         *     0.1.两步对应的ioc配置
         */
        //0.创建连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://112.124.23.63:3306/studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("SpnDb0914");
        //1.实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //2.调用方法即可
        //jdbcTemplate.update() ddl,dml,dcl等非查询语句
        //jdbcTemplate.queryForObject() dql查询单个对象
        //jdbcTemplate.query() dql查询集合
    }

    @Test
    public void testForIoc() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        String sql = "insert into students(name, gender, age, class) values (?,?,?,?)";
        /**
         * 参数1：sql语句，可以带占位符，？只能替代值，不能替代关键字，列名等
         * 参数2：Object... 可变参数，传入占位符的值，位置从左往右
         * 返回值，影响行数
         */
        int rows = jdbcTemplate.update(sql, "xx", "南", 48, "xx");
        System.out.println("rows = " + rows);

        /**
         * 查询学生数据
         */
        sql = "select * from students where id = ?";
        /**
         * 参数1：sql语句
         * 参数2：rowMapper 列名和属性名的映射接口
         * 参数3：可变参数 占位符
         */
        Student student = jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                //rs 结果集
                //rowNum 行数
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        }, 1);
        System.out.println("student: " + student);

        /**
         * 查询所有学生数据
         * BeanPropertyRowMapper 帮助我们自动映射列名和属性名，要求列名和属性名相同，不同可以起别名
         */
        sql = "select id, name, age, gender, class as classes from students";
        List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println("student list: " + students);
    }

    @Test
    public void testThreeLayer() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        StudentController controller = applicationContext.getBean("studentController", StudentController.class);
        controller.findAll();
        applicationContext.close();
    }
}
