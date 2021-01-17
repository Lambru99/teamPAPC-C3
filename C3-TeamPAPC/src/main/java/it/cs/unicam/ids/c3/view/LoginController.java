package it.cs.unicam.ids.c3.view;


import it.cs.unicam.ids.c3.controller.MyClienteControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/login.fxml")
public class LoginController {
    @FXML
    private Button login;
    @FXML
    private Button singin;
    @FXML
    private Button cliente;
    @FXML
    private Button commerciante;
    @FXML
    private Button corriere;
    @FXML
    private TextArea typelogin;
    @Autowired
    private MyClienteControllerInterface myClienteControllerInterface;

    public void email() {
    }

    public void password() {
    }

    public void login() {
    }

    public void singin() {
        //prova di un metodo a caso
        this.myClienteControllerInterface.addCliente("marco","draghi","abc","pass");
    }

    public void commerciante() {
    }

    public String cliente() {
        //questo metodo da errore, non so perché, meglio fare con frontend o cambiare strada, così è inaccettabile4
        String nome = this.myClienteControllerInterface.getClienteById(1).getNome();
        return nome;
    }

    public void corriere() {
    }
}
