package com.testReflect;

public class MethodDemo {
    private int num = 2;
    private String str = "xixi";

    public int addResult(int addNum){
        return num + addNum;
    }

    @Override
    public String toString() {
        return "MethodDemo [num=" + num + ", str=" + str + "]";
    }
}