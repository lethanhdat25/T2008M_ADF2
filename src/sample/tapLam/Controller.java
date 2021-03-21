package sample.tapLam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtMark;
    public String txt="";
    public TableView<SinhVien> txtView;
    public Button button;
    public TableColumn<SinhVien,String> columnName;
    public TableColumn<SinhVien,Integer> columnAge;
    public TableColumn<SinhVien,Integer> columnMark;
    ObservableList<SinhVien> ds= FXCollections.observableArrayList();
    boolean run=true;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnName.setCellValueFactory(new PropertyValueFactory<SinhVien,String>("name"));
        columnAge.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("age"));
        columnMark.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("mark"));
    }
    public void inra(){
        try {
            String n=txtName.getText();
            int a=Integer.parseInt(txtAge.getText());
            int m=Integer.parseInt(txtMark.getText());
            if (!n.isEmpty()){
                SinhVien sv=new SinhVien(n,a,m);
                ds.add(sv);
                txtName.setText("");
                txtAge.setText("");
                txtMark.setText("");
                txtView.setItems(ds);
            }else{
                txtName.setText("Moi ban nhap ten");
            }
        }catch (Exception e){
            txtName.setPromptText("Vui lòng nhập tên: ");
            txtAge.setPromptText("Vui lòng nhập tuoi: ");
            txtMark.setPromptText("Vui lòng nhập diem: ");
        }
    }
    public void sapXep(){
        if (run){
            Collections.sort(ds, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o2.getMark()-o1.getMark();
                }
            });
            button.setText("thap den cao");

            run=false;
        }else{
            Collections.sort(ds, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getMark()-o2.getMark();
                }
            });
            button.setText("Cao den thap");
            run=true;
        }
    }


}
