package Historia;

import Motor.Comandos;
import Motor.Consola;
import Motor.Juego;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class Objeto implements Consola {

    private String nombre;
    private String[] descripcion;
    int descripcion_index;
    private String[] accion;
    private Objeto dar;
    private Objeto activacion;

    public Objeto(){}

    public Objeto(String nombre, String[] descripcion, String[] accion) {
        new Objeto(nombre,descripcion,accion,null);
    }

    public Objeto(String nombre, String[] descripcion, String[] accion, Objeto dar) {
        new Objeto(nombre,descripcion,accion,dar,null);
    }

    public Objeto(String nombre, String[] descripcion, String[] accion, Objeto dar, Objeto activacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.accion = accion;
        this.dar = dar;
        this.activacion = activacion;
        this.descripcion_index=0;
    }



    public String getNombre() {
        return nombre;
    }

    public String[] getDescripcion() {
        return descripcion;
    }

    public String[] getAccion() {
        return accion;
    }

    public Objeto getDar() {
        return dar;
    }

    public Objeto getActivacion() {
        return activacion;
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

    private boolean isHasDar(){
        if(this.dar!=null)
            return true;
        else
            return false;
    }

    private boolean isHasActivacion(){
        if(this.activacion!=null)
            return true;
        else
            return false;
    }


    @Override
    public String investigar(Juego juego) {
        if(this.isHasActivacion())
            if(juego.getComandos().comando_Interno(new String[]{"isObjeto_Mochila ",this.dar.getNombre()},juego)>1)

        else if(this.isHasDar())
            juego.getComandos().comando_Interno(new String[]{"addObjeto_Mochila ",this.dar.getNombre()},juego);
        return this.descripcion[this.descripcion_index];
    }

    @Override
    public String mostrar(Juego juego) {
        return null;
    }

    public static Map<String,Objeto> jsonParse(JSONArray objeto) {
        Map<String,Objeto> objetos=new HashMap<String,Objeto>();
        for(int i=0;i<objeto.size();i++) {
            Objeto obj=Objeto.jsonParse((JSONObject)objeto.get(i));
            objetos.put(obj.getNombre(),obj);
        }
        return objetos;
    }

    public static Objeto jsonParse(JSONObject objeto) {
        if(objeto.containsKey("Accion"))
            return new Objeto((String) objeto.get("Nombre"),(String[]) objeto.get("Descripcion"),(String[]) objeto.get("Accion"));
        else
            return new Objeto((String) objeto.get("Nombre"),(String[]) objeto.get("Descripcion"),null);
    }
}
