package sample.manageStudent.danhsach;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.manageStudent.Main;
import sample.manageStudent.model.Sinhvien_st;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Sinhvien_st> tbView;
    public TableColumn<Sinhvien_st,String> txtName;
    public TableColumn<Sinhvien_st,Integer> txtAge;
    public TableColumn<Sinhvien_st,Integer> txtMark;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setCellValueFactory(new PropertyValueFactory<Sinhvien_st,String>("Name"));
        txtAge.setCellValueFactory(new PropertyValueFactory<Sinhvien_st,Integer>("Age"));
        txtMark.setCellValueFactory(new PropertyValueFactory<Sinhvien_st,Integer>("Mark"));
        ObservableList<Sinhvien_st> ds= FXCollections.observableArrayList();
        try {
            FileInputStream fis=new FileInputStream("student.bin");
            DataInputStream dis=new DataInputStream(fis);
            int line=0;
            String txt= dis.readLine();
            String[] str=new String[3];
            while (txt!=null){
                str[line]=txt;
                line++;
                txt= dis.readLine();
                if (line>=3){
                    Sinhvien_st sv=new Sinhvien_st(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
                    ds.add(sv);
                    line=0;
                }
            }
            tbView.setItems(ds);
        }catch (Exception e){

        }
    }

    public void trolai(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../home/menuHome.fxml"));
            Main.mainStage.setTitle("Hello World");
            Main.mainStage.setScene(new Scene(root, 700, 700));
            Main.mainStage.show();
        }catch (Exception e){

        }
    }
}
