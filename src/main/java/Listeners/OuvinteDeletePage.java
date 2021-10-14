package Listeners;

import Controller.ControllerDeleteCode;
import View.DeleteCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteDeletePage implements MouseListener {

    private DeleteCode deleteCode;
    private ControllerDeleteCode controller;
    public OuvinteDeletePage(DeleteCode deleteCode){
        this.deleteCode = deleteCode;

         this.controller = new ControllerDeleteCode();
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JLabel btn = (JLabel)mouseEvent.getSource();
        if(btn.getText().equals(" Deletar")){
            controller.deletar(deleteCode.getInput().getText(),deleteCode);
        }else{
            controller.colar(deleteCode.getInput());
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        JLabel btn = (JLabel) mouseEvent.getSource();
        if(btn.getText().equals(" Deletar")){
            this.mudaCorBtn(btn, new Color(255,51,51));
        }else if(btn.getText().equals("Colar código")){
            this.mudaCorBtn(btn, new Color(33,128,224));
        }
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        JLabel btn = (JLabel) mouseEvent.getSource();
        if(btn.getText().equals(" Deletar")){
            this.mudaCorBtn(btn, new Color(255,51,51));
        }else if(btn.getText().equals("Colar código")){
            this.mudaCorBtn(btn, new Color(51, 153, 255));
        }
    }

    private void mudaCorBtn(JLabel btn, Color color){
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBackground(color);


    }
}
//cleyton.souza@ifpb.edu.br