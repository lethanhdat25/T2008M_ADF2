package sample.tapLam;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import sample.Main;

public class Controller_ThemHS {
    public  TextField themTenHS;
    public TextField themTuoiHS;
    public TextField themDiemHS;
    public String ten;
    public Integer tuoi;
    public Integer diem;
    public  static Integer id=0;
    static ObservableList<SinhVien> dsThem= FXCollections.observableArrayList();

    public void ThemHS() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("tapLam1.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
        try {
            ten = themTenHS.getText();
            tuoi = Integer.parseInt(themTuoiHS.getText());
            diem = Integer.parseInt(themDiemHS.getText());
            if (!ten.isEmpty()) {
                SinhVien sv = new SinhVien(id, ten, tuoi, diem);
                dsThem.add(sv);
            }

        }catch (Exception e){

        }
    }
    public  void trolai() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menuHome.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }
}
