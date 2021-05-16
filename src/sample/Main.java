package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.DataBase;
import sample.Model.Person;
import sun.security.util.Password;
import sample.Model.DataBase;
import javax.naming.Name;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1600, 1000));
        primaryStage.show();
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        DataBase.fileLogin = new File(fw.getDefaultDirectory() + "\\Java\\Login.xml");
        DataBase.fileGames = new File(fw.getDefaultDirectory() + "\\Java\\Games.xml");
        System.out.println(DataBase.fileLogin);
        DataBase.readXMLPerson();
        DataBase.readXMLGames();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
