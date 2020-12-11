
import java.util.ArrayList;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

import com.diogonunes.jcolor.Attribute;


public class Presentacion {

    Margen margen;
    String marco;
    Attribute marco_text;
    Attribute marco_back;
    Attribute space;
    Attribute text;
    Attribute back;

    public Margen getMargen() {
        return margen;
    }

    public String getMarco() {
        return marco;
    }
    public void setMarco(String marco) {
        this.marco = marco;
    }

    public Presentacion(){
        this.margen=new Margen();
        this.text=TEXT_COLOR(88);
        this.marco="@";
        this.marco_back=NONE();
        this.marco_text=TEXT_COLOR(88);
    }

    public ArrayList<String> show(String[] pres){
        int a=0;
        for(String line:pres){
            if(line.length()>a)
                a=line.length();
        }
        for (int i=0;i<pres.length;i++){
            if(pres[i].length()<a)
                pres[i]=addSpace(pres[i],a);
        }
        String space_rigth=addSpace(margen.derecha);
        String space_left=addSpace(margen.izquierda);
        String space_line=addSpace((""),a);
        ArrayList<String> _pres=new ArrayList<String>();
        _pres.add(addMarco("",a+2+margen.inferior+margen.derecha));
        for(int i=0;i<this.margen.superior;i++){
            _pres.add(marco+space_left+space_line+space_rigth+marco);
        }
        for (String line:pres){
            _pres.add(marco+space_left+line+space_rigth+marco);
        }
        for(int i=0;i<this.margen.inferior;i++){
            _pres.add(marco+space_left+space_line+space_rigth+marco);
        }
        _pres.add(addMarco("",a+2+margen.inferior+margen.derecha));
        return _pres;
    }

    public ArrayList<String> show(String[] pres,int init,int end){
        String marco=colorize(this.marco,marco_text,marco_back);
        int a=0;
        for(String line:pres){
            if(line.length()>a)
                a=line.length();
        }
        for (int i=0;i<pres.length;i++){
            if(pres[i].length()<a)
                pres[i]=addSpace(pres[i],a);
        }
        String space_rigth=addSpace(margen.derecha);
        String space_left=addSpace(margen.izquierda);
        String space_line=addSpace((""),a);
        ArrayList<String> _pres=new ArrayList<String>();
        _pres.add(colorize(addMarco("",a+2+margen.inferior+margen.derecha),marco_text,marco_back));
        for(int i=0;i<this.margen.superior;i++){
            _pres.add(marco+space_left+space_line+space_rigth+marco);
        }
        String[] pres2=change_Color(pres,init,end);
        for (String line:pres2){
            _pres.add(marco+space_left+line+space_rigth+marco);
        }
        for(int i=0;i<this.margen.inferior;i++){
            _pres.add(marco+space_left+space_line+space_rigth+marco);
        }
        _pres.add(_pres.get(0));
        return _pres;
    }




    public String[] change_Color(String[] _palabras,int ini,int end){
        String[] palabras=_palabras.clone();
        for(int i=0;i<palabras.length;i++){
            if(i>=ini-1 && i<=end-1)
                palabras[i]=colorize(palabras[i],text);
        }
        return palabras;
    }

    public ArrayList<String> show_MarcoColor(String[] pres){
        String aux=marco;
        marco=colorize(marco,text);
        return this.show(pres);
    }

    public String addSpace(String line,int length){
        int _length=line.length();
        for(int a=0;a<length-_length;a++)
            line=line+" ";
        return line;
    }

    public String addSpace(int length){
        return addSpace("",length);
    }

    public String addMarco(String line,int length){
        int _length=line.length();
        for(int a=0;a<length-_length;a++)
            line=line+this.marco;
        return line;
    }
}

class Margen{
    int superior;
    int inferior;
    int derecha;
    int izquierda;


    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    public int getInferior() {
        return inferior;
    }

    public void setInferior(int inferior) {
        this.inferior = inferior;
    }

    public int getDerecha() {
        return derecha;
    }

    public void setDerecha(int derecha) {
        this.derecha = derecha;
    }

    public int getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(int izquierda) {
        this.izquierda = izquierda;
    }

    public Margen(){
        this.derecha=2;
        this.inferior=2;
        this.izquierda=2;
        this.superior=2;
    }




    public Margen(int superior, int inferior, int derecha, int izquierda) {
        this.superior = superior;
        this.inferior = inferior;
        this.derecha = derecha;
        this.izquierda = izquierda;
    }

}