package main.test;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class NumberThread extends JPanel implements Runnable{

    Image img;
    int imgNumber= 5;
    static boolean numberCheck;
    public NumberThread () {
        Thread t= new Thread(this);
        t.start();
    }
    public void paint(Graphics g) {
        img = Toolkit.getDefaultToolkit().getImage("img/"+imgNumber+".png");
        g.drawImage(img, 0, 0,this);
    }
    public void run() {
        try {
            while(true) {
                Thread.sleep(990);
                imgNumber--;
                repaint();
                if(imgNumber==0) {
                    numberCheck= true;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


