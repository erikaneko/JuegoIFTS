package Motor;

import Historia.Escenario;
import Historia.Objeto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class File_Json {

    public static JSONObject File(String file) {
        JSONParser jsonParser = new JSONParser();
        JSONObject obj=null;
        try {
            FileReader reader = new FileReader(file);
            obj = (JSONObject) jsonParser.parse(reader);
        } catch (ParseException e) {
            System.err.println("Esta dañado el json");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("No se encontro el json");
            System.exit(0);
        }
        return obj;
    }

    public static Escenario getEscenario(JSONObject json,int index){
        JSONArray escenarios= (JSONArray) json.get("Escenario");
        return Escenario.jsonParse((JSONObject) escenarios.get(index));
    }

    public static Escenario getEscenario(JSONObject json,String nombre){
        JSONArray escenarios= (JSONArray) json.get("Escenario");
        for(Object escenario:escenarios){
            if(((JSONObject) escenario).get("Nombre")==nombre)
                return Escenario.jsonParse((JSONObject) escenario);
        }
        return null;
    }

    public static Objeto getObjeto(JSONObject json, int index){
        JSONArray objeto= (JSONArray) json.get("Objeto");
        return Objeto.jsonParse((JSONObject) objeto.get(index));
    }

    public static Map<String, Objeto> getObjetoAll(JSONObject json){
        JSONArray objeto= (JSONArray) json.get("Objeto");
        return Objeto.jsonParse(objeto);
    }


}
