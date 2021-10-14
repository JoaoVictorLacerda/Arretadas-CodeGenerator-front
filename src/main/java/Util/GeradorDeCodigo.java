package Util;
import java.util.Random;

public class GeradorDeCodigo {
    public static String gerarCodigo(){
        String[] alfabeto = {
                "a","b","c",
                "d","e","f",
                "g","h","i",
                "j","k","l",
                "m","n","o",
                "p","q","r",
                "s","t","u",
                "v","w","x",
                "y","z"
        };

        Random random = new Random();
        String result="";
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(alfabeto.length);
            int numero = random.nextInt(10);
            result += numero+alfabeto[index];
        }
        return result;
    }
}
