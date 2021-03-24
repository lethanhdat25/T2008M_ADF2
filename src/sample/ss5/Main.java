package sample.ss5;


import java.io.*;

public class Main {
    public static void main(String[] args){
        try{
            FileOutputStream fos = new FileOutputStream("data.bin");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes(" aa \n");
            dos.writeBytes(" bb \n");
            dos.writeBytes(" cc \n");
            FileInputStream fis = new FileInputStream("data.bin");
            DataInputStream dis = new DataInputStream(fis);
            String txt = dis.readLine();
            while (txt != null){
                System.out.println(txt);
                txt = dis.readLine();
            }
        }catch (FileNotFoundException f) {
            System.out.println("FILE NOT FOUND");
        }catch (IOException io) {
            System.out.println("FILE ERROR");
        }
    }
}