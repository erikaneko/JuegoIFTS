package Historia;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Escenario{
    String[] descripcion;
    int descripcion_index;
    Map<String,Escenario> escenario_proximo;
    static Escenario escenario;
    Map<String,Objeto> objetos;

    public String[] getDescripcion() {
        return descripcion;
    }

    public Map<String, Escenario> getEscenario_proximo() {
        return escenario_proximo;
    }

    public Map<String, Objeto> getObjetos() {
        return objetos;
    }

    Escenario(){
        new Escenario(null,new HashMap<String, Escenario>(),new HashMap<String, Objeto>());
    }

    Escenario(String[] descripcion){
        new Escenario(descripcion,new HashMap<String, Escenario>(),new HashMap<String, Objeto>());
    }

    Escenario(String[] descripcion, HashMap<String, Escenario> escenario_proximo, HashMap<String, Objeto> objetos) {
        this.descripcion = descripcion;
        this.escenario_proximo = escenario_proximo;
        this.objetos = objetos;
        this.descripcion_index=0;
    }

    public static Escenario actualEscenario(){
        if(escenario==null)
            new Escenario();
        return escenario;
    }

    public void moverEscenario(String mapa){
        if(escenario_proximo.containsKey(mapa))
            escenario=escenario_proximo.get(mapa);
    }

    public String show(){
        return descripcion[descripcion_index];
    }

    public void setDescripcion(String descripcion){
        this.descripcion[descripcion_index]=descripcion;
    }

    public void setDescripcion_index(int descripcion_index) {
        this.descripcion_index = descripcion_index;
    }

    public void nextDescripcion(){
        this.descripcion_index++;
    }

    public static Escenario jsonParse(JSONObject obj){
        if(obj.containsKey("objeto"))
            return new Escenario((String[]) obj.get("Descripcion"),new HashMap<String, Escenario>(), (HashMap<String, Objeto>) Objeto.jsonParse((JSONArray) obj.get("objeto")));
        else
            return new Escenario((String[])obj.get("Descripcion"));
    }
}