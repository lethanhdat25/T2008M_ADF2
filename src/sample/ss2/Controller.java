package sample.ss2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
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

    ObservableList<SinhVien> ds = FXCollections.observableArrayList();
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
                SinhVien s = new SinhVien(n,a,m);
                ds.add(s);

                txtValidate.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtMark.setText("");
                txtRs.setItems(ds);
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
}