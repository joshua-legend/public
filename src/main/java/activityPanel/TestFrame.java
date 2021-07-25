package activityPanel;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {


    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();


    public TestFrame() throws HeadlessException {


        panel1.setLayout(new GridLayout(10,1));


        JScrollPane jScrollPane = new JScrollPane(panel1);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(jScrollPane);
        add(BorderLayout.CENTER,panel);
        setVisible(true);
        setSize(500,500);
    }

    public static void main(String[] args) {
        new TestFrame();
    }
}
