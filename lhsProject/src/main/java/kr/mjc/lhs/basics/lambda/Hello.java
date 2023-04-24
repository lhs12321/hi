package kr.mjc.lhs.basics.lambda;

//method reference

public class Hello {

    //static hello
    static void sayHelloRachel() {
        System.out.println("안녕하세요 레이첼");
    }

    //instance hello
    void sayHelloJacob() {
        System.out.println("안녕하세요 제이콥");
    }

    //위의 메소드는 인자 없음(Rubbable)
    //-------------------------------------------------------
    //아래 메소드는 인자 한 개(Consumer)

    //static hello
    static void sayStaticHello(String name) {
        System.out.println("안녕하세요"+ name);
    }

    //instance hello
    void sayHello(String name) {
        System.out.println("안녕하세요"+ name);
    }
}
