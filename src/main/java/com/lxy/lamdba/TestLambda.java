package com.lxy.lamdba;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestLambda {

    /**
     * 实例引用
     * 特定对象::实例方法
     */
    @Test
    public  void  test1(){
        //实例的引用，前提是形参必须与实参相同
//        Consumer<String> consumer = (x)->System.out.println(x);
        Consumer<String> consumer = System.out::println;

        consumer.accept("aaaaa");

        Employee employee = new Employee(11,"aa");
//        Supplier<String> sp = ()-> employee.getName();
        Supplier<String> sp = employee::getName;
        System.out.println(sp.get());

    }


    /**
     * 类引用
     * 类名：：类方法
     */
    @Test
    public void test2(){
//        Comparator<Integer> c = (x,y)->Integer.compare(x,y);
        Comparator<Integer> c = Integer::sum;

        System.out.println(c.compare(3, 4));
    }

    @Test
    public void test3(){
//        BiPredicate<String, Integer> predicate = (x , y) -> x.equals(y);
        BiPredicate<String, Integer> predicate = String::equals;
        System.out.println(predicate.test("aaaa", 11111));

    }


    @Test
    public void test4(){
//        Supplier<Employee> su = ()->new Employee();
        Supplier<Employee> su = Employee::new;
        Employee e = su.get();
        System.out.println(e.getName());
    }
}
