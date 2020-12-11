import com.diogonunes.jcolor.Attribute;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class Juego {
    public static Personaje personaje;
    public static Escenario escenario;





    public static void main(String[] args) throws IOException, InterruptedException {

        /*
        ArrayList<String> frases=new ArrayList<String>();
        frases.add("Buen Dia no?                                                        ");
        frases.add("Esto va funcionar???                                                ");
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
