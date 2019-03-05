package com;

import model.Person;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class UserTest {


    SqlSession sqlSession ;
    @Test
    public void insertPerson(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 10000;
        String userName = "test";
        int age = 18;
        String mobilePhone = "18000000000";
        Person person = new Person();
        person.setId(id);
        person.setAge(age);
        person.setUserName(userName);
        person.setMobilePhone(mobilePhone);
        try{
            sqlSession.insert("insertPerson",person);
//            void select(String statement, ResultHandler handler);
//            String statement = "select * from person";
//            ResultHandler handler = new DefaultResultHandler();
//            handler
//            sqlSession.select(statement,handler);
            sqlSession.selectOne("queryById",1);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById(){
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try{
            Person person = sqlSession.selectOne("queryById",id);

            sqlSession.commit();
            System.out.println(person.getUserName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    public static void main(String[] args) {

        Reflector reflector = new Reflector(Person.class);
        System.out.println("借宿");

        Constructor<?> con =  reflector.getDefaultConstructor();
        System.out.println("借宿222");

        Field[] fields = reflector.getClass().getDeclaredFields();
        System.out.println("借宿222333");

//        reflector.getClassMethod(Person.class);
    }

}


