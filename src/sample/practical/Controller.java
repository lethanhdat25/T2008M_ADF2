package sample.practical;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField name;
    public TextField phone;
    public TextField search;
    public TableView<AdressBook> tbView;
    public TableColumn<AdressBook,String> tbName;
    public TableColumn<AdressBook,String> tbPhone;
    ObservableList<AdressBook> ds=FXCollections.observableArrayList();
    ObservableList<AdressBook> dsTim=FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbName.setCellValueFactory(new PropertyValueFactory<AdressBook,String>("name"));
        tbPhone.setCellValueFactory(new PropertyValueFactory<AdressBook,String>("phone"));
    }
    public void Them(){
        String n=name.getText();
        String p=phone.getText();
        if (!n.isEmpty()&&!p.isEmpty()){
            AdressBook aB=new AdressBook(n,p);
            ds.add(aB);
            tbView.setItems(ds);
        }
        name.setText("");
        phone.setText("");
    }
    public void Search(){
        String n=search.getText();
        dsTim.remove(0,dsTim.size());
        for (AdressBook ab:
             ds) {
            if (ab.getName().equals(n)){
                dsTim.add(ab);
            }
        }
        tbView.setItems(dsTim);
    }
    public void Exit(){
        Platform.exit();
    }
}
