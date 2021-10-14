package Listeners;

import Controller.ControllerNavBar;
import View.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteNavBar implements MouseListener {

    private JFrame frame;
    private ControllerNavBar controller;

    public OuvinteNavBar(JFrame frame){
        this.frame=frame;
        this.controller = ControllerNavBar.getInstance(frame);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        String titleOfFrame = frame.getTitle();
        JLabel button = (JLabel)mouseEvent.getSource();
        controller.navegation(titleOfFrame, button.getText());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel btn = (JLabel) e.getSource();
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel btn = (JLabel) e.getSource();
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

}
