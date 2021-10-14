package View;

import DynamicLayout.DynamicLayout;
import Listeners.OuvinteDeletePage;
import Listeners.OuvinteNavBar;
import View.Components.ButtonComponent;
import View.Components.JTextFieldComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DeleteCode {
    private final JFrame JANELA;
    private JTextField input;
    private JLabel deletar;


    private static DeleteCode instance;

    public static DeleteCode getInstance(){
        if(instance==null){
            instance = new DeleteCode();
        }
        return instance;
    }

    private DeleteCode(){
        JANELA = new JFrame();
        this.configuracaoHome();
        this.addLabel();
        this.addInput();
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
        JANELA.setTitle("Deletar códigos");
        JANELA.setIconImage(
                Toolkit.getDefaultToolkit().getImage(getClass().getResource("/splash.png"))
        );

    }
    private void addLabel(){
        JLabel msg = new JLabel("Digite ou cole o código abaixo", JLabel.CENTER);
        msg.setFont(usaFont(26));
        msg.setBounds(57,60,510,60);
        msg.setForeground(Color.black);

        JANELA.add(msg);
    }
    private void addInput(){
        input = new JTextFieldComponent(30);

        input.setHorizontalAlignment(JTextField.CENTER);
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

                if(input.getText().length() >= 6){
                    keyEvent.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        input.setFont(usaFont(26));
        input.setBounds(57,130,510,70);
        input.setFont(usaFont(23));
        input.setBackground(Color.white);
        input.setForeground(Color.black);
        JANELA.add(input);
    }
    private void addButtons(){
        OuvinteDeletePage ouvinteDeletePage = new OuvinteDeletePage(this);

        JLabel colar = new ButtonComponent("Colar código", 30, "#000000");

        colar.setFont(usaFont(20));
        colar.setBounds(237, 200, 170, 50);
        colar.setForeground(Color.black);
        colar.setIcon(new ImageIcon(this.getClass().getResource("/copy.png")));
        colar.setBackground(new Color(51, 153, 255));
        colar.addMouseListener(ouvinteDeletePage);


        deletar = new ButtonComponent(" Deletar",30,"#000000");
        deletar.setFont(usaFont(27));
        deletar.setBounds(50,300,527,70);
        deletar.setIcon(new ImageIcon(this.getClass().getResource("/trash.png")));
        deletar.setBackground(new Color(255, 51, 51));
        deletar.setForeground(Color.black);
        deletar.addMouseListener(ouvinteDeletePage);

        JANELA.add(deletar);
        JANELA.add(colar);
    }


    private Font usaFont(int size){

        return new Font("Courie New",Font.ITALIC,size);

    }

    private void addNavBar(){
        JLabel gerador = new JLabel("Gerar Códigos",JLabel.CENTER);
        JLabel deleteCode = new JLabel("Deletar Código",JLabel.CENTER);

        OuvinteNavBar ouvinte = new OuvinteNavBar(JANELA);

        gerador.setOpaque(true);
        gerador.setBackground(new Color( 126, 185, 246));
        gerador.setFont(usaFont(20));
        gerador.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
        gerador.addMouseListener(ouvinte);
        gerador.setBounds(0,0,315,40);
        gerador.setForeground(Color.black);

        deleteCode.setOpaque(true);
        deleteCode.setBackground(new Color(51, 153, 255));
        deleteCode.setFont(usaFont(20));
        deleteCode.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
        deleteCode.addMouseListener(ouvinte);
        deleteCode.setBounds(315,0,315,40);
        deleteCode.setForeground(Color.black);
        JANELA.add(gerador);
        JANELA.add(deleteCode);
    }

    public JTextField getInput(){
        return input;
    }

    public JFrame getJanela(){
        return JANELA;
    }

    public JLabel getGerarButton(){
        return this.deletar;
    }
}
