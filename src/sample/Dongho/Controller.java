package sample.Dongho;

import javafx.application.Platform;
import javafx.scene.text.Text;

public class Controller {
    public Text Min;
    public Text Sec;
    public Integer min=2;
    public Integer sec=10;
    boolean start=true;
    boolean stop;
    public void start(){
        if (start){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (min>=0&&sec>=0){
                        if (!stop) {
                            Min.setText(min >= 10 ? min.toString() : "0" + min.toString());
                            Sec.setText(sec >= 10 ? sec.toString() : "0" + sec.toString());
                            sec--;
                            if (sec < 0) {
                                sec = 59;
                                min--;
                            }

                            try {
                                Thread.sleep(100);
                            } catch (Exception e) {
                            }
                        }else{
                            return;
                        }
                    }
                    System.out.println(start);
                }
            }).start();
            start=false;
        }else {
            System.out.println("da chay");
        }
    }
    public void stop(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                start=true;
                stop=true;
            }
        }).start();
    }

    public void reset(){

    }
}
