import javax.swing.*;
import java.awt.*;

public class Opening extends JFrame {


    Color startColor = new Color(19, 241, 252);
    Color endColor = new Color(4, 112, 220);
//    BackgroundPanel backgroundPanel =  new BackgroundPanel(startColor,endColor);
    JPanel backgroundPanel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(backgroundPanel,BoxLayout.Y_AXIS);



    Opening(){

        backgroundPanel.setLayout(boxLayout);
//        backgroundPanel.add(new Panel("title"));
        backgroundPanel.add(new Panel("image"));
        backgroundPanel.add(new Panel("start"));
        backgroundPanel.add(new Panel("empty"));
        this.add(backgroundPanel);
        setVisible(true);
        setTitle("Public Mind");
        setSize(500,700);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }



    public static void main(String[] args) {
        new Opening();
        Thread t = new Thread();

    }
}