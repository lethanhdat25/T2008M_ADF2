package sample.Dongho;

import javafx.application.Platform;
import javafx.scene.text.Text;

public class Controller {
    public Text Min;
    public Text Sec;
    public Integer min=2;
    public Integer sec=10;
    boolean start=true;
    boolean stop=false;
    boolean reset=false;
    public void start(){
        if (start) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (min >= 0 && sec >= 0) {
                        if (reset) {
                            min=0;
                            sec=0;
                            Min.setText("0" + min.toString());
                            Sec.setText("0" + sec.toString());
                        } else {
                            Min.setText(min >= 10 ? min.toString() : "0" + min.toString());
                            Sec.setText(sec >= 10 ? sec.toString() : "0" + sec.toString());
                            if (stop) {
                                Min.setText(min >= 10 ? min.toString() : "0" + min.toString());
                                Sec.setText(sec >= 10 ? sec.toString() : "0" + sec.toString());
                            } else {
                                sec--;
                                if (sec < 0) {
                                    sec = 59;
                                    min--;
                                }
                            }

                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }).start();
            System.out.println(start);
            start=false;
        }
    }

    public void stop(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (stop){
                    stop=false;
                }else stop=true;
            }
        }).start();
    }

    public void reset(){
        reset=true;
        start=true;
    }
}
