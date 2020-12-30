package Input;

import math.FPS;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestKeybInput extends Frame implements KeyListener {


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

    private String msg = "Hello";
    private String keyState = "";
    private FPS fps;

    public TestKeybInput(){
        fps = new FPS();
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
        setTitle("TestKeybInput");
        setSize(new Dimension(300, 300));
        setBackground(Color.black);
        setForeground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args){
        TestKeybInput tki = new TestKeybInput();
    }

    public void updatelol(){
        try { Thread.sleep(fps.sixty()); } catch (InterruptedException e) { e.printStackTrace(); }
        fps.update();

        repaint();
    }

    int x=0, y=100, width=2, height=300;
    @Override
    public void paint(Graphics g){
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
        for(int i=1; i<=150; i++)
            g.fillRect(x+(1+width)*i, y, width, height);

        //System.out.println(keyState);
        updatelol();
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        msg += keyEvent.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keyState = "Key down";
        int key = keyEvent.getKeyCode();
        switch(key){
            case KeyEvent.VK_RIGHT:
                //msg += "<VK_RIGHT>";
                x+=5;
                break;
            case KeyEvent.VK_LEFT:
                //msg += "<VK_LEFT>";
                x-=5;
                break;
            case KeyEvent.VK_DOWN:
                //msg += "<VK_DOWN>";
                y+=5;
                break;
            case KeyEvent.VK_UP:
                //msg += "<VK_UP>";
                y-=5;
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keyState = "Key up";
        repaint();
    }
}
