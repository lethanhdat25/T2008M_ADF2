package sample.ss3;

public class DemoThread extends Thread {
    public void run() {
        for (int i = 10; i >=0; i--) {

            for (int j = 59; j >=0 ; j--) {
                if (i==10){
                    j=0;
                }
                System.out.println((i>=10?i:"0"+i)+" : "+(j>=10?j:"0"+j));
                try {
                    Thread.sleep(10);
                }catch (Exception e){
                }
                if (i==0&&j==1){
                    System.out.println("Het Gio");
                    return;
                }
            }
        }
    }
}
