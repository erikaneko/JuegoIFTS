import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

import javax.swing.JColorChooser;
import static com.diogonunes.jcolor.Ansi.colorize;
import com.diogonunes.jcolor.Attribute;

public class ProgressBar{
    int porcent;
    char count;
    char uncount;
    String text;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    int size;

    public int getPorcent() {
        return porcent;
    }

    public void setPorcent(int porcent) {
        this.porcent = porcent;
    }

    public char getCount() {
        return count;
    }

    public void setCount(char count) {
        this.count = count;
    }

    public char getUncount() {
        return uncount;
    }

    public void setUncount(char uncount) {
        this.uncount = uncount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char[] getTermination() {
        return termination;
    }

    public void setTermination(char[] termination) {
        this.termination = termination;
    }

    char[] termination;
    

    public ProgressBar(){
        this.porcent=0;
        this.count='#';
        this.uncount=' ';
        this.text="Loading ";
        this.termination=new char[]{'[',']'};
        this.size=5;
    }

    public ProgressBar(String text,Attribute textColor,Attribute backcolor,char count,char uncount,char[] termination,int size){
        this.porcent=0;
        this.count=count;
        this.uncount=uncount;
        this.text=text;
        this.termination=termination;
        this.size=size;
    }

    public ProgressBar(String text,Attribute textColor,Attribute backcolor){
        this(text,textColor,backcolor,'#',' ', new char[]{'[', ']'},5);
    }

    public ProgressBar(String text){
        this(text,WHITE_TEXT(),BLACK_BACK());
    }

    public String show(){
        String progres=text+" ";
        if(termination!=null)
            progres=progres+termination[0];
        for(int i=1;i<=size;i++){
            if(porcent>=(100/size)*i)
                progres=progres+count;
            else
                progres=progres+uncount;

        }
        if (termination[1] != ' ') {
            progres = progres + termination[1];
        }
        return progres;
    }

    public String show(Attribute textColor,Attribute backColor){
        return colorize(this.show(),textColor,backColor);
    }

    public String show(int textColor,int backColor){
        return this.show(TEXT_COLOR(textColor),BACK_COLOR(backColor));
    }

    public String showporcent(){
        return this.show()+" "+porcent+'%';
    }








}