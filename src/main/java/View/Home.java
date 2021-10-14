package View;

import DynamicLayout.DynamicLayout;
import Listeners.OuvinteHomePage;
import Listeners.OuvinteNavBar;
import View.Components.ButtonComponent;

import javax.swing.*;
import java.awt.*;

public class Home {
    private final JFrame JANELA;
    private JLabel msg;
    private JLabel copy;

    private static Home instance;

    public static Home getInstance(){
        if(instance==null){
            instance = new Home();
        }
        return instance;
    }
    private Home(){
        JANELA = new JFrame();
        this.configuracaoHome();
        this.addLabel();
        this.addButtons();
        this.addNavBar();
        JANELA.setVisible(true);
    }
    private void configuracaoHome(){
        Container containerOfFrame = JANELA.getContentPane();
        containerOfFrame.setBackground(new Color(144, 248, 210));
        JANELA.setSize(620,400);
        JANELA.setResizable(true);
        JANELA.setLocationRelativeTo(null);
        JANELA.setLayout(new DynamicLayout(620,400));
        JANELA.setMinimumSize(new Dimension(600,400));
        JANELA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JANELA.setTitle("Gerar códigos");
        JANELA.setIconImage(
                Toolkit.getDefaultToolkit().getImage(getClass().getResource("/splash.png"))
        );

    }
    private void addLabel(){
        msg = new JLabel("O código aparecerá aqui", JLabel.CENTER);

        msg.setFont(usaFont(26));
        msg.setBounds(0,100,410,100);
        msg.setForeground(Color.black);
        JANELA.add(msg);
    }
    private void addButtons(){
        OuvinteHomePage ouvinte = new OuvinteHomePage(this);

        JLabel gerar = new ButtonComponent("Gerar código",30,"#000000");
        gerar.setFont(usaFont(27));
        gerar.setBounds(50,300,527,70);
        gerar.addMouseListener(ouvinte);
        gerar.setIcon(new ImageIcon(this.getClass().getResource("/pen.png")));
        gerar.setBackground(new Color(51, 153, 255));
        gerar.setForeground(Color.black);


        copy = new ButtonComponent("Copiar e enviar",30,"#000000");
        copy.setFont(this.usaFont(18));
        copy.setBounds(410,128,200,50);
        copy.addMouseListener(ouvinte);
        copy.setIcon(new ImageIcon(this.getClass().getResource("/copy.png")));
        copy.setBackground(new Color(51, 153, 255));
        copy.setForeground(Color.black);

        JANELA.add(copy);
        JANELA.add(gerar);
    }


    private Font usaFont(int size){
        Font font = new Font("Courie New",Font.ITALIC,size);
        return font;

    }

    private void addNavBar(){
        JLabel gerador = new JLabel("Gerar Códigos",JLabel.CENTER);
        JLabel deleteCode = new JLabel("Deletar Código",JLabel.CENTER);

        OuvinteNavBar ouvinte = new OuvinteNavBar(JANELA);

        gerador.setOpaque(true);
        gerador.setBackground(new Color(51, 153, 255));
        gerador.setFont(usaFont(20));
        gerador.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
        gerador.addMouseListener(ouvinte);
        gerador.setBounds(0,0,315,40);
        gerador.setForeground(Color.black);

        deleteCode.setOpaque(true);
        deleteCode.setBackground(new Color(126, 185, 246));
        deleteCode.setFont(usaFont(20));
        deleteCode.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
        deleteCode.addMouseListener(ouvinte);
        deleteCode.setBounds(315,0,315,40);
        deleteCode.setForeground(Color.black);
        JANELA.add(gerador);
        JANELA.add(deleteCode);
    }

    public JLabel getLabel(){
        return msg;
    }

    public JFrame getJanela(){
        return JANELA;
    }

    public JLabel getButtonCopy() {
        return copy;
    }
}
