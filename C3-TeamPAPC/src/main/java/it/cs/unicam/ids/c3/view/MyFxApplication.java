package it.cs.unicam.ids.c3.view;


import it.cs.unicam.ids.c3.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


public class MyFxApplication extends Application {

    private WindowCreator windowCreator;
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
    public void start(Stage stage) {
        this.windowCreator = new WindowCreator();
        this.windowCreator.CreateWindow(this.applicationContext,stage);
    }

    /*@Override
    public void start(Stage stage) {
        FxWeaver fxWeaver =applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        stage.setTitle("C3");
//        Image ico = new Image("");
//        stage.getIcons().add(ico);
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }*/
}
