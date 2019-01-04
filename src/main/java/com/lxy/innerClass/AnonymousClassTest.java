package com.lxy.innerClass;

/**
 * 匿名类通过抽象类实现
 */
abstract class Device{
    private String name;
    public abstract double getPrice();

    public Device(String name) {
        this.name = name;
    }

    public Device() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class AnonymousClassTest {

    public void test(Device d){
        System.out.println("购买一个"+d.getName()+"花费"+d.getPrice());
    }


    public static void main(String[] args) {
        AnonymousClassTest act = new AnonymousClassTest();
        act.test(new Device("IBM") {
            @Override
            public double getPrice() {
                return 10000d;
            }
        });

        Device d = new Device() {
            {
                System.out.println("匿名内部类的初始化...");
            }
            @Override
            public double getPrice() {
                return 10000d;
            }

            public String getName() {
                return "MAC";
            }
        };

        act.test(d);
    }

}
