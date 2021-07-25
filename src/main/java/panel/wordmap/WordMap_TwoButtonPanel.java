package panel.wordmap;

import buttons.UtilButton;

import javax.swing.*;
import java.awt.*;

public class WordMap_TwoButtonPanel extends JPanel {

    public UtilButton wordButton = new UtilButton("단어로 보기","#82e9de","#ffffff");
    public UtilButton mapButton = new UtilButton("지도로 보기","#29b6f6","#ffffff");


    public WordMap_TwoButtonPanel() {
        setLayout(new GridLayout(1,2));
        add(wordButton);
        add(mapButton);
        setBounds(0,150,500,50);
    }
}
