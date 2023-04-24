package kr.mjc.lhs.basics.lambda;

public class MachineTest1 {
    public static void main(String[] args){
        Machine machine= new Machine();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Jacob.");
            }
        };
        machine.doTwice(r1);

        // lambda expression
        Runnable r2 = () -> System.out.println("Hello David.");
        machine.doTwice(r2);

        machine.doTwice(() -> System.out.println("Hello Rachel."));
    }
}
