package Input;

import java.awt.*;
import java.awt.event.*;

public class TestMouseInput extends Frame {

    private String msg = "";
    private int mouseX = 0, mouseY = 0;

    public static void main(String[] args){
        TestMouseInput tmi = new TestMouseInput();
        tmi.setSize(600, 600);
        tmi.setTitle("TestMouseInput");
        tmi.setVisible(true);
    }

    public TestMouseInput(){
        MyMouseListener mouseListener = new MyMouseListener();
        MyWindowAdapter windowAdapter = new MyWindowAdapter();

        addMouseListener      ( mouseListener );
        addMouseMotionListener( mouseListener );

        addWindowListener( windowAdapter );

    }

    @Override
    public void paint(Graphics g){
        System.out.println(msg);
        g.drawString(msg, mouseX, mouseY);
    }

    private class MyMouseListener implements MouseListener, MouseMotionListener{
        @Override
        public void mouseClicked(MouseEvent me){
            msg += " -- click received";
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            mouseX = mouseEvent.getX();
            mouseY = mouseEvent.getY();
            msg = "Button down";
            System.out.println("Button down");
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            mouseX = mouseEvent.getX();
            mouseY = mouseEvent.getY();
            msg = "Button Released";
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent me){
            mouseX = 100;
            mouseY = 100;
            msg = "Mouse entered";
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            mouseX = 200;
            mouseY = 200;
            msg = "Mouse exited";
            repaint();
        }


        @Override
        public void mouseDragged(MouseEvent me) {
            mouseX = me.getX();
            mouseY = me.getY();
            msg = "*" + " mouse at " + mouseX + " " + mouseY;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            msg = "Moving mouse at " + me.getX() + " " + me. getY () ;
            repaint();
        }
    }

}

