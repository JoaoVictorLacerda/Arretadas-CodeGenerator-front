package Controller;
import Util.GeradorDeCodigo;
import Util.RequisicoesAPI;
import View.Home;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class ControllerGerador {
    private final Clipboard CLIPBOARD = Toolkit.getDefaultToolkit().getSystemClipboard();
    private String codigo = "";
    private Home janela;

    public ControllerGerador(Home janela) {
        this.janela = janela;
    }


    public void copyToClipBoard(String cod){
        if(!cod.equals("O código aparecerá aqui")){
            StringSelection selection = new StringSelection(cod);
            CLIPBOARD.setContents(selection, null);
            if(!codigo.equals(cod)){
                RequisicoesAPI.enviar(cod, janela);
                codigo = cod;
            }else{
                JOptionPane.showMessageDialog(janela.getJanela(),"Código copiado com sucesso");
            }

        }
    }

    public void atualizaJFrame(JLabel label){
        label.setText(GeradorDeCodigo.gerarCodigo());
        janela.getJanela().repaint();
        janela.getJanela().validate();

    }
}
