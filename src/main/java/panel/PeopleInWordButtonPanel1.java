package panel;

import button.UtilButton;

import javax.swing.*;
import java.awt.*;

public class PeopleInWordButtonPanel1 extends JPanel {

    GridLayout layout = new GridLayout(3,3,10,10);

    UtilButton wordButton = new UtilButton("단어로 보기","#82e9de","#ffffff");
    UtilButton mapButton = new UtilButton("지도로 보기","#29b6f6","#ffffff");
    UtilButton mapButton1 = new UtilButton("지도로 보기","#29b6f6","#ffffff");

    public PeopleInWordButtonPanel1() {
        for(int i=0;i<9;i++){
            add(new UtilButton("단어로 보기","#ffa4a2","#ffffff"));
        }
        setPreferredSize(new Dimension(500,380));
        setBorder(BorderFactory.createEmptyBorder(10 , 10, 10 , 10));
        setLayout(layout);
    }
}
