package it.cs.unicam.ids.c3.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class createWindow {

    public static void CreateWindow(String x) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(createWindow.class.getResource("/"+x+".fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("C3");
//        Image ico = new Image("");
//       stage.getIcons().add(ico);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }
}