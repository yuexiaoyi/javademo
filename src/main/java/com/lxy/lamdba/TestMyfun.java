package com.lxy.lamdba;

import org.junit.Test;

public class TestMyfun {

    @Test
    public void test1(){
        System.out.println(operator(2, (x) -> x * x));
    }

    public Integer operator(int num, Myfun mf){
        return mf.getVal(num);
    }
}
