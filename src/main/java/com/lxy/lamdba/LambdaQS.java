package com.lxy.lamdba;

interface Eatable{
    void  testEat();
}

interface Flyable{
    void fly(String weather);
}

interface Addable{
    int add(int a, int b);
}

public class LambdaQS {

    public void eat(Eatable e){
        System.out.println(e);
        e.testEat();
    }

    public void drive(Flyable f){
        System.out.println(f);
        f.fly("tk");
    }

    public void test(Addable add){
        System.out.println("5与3的和为："+ add.add(5,3));
    }

    public static void main(String[] args) {
        LambdaQS qs = new LambdaQS();
      /*  qs.eat(new Eatable() {
            @Override
            public void testEat() {
                System.out.println("苹果味道不错");
            }
        });*/
      qs.eat(()->{
          System.out.println("苹果味道不错");
      });

//      qs.drive(weather -> {
//          System.out.println("今天天气很好！");
//      });

        qs.drive(new Flyable() {
            @Override
            public void fly(String weather) {
                System.out.println("今天天气很好！");
            }
        });

//      qs.test((a, b) -> {return a + b;});//表达式是针对的形参
        qs.test(new Addable() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        });
    }
}
