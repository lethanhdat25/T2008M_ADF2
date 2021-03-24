package sample.tapLam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import sample.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtMark;
    public Button btnSort;
    public Text txtValidate;
    public TableView<SinhVien> txtRs;
    public TableColumn<SinhVien,String> tenSV;
    public TableColumn<SinhVien,Integer> tuoiSV;
    public TableColumn<SinhVien,Integer> diemSV;

    public static Integer identity = 0;
    public static SinhVien editSinhVien;
    public static ObservableList<SinhVien> ds = FXCollections.observableArrayList();
    static boolean sortType = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tenSV.setCellValueFactory(new PropertyValueFactory<SinhVien,String>("name"));
        tuoiSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("age"));
        diemSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("mark"));
    }

    public void input(){
        try {
            String n =  txtName.getText();
            int a = Integer.parseInt(txtAge.getText());
            int m = Integer.parseInt(txtMark.getText());
            if(!n.isEmpty()){
                if(editSinhVien != null){
                    editSinhVien.setName(n);
                    editSinhVien.setAge(a);
                    editSinhVien.setMark(m);
                    for(SinhVien s:ds){
                        if(s.getId()== editSinhVien.getId()){
                            s = editSinhVien;
                            break;
                        }
                    }
                    txtRs.refresh();
                }else {
                    identity++;
                    SinhVien s = new SinhVien(identity,n,a,m);
                    ds.add(s);
                    txtRs.setItems(ds);
                }
                editSinhVien = null;
                txtValidate.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtMark.setText("");

            }else {
                txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
                txtValidate.setDisable(false);
            }
        }catch (Exception e){
            txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
            txtValidate.setDisable(false);
        }

    }

    public void sort(){
        sortType =  !sortType;
        if(sortType){
            Collections.sort(ds, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getMark() - o2.getMark();
                }
            });
            btnSort.setText("Thap den cao");
        }else{
            Collections.sort(ds, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o2.getMark() - o1.getMark();
                }
            });
            btnSort.setText("Cao den thap");
        }
        String txt = "";
        for(SinhVien i:ds){
            txt+= i.getName()+"--"+i.getAge()+"--"+i.getMark()+"\n";
        }
        //txtRs.setText(txt);
    }

    public void update(){
        SinhVien s = txtRs.getSelectionModel().getSelectedItem();
        txtName.setText(s.getName());
        txtAge.setText(s.getAge().toString());
        txtMark.setText(s.getMark().toString());
        editSinhVien = s;
    }
    public  void trolai() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menuHome.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }
}