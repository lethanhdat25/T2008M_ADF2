package sample.manageStudent.them;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import sample.manageStudent.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller {
    public TextField txtTen;
    public TextField txtTuoi;
    public TextField txtDiem;
    ArrayList<String> arr=new ArrayList<>();
    public void Them() throws Exception{
        String n=txtTen.getText();
        Integer t=Integer.parseInt(txtTuoi.getText());
        Integer m=Integer.parseInt(txtDiem.getText());
        if (!n.isEmpty()){
            try{
                FileInputStream fis= new FileInputStream("student.bin");
                DataInputStream dis=new DataInputStream(fis);
                String txt=dis.readLine();
                while(txt!=null){
                    arr.add(txt);
                    txt= dis.readLine();
                }
                arr.add(n);
                arr.add(t.toString());
                arr.add(m.toString());
                FileOutputStream fos=new FileOutputStream("student.bin");
                DataOutputStream dos=new DataOutputStream(fos);
                for ( String x:
                        arr) {
                    dos.writeBytes(x+"\n");
                }


            }catch (Exception e){}

            Parent root = FXMLLoader.load(getClass().getResource("../danhsach/danhsach.fxml"));
            Main.mainStage.setTitle("Hello World");
            Main.mainStage.setScene(new Scene(root, 700, 700));
            Main.mainStage.show();
        }
    }
}
