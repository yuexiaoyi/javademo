package com.lxy.innerClass;

/**
 * 匿名类，通过接口的方式
 */
interface Product{
    double getPrice();
    String getName();
}

public class AnonymousTest {

    public void test(Product p){
        System.out.println("购买一个"+p.getName()+"花费"+p.getPrice());
    }

    public static void main(String[] args) {
        AnonymousTest anonymous = new AnonymousTest();

        anonymous.test(new Product() {
            @Override
            public double getPrice() {
                return 10000d;
            }

            @Override
            public String getName() {
                return "amc";
            }
        });
    }
}
