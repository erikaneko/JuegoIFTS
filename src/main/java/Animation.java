import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animation {
    List<Frame> animation;

    public Animation(){
        this.animation=new ArrayList<Frame>();
    }

    public Animation(String[][] Frames,int[] time,int[] action){
        this.animation=new ArrayList<Frame>();
        if(Frames.length==time.length && Frames.length==action.length){
            for(int i=0;i<Frames.length;i++){
                animation.add(new Frame(Frames[i],time[i],action[i]));
            }
        }        
    }

    public Animation(String[][] Frames){
        this.animation=new ArrayList<Frame>();
        for(String[] frame: Frames){
            animation.add(new Frame(frame,30,0));
        }
    }

    public void Show(){
        for(Frame frame:animation) {
            for(String line:frame.frame){
                System.out.println(line);
            }
            makeAction(animation.indexOf(frame));
        }
    }


    public void makeAction(int index) {
        try {
            switch (this.animation.get(index).action) {
                case 0:
                    Thread.sleep(this.animation.get(index).time);
                    break;
                case 1:
                    Thread.sleep(this.animation.get(index).time);
                    System.console().readLine();
                    break;
                case 2:
                    Thread.sleep(this.animation.get(index).time);
                    System.out.print("\033\143\r");
                    break;
                case 3:
                    Thread.sleep(this.animation.get(index).time);
                    System.console().readLine();
                    System.out.print("\033\143\r");
                    break;
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("posicion "+ index +" info objeto"+this.animation.get(index).toString());
        }
    }

}

class Frame{
    List<String> frame;
    int time;
    int action;

    public Frame(){
        this.frame=new ArrayList<String>();
    }

    public Frame(String[] frame,int time,int action){
        this.frame=new ArrayList<String>();
        this.frame= Arrays.asList(frame);
        this.time=time;
        this.action=action;
    }

}
