import Controller.ControllerGerador;
import Util.GeradorDeCodigo;
import org.junit.Assert;
import org.junit.Test;

public class IsUniqueCodeTest {
    private long contador=0;



    @Test
    public void entryPoint(){
        combinacoes(10000, GeradorDeCodigo.gerarCodigo());
        combinacoes(10000,GeradorDeCodigo.gerarCodigo());
        combinacoes(10000,GeradorDeCodigo.gerarCodigo());
    }

    public void combinacoes(long repeticoes, String cod1){

        while(contador < repeticoes){
            String code2 = GeradorDeCodigo.gerarCodigo();
            System.out.println(cod1+" : "+code2);
            Assert.assertNotEquals(cod1, code2);

            contador ++;
        }
        System.out.println("passou : "+contador);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contador =0;
    }

    @Test()
    public void combinacoes(){

        while(contador < 1000000){
            String code1 = GeradorDeCodigo.gerarCodigo();
            String code2 = GeradorDeCodigo.gerarCodigo();
            System.out.println(code1+" : "+code2);
            Assert.assertNotEquals(code1, code2);

            contador ++;
        }
        System.out.println("passou : "+contador);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contador =0;

    }



}
