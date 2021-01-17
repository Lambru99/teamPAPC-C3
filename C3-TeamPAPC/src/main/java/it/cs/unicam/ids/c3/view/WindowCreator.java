package it.cs.unicam.ids.c3.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class WindowCreator {
    public WindowCreator() {
    }

    public void CreateWindow(ConfigurableApplicationContext applicationContext, Stage stage) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        stage.setTitle("C3");
//        Image ico = new Image("");
//        stage.getIcons().add(ico);
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    /*public static void CreateWindow(String x) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowCreator.class.getResource("/"+x+".fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("C3");
//        Image ico = new Image("");
//       stage.getIcons().add(ico);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }*/
}