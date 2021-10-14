package Listeners;

import View.Home;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OuvinteSplash implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

        JFrame janela = (JFrame) e.getSource();
        Thread thread = new Thread(() ->{
            try {
                Thread.sleep(3000);
                janela.dispose();
                Home.getInstance();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        thread.start();

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
