package sample.tapLam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Main;


public class Controller_Menu {

    public void viewDS() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("tapLam1.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }
    public void themDS() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ThemHS.fxml"));
        Main.mainStage.setTitle("Hello World");
        Main.mainStage.setScene(new Scene(root, 700, 700));
        Main.mainStage.show();
    }

}
