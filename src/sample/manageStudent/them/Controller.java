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
    public void Them(){
        String n=txtTen.getText();
        Integer t=Integer.parseInt(txtTuoi.getText());
        Integer m=Integer.parseInt(txtDiem.getText());
        if (!n.isEmpty()){
            try{
                FileOutputStream fos=new FileOutputStream("student.bin");
                DataOutputStream dos=new DataOutputStream(fos);
                FileInputStream fis= new FileInputStream("student.bin");
                DataInputStream dis=new DataInputStream(fis);
                String txt=dis.readLine();;
                while(txt!=null){
                    arr.add(txt+"\n");
                    txt= dis.readLine();
                }
                arr.add(n+"\n");
                arr.add(t.toString()+"\n");
                arr.add(m.toString()+"\n");
                for (int i = 0; i < arr.size(); i++) {
                    dos.writeBytes(arr.get(i));
                }
                Parent root = FXMLLoader.load(getClass().getResource("../danhsach/danhsach.fxml"));
                Main.mainStage.setTitle("Hello World");
                Main.mainStage.setScene(new Scene(root, 700, 700));
                Main.mainStage.show();

            }catch (Exception e){}

        }
    }
}
