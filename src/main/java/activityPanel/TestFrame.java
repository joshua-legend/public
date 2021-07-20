package activityPanel;

import panel.PeoplePanel;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

    JButton jButton = new JButton();


    public TestFrame() throws HeadlessException {


        setLayout(new FlowLayout());

        //add();




        setVisible(true);
        setSize(500,500);
    }

    public static void main(String[] args) {
        new TestFrame();
    }
}
