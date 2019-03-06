package com.testReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ConstructorTest {
    public static void main(String[] args) throws Exception {
        //使用反射第一步:获取操作类ConstructorDemo所对应的Class对象
        Class<?> cls = Class.forName("com.testReflect.ConstructorDemo");

        //获取默认的构造函数
        Constructor constructor1 = cls.getConstructor(new Class[]{});
        //获取构造函数信息
        System.out.println("修饰符: "+Modifier.toString(constructor1.getModifiers()));
        System.out.println("构造函数名: "+constructor1.getName());
        System.out.println("参数列表: "+constructor1.getParameterTypes());
        //通过默认的构造函数创建ConstructorDemo类的实例
        Object obj = constructor1.newInstance();
        System.out.println("调用默认构造函数生成实例:"+obj.toString());

        System.out.println("===============================================");

        Constructor[] constructors1 = cls.getDeclaredConstructors();

//        constructors1[1].getModifiers();
        System.out.println("私有修饰符: "+Modifier.toString(constructors1[1].getModifiers()));
        System.out.println("私有构造函数名: "+constructors1[1].getName());
        System.out.println("私有参数列表: "+constructors1[1].getParameterTypes());
        //获取构造函数信息
        //通过带参数的构造函数创建ConstructorDemo类的实例
        Object obj222 = constructors1[1].newInstance(new Object[]{3344,"hah444a"});
        System.out.println("调用带参数构造函数生成实例:"+obj222.toString());

//        Constructor[] constructors2 = cls.getDeclaredConstruct(new Class[]{int.class,String.class});;

        //获取带参数的构造函数
//        Constructor constructor2 = cls.getConstructor(new Class[]{int.class,String.class});
//        System.out.println("修饰符: "+Modifier.toString(constructor2.getModifiers()));
//        System.out.println("构造函数名: "+constructor2.getName());
//        System.out.println("参数列表: "+constructor2.getParameterTypes());
//        //获取构造函数信息
//        //通过带参数的构造函数创建ConstructorDemo类的实例
//        Object obj2 = constructor2.newInstance(new Object[]{33,"haha"});
//        System.out.println("调用带参数构造函数生成实例:"+obj2.toString());
    }
}