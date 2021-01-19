package it.cs.unicam.ids.c3.Cliente;

import java.util.Scanner;

public class ClienteConsoleView implements ClienteConsoleViewInterface{
    private ClienteControllerInterface clienteController;
    private Scanner input;
    private ClienteInterface clienteCorrente;


    private void mainMenuView(){
        System.out.println("1 -> crea un ordine");
    }

    private void mainMenu(){
        int i = input.nextInt();
        switch (i){
            case 1: clienteController.iniziaOrdine();
        }
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}
