package com.lxy.lamdba;

@FunctionalInterface
public interface MyFun2<T, R> {
    R cal(T t1, T t2);
}
