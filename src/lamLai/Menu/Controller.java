package lamLai.Menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lamLai.Main;

public class Controller {
    public void Danhsach() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../danhsachHS/Lamlai_Danhsasch.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }
    public void Them() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../themSV/Lamlai_ThemSV.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }
}
