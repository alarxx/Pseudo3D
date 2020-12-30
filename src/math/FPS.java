package math;

public class FPS {
    private long lastTime, lastTimePS;
    private int fps;

    public FPS(){
        lastTime = System.nanoTime();
        lastTimePS = System.nanoTime();
        fps = 0;
    }

    public void update(){
        fps++;
        if(deltaTimef()>1){
            System.out.println(fps);
            fps=0;
            lastTime=System.nanoTime();
        }
    }

    long ps = 1000000000/30;
    public long sixty(){
        if(deltaTimel()>ps){
            lastTimePS=System.nanoTime();
            return 0;
        }else {
            lastTimePS=System.nanoTime();

            return (ps - deltaTimel())/1000000;
        }
    }

    public float deltaTimef(){
        return (System.nanoTime()-lastTime)/ 1000000000.0f;
    }
    public long deltaTimel(){
        return System.nanoTime()-lastTimePS;
    }
}
