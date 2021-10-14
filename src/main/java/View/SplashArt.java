package View;


import Listeners.OuvinteSplash;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SplashArt {
    private JFrame janela;
    public SplashArt(){
        janela = new JFrame();
        this.configuracaoSplash();
        this.addImg();
        janela.addWindowListener(new OuvinteSplash());
        janela.setVisible(true);
    }

    private void configuracaoSplash(){
        Container div = janela.getContentPane();
        div.setBackground(new Color(104, 214, 177));
        janela.setLayout(null);
        janela.setSize(500,300);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setUndecorated(true);
        janela.setIconImage(
                Toolkit.getDefaultToolkit().getImage(getClass().getResource("/splash.png"))
        );

    }
    private void addImg(){
        URL url = SplashArt.class.getResource("/splash.png");
        ImageIcon imagem = new ImageIcon(url);

        JLabel labelComImagem = new JLabel();
        labelComImagem.setBounds(125,40,250,220);

        imagem.setImage(imagem.getImage().getScaledInstance(
                labelComImagem.getWidth(),
                labelComImagem.getHeight(),
                1));

        labelComImagem.setIcon(imagem);

        janela.add(labelComImagem);
    }




}
