


import View.SplashArt;


import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        try {

            new SplashArt();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um problema, entre em contato com o desenvolvedor");

        }
    }

}
