package com.springboot.demo.test1;

import com.springboot.demo.bean.Message;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test3 extends Test2 {
    final int a;

    static int m;
//    static {
//        m = 1;
//    }

    public Test3(int a) {
        this.a = a;
    }

    public static void main(String[] args) throws Exception {
//        Singleton singleton = Singleton.getSingleton();
//        singleton.a = 30;
//        Singleton singleton1 = Singleton.getSingleton();
//        System.out.println(singleton1.a);
//        sql();
//        System.out.println(m+1);
//        System.out.println(m);
//        StaticTest.a();
//        Optional<String> string = Optional.of("String");
//        string.ifPresent(System.out::println);
//        StaticTest.i.forEach(System.out::println);
//        new Thread(() -> System.out.println("一个线程")).start();
//        AbstractDemo.t2();

        new Thread(() -> modify(true)).start();
        new Thread(() -> modify(false)).start();

    }

    public static void modify(boolean flag){
        StaticTest staticTest = new StaticTest();
        if (flag) {
            staticTest.a = "为true时触发";
            staticTest.n1 = 1;
        }else {
            staticTest.a = "为false时触发";
            staticTest.n2 = 2;
        }
        System.out.println(staticTest.a);
    }

    public static void sql() throws Exception {
//          m = 10;
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
        unpooledDataSource.setUrl("jdbc:mysql://120.25.228.187:3306/myproject?characterEncoding=utf-8&serverTimezone=UTC");
        unpooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
        unpooledDataSource.setUsername("root");
        unpooledDataSource.setPassword("123456");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(unpooledDataSource);
        PathMatchingResourcePatternResolver path = new PathMatchingResourcePatternResolver();
//        Resource resource = path.getResource("classpath:mapper/*Mapper*.xml");
//        sqlSessionFactoryBean.setMapperLocations(resource);
        String sql = "select * from message";
        SqlSessionFactory object = sqlSessionFactoryBean.getObject();
        SqlSession sqlSession = object.openSession();
        Connection connection = sqlSession.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(object);
//        List<Message> objects = sqlSessionTemplate.selectList("MessageMapper.selectAll");
//        Connection connection = sqlSessionTemplate.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Message message = new Message(resultSet.getInt(1),resultSet.getString(2));
            System.out.println(message);
        }
        sqlSession.close();
        connection.close();
//        for (Message o : objects) {
//            System.out.println(o);
//        }
    }

}
