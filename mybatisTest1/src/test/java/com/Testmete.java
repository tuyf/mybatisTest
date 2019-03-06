package com;

import model.User;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.junit.Test;

public class Testmete {


    protected ObjectFactory objectFactory = new DefaultObjectFactory();
    protected ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
    protected ReflectorFactory reflectorFactory= new DefaultReflectorFactory();
    @Test
    public void TestMetaObject() {
        User user = new User();
        user.setUserEmail("likewindy@123.com");
        user.setUserName("likewindy");
//        MetaObject metaObject = new MetaObject(user);
        MetaObject metaObject =  MetaObject.forObject(user,objectFactory,
                objectWrapperFactory,reflectorFactory);
        //获取值方法模式
        Object value = metaObject.getValue("userName");
        //获取值Field模式
        Object value2 = metaObject.getValue("UserEmail");
        System.out.println("value:" + value + "   value2:" + value2);
        //设置UserEmail的值
        metaObject.setValue("UserEmail", "123456@123.com");
        System.out.println("user.getUserEmail():  "+user.getUserEmail());
    }

}
