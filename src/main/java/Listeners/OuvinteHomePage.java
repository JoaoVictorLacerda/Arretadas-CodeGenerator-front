package Listeners;

import Controller.ControllerGerador;
import View.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteHomePage implements MouseListener {
    private Home janela;
    private ControllerGerador controller;

    public OuvinteHomePage(Home janela) {
        this.janela = janela;
        controller = new ControllerGerador(janela);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel botao = (JLabel) e.getSource();
        JLabel cod = janela.getLabel();
        if(botao.getText().equals("Copiar e enviar")){
            controller.copyToClipBoard(cod.getText());
        }else if(!botao.getText().equals("")){
            controller.atualizaJFrame(janela.getLabel());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.mudaCorDoBotao((JLabel) e.getSource(), new Color(33, 128, 224));
        janela.getJanela().setCursor(Cursor.HAND_CURSOR);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.mudaCorDoBotao((JLabel) e.getSource(), new Color(51, 153, 255));
        janela.getJanela().setCursor(Cursor.DEFAULT_CURSOR);
    }

    private void mudaCorDoBotao(JLabel btn, Color cor){
        btn.setBackground(cor);
        janela.getJanela().repaint();
        janela.getJanela().validate();
    }
}
