package com.lxy.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. 创建stream
 *
 * 2.中间操作
 *
 * 3.终止stream
 */
public class TestStreamApi {

    /**
     * 生成stream
     */
    @Test
    public void test1(){
        //1.通过Collection的Stream，parallelStream方法
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Stream<String> st = list.stream();
        st.forEach(System.out::println);

        //2.通过Arrays的stream()方法
        String[] s = new String[]{
                "a","b","c","d","e","f"
        };

        Stream<String> ss = Arrays.stream(s,0,2);

        ss.forEach(System.out::println);

        //3.由值创建流。Stream的of方法。本质还是调用Arrays.stream()方法
        Stream<String> so = Stream.of("a","b","c","d","e");
        so.forEach(System.out::println);

        //4.通过函数创建无限流Stream.iterate,Stream.iterate的generate


    }

    /**
     * stream的中间操作
     * filter
     * distinct
     * limit
     * skip
     *
     * map
     * flatMap
     *
     * sorted
     *
     * 终止操作
     * allMatch
     * findFirst
     * findAny
     * count
     * max
     * min
     * forEach
     * reduce
     * collect
     */
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("bbb");
        list.add("cc");
        list.add("dd");
        list.add("aaaa");
        list.add("eeeee");
        list.stream().filter(x -> x.equals("c")).forEach(System.out::println);
       /* list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("c");
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
*/

       list.stream().map((x) -> x.toUpperCase()).forEach(System.out::println);

       list.stream().sorted().forEach(System.out::println);

        boolean rs = list.stream().allMatch(x -> x.length() == 3);
        System.out.println(rs);
    }


    @Test
    public void test3(){
        Integer[] rs = new Integer[]{1,2,3,4,5};

        Arrays.stream(rs).map((x) -> x * x).forEach(System.out::println);
    }


}
