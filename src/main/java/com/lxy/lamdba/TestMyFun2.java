package com.lxy.lamdba;

import org.junit.Test;

public class TestMyFun2 {


    public Long op(Long a, Long b, MyFun2<Long, Long> f2){
        return (Long) f2.cal(a, b);
    }

    @Test
    public void test1(){
        System.out.println(op(4L,5L,(x,y)-> x + y));
        System.out.println(op(4L,5L,(x,y)-> x * y));
    }
}
