import button.Button;
import panel.FirstPanel;
import panel.backgroundImagePanel;

import javax.swing.*;

public class Opening extends JFrame {

    backgroundImagePanel backgroundPanel = new backgroundImagePanel();
    FirstPanel firstPanel = new FirstPanel();

    JButton button = new Button("민심 확인하러가기","#4fc3f7","#e1f5fe");


    Opening(){

//        backgroundPanel.setLayout(null);
//        backgroundPanel.add(button);
//        add(backgroundPanel);

        add(firstPanel);
        setVisible(true);
        setTitle("Public Mind");
        setSize(500,700);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Opening();
    }
}