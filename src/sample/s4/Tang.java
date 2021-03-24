package sample.s4;

public class Tang {
    int x=0;
    int y=0;
    int z=0;
    public void tangXY(){
        x++;
        y++;
    }
    public void inRaXY(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("x= "+x);
        System.out.println("y= "+y);
    }
    public synchronized void thayDoiXY(){
        tangXY();
        inRaXY();
    }

    public synchronized void thaydoiZ(){
        z++;
        System.out.println(Thread.currentThread().getName());
        System.out.println("z= "+z);
    }
}
