package sample.ss3;

public class Main {
    public static void main(String[] args){
        DemoThread dt=new DemoThread();
        dt.start();
        DemoThread dt2=new DemoThread();
        dt2.start();
        dt.setPriority(10);
        dt2.setPriority(2);

    }
}
