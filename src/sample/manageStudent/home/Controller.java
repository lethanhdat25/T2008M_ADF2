package sample.manageStudent.home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.manageStudent.Main;

public class Controller  {
    public void Danhsach() throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("../danhsach/danhsach.fxml"));
            Main.mainStage.setTitle("Hello World");
            Main.mainStage.setScene(new Scene(root, 700, 700));
            Main.mainStage.show();
    }
    public void ThemSV() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../them/themHS.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }
}
