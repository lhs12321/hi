package kr.mjc.lhs.basics.lambda;

import java.util.function.Consumer;
public class MachineTest2 {
    public void main(){
        Machine machine = new Machine();

        /* anonymous class
        Consumer<String> c1 = new Consumer<>() {
            @Override
            public void accept(String name) {
                System.out.println("Hello " + name);
            }
        }; */

        // lambda exp
        //machine.doTwice(name -> System.out.println("Hello " + name)  );

        // machine. doTwice(c1, "Rachel");

        // lambda exp
        // Consumer<String> c2 = (name) -> System.out.println("Hello " + name);
        // machine.doTwice(c2, "Jacob");

        machine.doTwice((name) -> System.out.println("Hello " + name), "David");

        // method reference
        machine.doTwice(Hello::sayStaticHello, "Paul"); //스태틱
        machine.doTwice(new Hello()::sayHello, "Peter"); //인스턴스

        machine.doTwice(this::say, "Say good bye0"); //인스턴스 (this는 인스턴스 타입만 사용 가능하다. 스태틱은 클래스들을 한 번에 관리하기 때문에 this로 특정 불가능하기 떄문)
        machine.doTwice(System.out::println, "Say good bye1"); // say() 같은 의미
        
        //둘 다 같은거
        machine.doTwice(str -> say(str), "I love you");
        machine.doTwice(this::say, "I love you");
        //둘 다 같은거
        machine.doTwice(str -> System.out.println(str), "I love you");
        machine.doTwice(System.out::println, "I miss you");

    }
    public static void main(String[] args) {
        new MachineTest2().main();
    }
    public static void sayStaticHello(String name) {
        System.out.println("안녕하세요 " + name);
    }
    // instance hello
    public void sayHello(String name) {
        System.out.println("안녕하세요 " + name);
    }
    public void say(String str) {
        System.out.println(str);
    }
}