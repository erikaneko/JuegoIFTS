
import java.io.*;
import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

// Escribir las funciones con las consignas en cada funcion.
//
// Notas:
// - En browxy, todos los archivos que lean o escriban van en el directorio data
// - No se olviden de hacer close() de cada archivo que abran.

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        FileReader file=new FileReader("src/main/resources/titulo.txt");
        BufferedReader writter = new BufferedReader(file);
        String line=writter.readLine();
        ArrayList<String> files=new ArrayList<String>();
        while (line!=null){
            files.add(line);
            line=writter.readLine();
        }
        Presentacion menu=new Presentacion();
        file.close();
        String[] aux=files.toArray(new String[0]);
        /*ArrayList<String> file2=menu.show(aux);
        for(String txt:file2)
            System.out.println(txt);
        file2=menu.show_MarcoColor(aux);
        for(String txt:file2)
            System.out.println(txt);*/
        ArrayList<String[]> nombres=new ArrayList<String[]>();
        //menu.setMarco(colorize("@",TEXT_COLOR(88)));
        nombres.add(menu.show(aux).toArray(new String[0]));
        nombres.add(menu.show(aux,1,5).toArray(new String[0]));
        for(String txt:nombres.get(1))
            System.out.println(txt);
        nombres.add(menu.show(aux,6,10).toArray(new String[0]));
        for(String txt:nombres.get(2))
            System.out.println(txt);
        //ArrayList<String[]> titulos=new ArrayList<String[]>();
        /*for(String[] nombre:nombres){
            titulos.add(menu.show_MarcoColor(aux).toArray(new String[0]));
        }*/
        //String prueba=colorize("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", TEXT_COLOR(88));
        



        while (true){
            for (String[] titulo:nombres){
                Thread.sleep(40);
                System.out.print("\033\143\r");
                System.out.print("\033\143\r");
                for(String linea: titulo){
                    System.out.println(linea);
                }
            }
        }
    }

}
