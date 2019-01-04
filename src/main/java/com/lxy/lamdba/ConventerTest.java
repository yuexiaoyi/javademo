package com.lxy.lamdba;

@FunctionalInterface
interface Conventer{
    Integer convent(String s);
//    int add(int a, int b);
}

public class ConventerTest {
    public static void main(String[] args) {
//        Conventer c1 = s -> Integer.valueOf(s);
        Conventer c1 = Integer::valueOf;
//        Conventer c1 = Integer::sum;

        System.out.println(c1.convent("99"));
//        System.out.println(c1.add(3,4));
    }
}
