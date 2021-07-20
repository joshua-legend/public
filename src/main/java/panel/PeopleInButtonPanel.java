package panel;

import button.UtilButton;

import javax.swing.*;
import java.awt.*;

public class PeopleInButtonPanel extends JPanel {

    public UtilButton wordButton = new UtilButton("단어로 보기","#82e9de","#ffffff");
    public UtilButton mapButton = new UtilButton("지도로 보기","#29b6f6","#ffffff");


    public PeopleInButtonPanel() {
        setLayout(new GridLayout(1,2));
        add(wordButton);
        add(mapButton);
        setPreferredSize(new Dimension(500,100));
    }
}
