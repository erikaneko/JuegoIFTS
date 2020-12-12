package Motor;

import Historia.Escenario;
import Historia.Personaje;
import com.diogonunes.jcolor.Attribute;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class Juego {
    Personaje personaje;
    Escenario escenario;
    String json_ubication;
    Comandos comandos;

    public Personaje getPersonaje() {
        return personaje;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public Comandos getComandos() {
        return comandos;
    }

    public Juego(){
        this.escenario=Escenario.actualEscenario();
        this.personaje=Personaje.CrearPersonaje();
        this.comandos=Comandos.obtenerTeclado();
        this.json_ubication="Little_HouseV01.txt";
    }

    public void cargarJuego(){
        JSONObject juego=File_Json.File(json_ubication);
        this.escenario=File_Json.getEscenario(juego,0);
    }

    public void iniciar(){
        this.escenario.show();
        while (true){
            this.comandos.comando_Teclado(this);
        }
    }

    public static void main(String[] args) {
        Juego juego=new Juego();
        juego.cargarJuego();
        juego.iniciar();




        /*
        ArrayList<String> frases=new ArrayList<String>();
        frases.add("Buen Dia no?                                                        ");
        frases.add("Esto va uncionar???                                                ");
        frases.add("Le recomiendo ir x un cafe puede tardar                             ");
        frases.add("Puede que esto sea innecesario me gusto mucho hacer perder su tiempo");
        frases.add("Espero que no se enoje con el programador                           ");

        Random r1 = new Random();
        int frase=0;
        for(int i=0;i<=100;i+=2) {
            System.out.print("\r");
            Thread.sleep(1000);
            //System.out.print("\033\143\r");
            //System.out.print("\033\143");
            ProgressBar progress=new ProgressBar();
            progress.setSize(20);
            progress.setPorcent(i);
            System.out.print(progress.showporcent());
            if(i%20==0)
                frase=r1.nextInt(5);
            if(i>5)
                System.out.print(" "+frases.get(frase));
        }*/
    }


}
