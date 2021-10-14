package Util;

import Variaveis.Variaveis;
import View.DeleteCode;
import View.Home;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.swing.*;

public class RequisicoesAPI {


    private static void addLoadInButton(JLabel button, JFrame janela, String load){
        button.setText("");
        button.setIcon(new ImageIcon(RequisicoesAPI.class.getResource(load)));
        janela.repaint();
        janela.validate();


    }

    private static void voltaJButtonOriginal(JLabel button, JFrame janela, String text, String img){
        button.setText(text);
        button.setIcon(new ImageIcon(RequisicoesAPI.class.getResource(img)));
        janela.repaint();
        janela.validate();
    }

    public static void enviar(String codigo, Home janela){
        Thread thread = new Thread(()->{
            HttpClient httpClient= HttpClientBuilder.create().build();
            try{
                HttpPost request = new HttpPost(Variaveis.CAMINHO_API); // veja em ./src/Variaveis/ExemploVariaveis
                StringEntity params =new StringEntity("{\"codigo\":\""+codigo+"\",\"key\":\""+Variaveis.KEY+"\"} ");// veja em ./src/Variaveis/ExemploVariaveis
                request.setEntity(params);
                request.addHeader("content-type", "application/json");
                HttpResponse response = httpClient.execute(request);
                int status  = response.getStatusLine().getStatusCode();

                if(status != 201){
                    JOptionPane.showMessageDialog(janela.getJanela(),"O código não foi enviado");

                }
                voltaJButtonOriginal(
                        janela.getButtonCopy(),
                        janela.getJanela(),
                        "Copiar e enviar",
                        "/copy.png");
                JOptionPane.showMessageDialog(janela.getJanela(),"Código copiado e enviado");
            }catch (Exception e){
                JOptionPane.showMessageDialog(janela.getJanela(), "Houve um problema");
            }
        });
        addLoadInButton(janela.getButtonCopy(), janela.getJanela(),"/load2.gif");
        thread.start();
    }

    public static void deletar(String codigo, DeleteCode janela){
        Thread thread = new Thread(()->{
            HttpClient httpClient= HttpClientBuilder.create().build();
            try{
                HttpDelete request = new HttpDelete(Variaveis.CAMINHO_API+"?codigo="+codigo+"&key="+Variaveis.KEY);
                HttpResponse response = httpClient.execute(request);
                int status  = response.getStatusLine().getStatusCode();
                voltaJButtonOriginal(
                        janela.getGerarButton(),
                        janela.getJanela(),
                        " Deletar",
                        "/trash.png");
                tratamentoDeRespostaDelete(janela.getJanela(), status);
            }catch (Exception e){
                JOptionPane.showMessageDialog(janela.getJanela(), "Houve um problema");
            }
        });
        addLoadInButton(janela.getGerarButton(), janela.getJanela(),"/loadDelete.gif");
        thread.start();
    }
    private static void tratamentoDeRespostaDelete(JFrame janela, int status){
        if(status == 200){
            JOptionPane.showMessageDialog(janela, "Código deletado com sucesso");
        }else if(status == 404){
            JOptionPane.showMessageDialog(janela, "O código não existe ou ja foi deletado");
        }

    }
}
