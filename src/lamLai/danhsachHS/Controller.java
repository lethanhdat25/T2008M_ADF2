package lamLai.danhsachHS;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lamLai.Main;
import lamLai.back.SinhVien;
import sample.manageStudent.model.Sinhvien_st;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtMark;
    public TableView<SinhVien> tbView;
    public TableColumn<SinhVien,String> TenSV;
    public TableColumn<SinhVien,Integer> TuoiSV;
    public TableColumn<SinhVien,Integer> DiemSV;
    public static Integer id=0;
    public static SinhVien edit;
    public ObservableList<SinhVien> ds=FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TenSV.setCellValueFactory(new PropertyValueFactory<SinhVien,String>("name"));
        TuoiSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("age"));
        DiemSV.setCellValueFactory(new PropertyValueFactory<SinhVien,Integer>("mark"));
        try {
            FileInputStream fis=new FileInputStream("danhsach.bin");
            DataInputStream dis=new DataInputStream(fis);
            int line=0;
            String txt= dis.readLine();
            String[] str=new String[4];
            while (txt!=null){
                str[line]=txt;
                line++;
                txt= dis.readLine();
                if (line>=4){
                    SinhVien sv=new SinhVien(str[0],Integer.parseInt(str[2]),Integer.parseInt(str[3]),Integer.parseInt(str[1]));
                    ds.add(sv);
                    line=0;
                }
            }
            tbView.setItems(ds);
        }catch (Exception e){

        }
    }
    public void submit(){
        String n=txtName.getText();
        Integer t=Integer.parseInt(txtAge.getText());
        Integer m=Integer.parseInt(txtMark.getText());
        if(n!=null){
            if (edit!=null) {
                edit.setName(n);
                edit.setAge(t);
                edit.setMark(m);
                for (SinhVien s :
                        ds) {
                    if (s.getId() == edit.getId()) {
                        s = edit;
                        break;
                    }
                }
                tbView.refresh();
            }
            else{
                try{
                    FileInputStream fis=new FileInputStream("danhsach.bin");
                    DataInputStream dis=new DataInputStream(fis);
                    ArrayList<String> arr=new ArrayList<>();
                    String txt=dis.readLine();
                    while(txt!=null){
                        arr.add(txt);
                        txt=dis.readLine();
                    }
                    arr.add(n);
                    arr.add(id.toString());
                    arr.add(t.toString());
                    arr.add(m.toString());
                    FileOutputStream fos=new FileOutputStream("danhsach.bin");
                    DataOutputStream dos=new DataOutputStream(fos);
                    for (String x:
                         arr) {
                        dos.writeBytes(x+"\n");

                    }

                }catch (Exception e){

                }

                id++;
                SinhVien sv=new SinhVien(n,t,m,id);
                ds.add(sv);
                tbView.setItems(ds);

            }
            edit=null;
            txtName.setText("");
            txtAge.setText("");
            txtMark.setText("");
        }

    }
    public void update(){
        SinhVien s=tbView.getSelectionModel().getSelectedItem();
        txtName.setText(s.getName());
        txtAge.setText(s.getAge().toString());
        txtMark.setText(s.getMark().toString());
        edit=s;
    }
    public void trolai() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Menu/Lamlai_Menu.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }
}
