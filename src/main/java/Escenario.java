import sun.security.krb5.internal.crypto.Des;

import java.util.HashMap;
import java.util.Map;

public class Escenario{
    String Descripcion;
    Map<String,Escenario> Escenario_proximo;
    Escenario escenario;

    Escenario(){
        Descripcion="";
        Escenario_proximo=new HashMap<String, Escenario>();
    }

    public Escenario actualEscenario(){
        if(escenario==null)
            new Escenario();
        return escenario;
    }

    public void moverEscenario(String mapa){
        if(Escenario_proximo.containsKey(mapa))
            escenario= Escenario_proximo.get(mapa);
    }

    public String show(){
        return Descripcion;
    }

    public void setDescripcion(String descripcion){
        this.Descripcion=descripcion;
    }


}