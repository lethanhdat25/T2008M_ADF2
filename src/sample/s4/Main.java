package sample.s4;

public class Main {
    public static void main(String[] args){
        Tang p=new Tang();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    p.thayDoiXY();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    p.thayDoiXY();
                }
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <20 ; i++) {
                    p.thaydoiZ();
                }
            }
        });
        t1.setName("T1------");
        t2.setName("T2------");
        t3.setName("T3------");
        t1.start();
        t2.start();
        t3.start();
    }
}
