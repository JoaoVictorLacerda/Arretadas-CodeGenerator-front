package Controller;

import View.DeleteCode;
import View.Home;

import javax.swing.*;

public class ControllerNavBar {

    private static ControllerNavBar instance;

    private ControllerNavBar(){}
    private static JFrame frame;

    public static ControllerNavBar getInstance(JFrame frame){
        if(instance == null){
            instance = new ControllerNavBar();
        }
        ControllerNavBar.frame = frame;
        return instance;
    }

    public void navegation(String page, String button){
        if(page.equals("Gerar códigos") && button.equals("Deletar Código")){
            Home home = Home.getInstance();
            home.getJanela().setVisible(false);

            DeleteCode deleteCode = DeleteCode.getInstance();
            deleteCode.getJanela().setVisible(true);

        }else if(page.equals("Deletar códigos") && button.equals("Gerar Códigos")){
            DeleteCode deleteCode = DeleteCode.getInstance();
            deleteCode.getJanela().setVisible(false);

            Home home = Home.getInstance();
            home.getJanela().setVisible(true);
        }
    }
}
