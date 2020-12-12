package Motor;

import Historia.Objeto;

import java.util.Scanner;

public class Comandos {

    static Comandos comando;
    Scanner entrada;

    Comandos (){
        entrada=new Scanner(System.in);
    }

    public static Comandos obtenerTeclado(){
        if(comando==null)
            comando=new Comandos();
        return comando;
    }

    public void pausa(){
        this.entrada.next();
    }

    public void pausa(int mili){
        try {
            Thread.sleep(mili);
            this.pausa();
        }
        catch (Exception e){
            System.err.println("Error al pausar el juego");
        }
    }

    public void comando_Teclado(Juego juego){
        String[] comando_teclado={"Ayuda","Investigar","Personaje","Mochila","Volver","Salir"};
        String[] palabra=this.entrada.next().split(" ");
        switch (palabra[0]){
            case comando_teclado[0]:
                System.out.println("Lista de Comandos: ");
                for(String p:comando_teclado){
                    System.out.print(p);
                }
                break;
            case comando_teclado[1]:
                if(palabra[1]==null)
                    this.comando_Error();
                else
                    if(juego.getEscenario().getObjetos().containsKey(palabra[2]))
                        Objeto obj=juego.getEscenario().getObjetos().get(palabra[2]);

                break;
            case comando_teclado[2]:
                break;
            case comando_teclado[3]:
                break;
            case comando_teclado[4]:
                break;
            case comando_teclado[5]:
                break;
            default:
                System.err.println("ERROR -"+"la palabra "+palabra+" no existe en el juego"  +" -ERROR");
        }
    }
    public void comando_Error(){
        System.err.println("ERROR -"+" no existe en el juego"  +" -ERROR");
    }

    public int comando_Interno(String[] args,Juego juego){
        switch (args[0]){
            case "Animacion":
                break;
            case "dialogo":
                break;
            case "addEscenario":
                juego.getEscenario().getEscenario_proximo().put(args[1],);
                break;
            case "addObjeto_Mochila":

                break;
            case "removeObjeto_Mochila":
                break;
            case "isObjeto_Mochila":
                break;
            case "isObjeto_Escenario":
                break;
            default:
                System.err.println("Error Error dentro del juego arreglar json ese comando no existe Error Error");
        }
    }

}