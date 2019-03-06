package com.testReflect;
public class ConstructorDemo {
    private int num;
    private String str;

    public ConstructorDemo(){
        num = 2;
        str = "xixi";
    }

//    public ConstructorDemo(int num,String str){
//        this.num = num;
//        this.str = str;
//    }

    private ConstructorDemo(int num,String str){
        this.num = num;
        this.str = str;
    }

    @Override
    public String toString() {
        return "ConstructorDemo [num=" + num + ", str=" + str + "]";
    }
}