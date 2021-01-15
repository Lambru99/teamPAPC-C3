package it.cs.unicam.ids.c3.view;


import it.cs.unicam.ids.c3.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


public class StartView extends Application {


    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder().sources(Main.class).run(args);
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(createWindow.class.getResource("/login.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("C3");
//        Image ico = new Image("");
//        stage.getIcons().add(ico);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }
}
