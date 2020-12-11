import java.util.HashMap;
import java.util.Map;

public class Personaje {
    String nombre;
    String descripcion;
    Map<String,Objeto> mochila;
    Map<String,Integer> salasinvestigadas;
    static Personaje yo;

    Personaje(){
        this.descripcion="";
        mochila=new HashMap<String,Objeto>();
        salasinvestigadas=new HashMap<String,Integer>();
    }

    public static Personaje CrearPersonaje(){
        if(yo == null)
            yo=new Personaje();
        return yo;
    }

    public String Descripcion(){
        return descripcion;
    }

    public void RemoverObjeto(Objeto objeto){
        mochila.put(objeto.getNombre(),objeto);
    }

    public void AgregarObjeto(Objeto objeto){
        mochila.remove(objeto);
    }



    /*
        public void LoadPersonaje(String descripcion,Map<String,Objeto> mochila,Map<String,Integer> salasinvestigadas){
            this.description=descripcion;
            this.mochila=mochila;
            this.salasinvestigas=salasinvestigadas;
        }
        
        public void LoadPersonaje(Map<String,Object> Personaje){
            Personaje.getvalues
        }
    
    */
}
