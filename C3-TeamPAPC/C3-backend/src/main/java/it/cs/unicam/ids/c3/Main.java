package it.cs.unicam.ids.c3;


import it.cs.unicam.ids.c3.view.StartView;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //SpringApplication.run(Main.class,args);
        Application.launch(StartView.class,args);
    }
}
