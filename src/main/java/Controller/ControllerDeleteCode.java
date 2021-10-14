package Controller;

import Util.RequisicoesAPI;
import View.DeleteCode;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;



public class ControllerDeleteCode {


    public void deletar(String codigo, DeleteCode janela){
        if(!codigo.equals("")){
            RequisicoesAPI.deletar(codigo, janela);

        }
    }
    public void colar(JTextField input){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        try {
            String cod = clipboard.getData(DataFlavor.stringFlavor).toString();
            input.setText(cod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
