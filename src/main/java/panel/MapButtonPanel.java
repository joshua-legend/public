package panel;

import button.UtilButton;

import javax.swing.*;
import java.awt.*;

public class MapButtonPanel extends JPanel {

    GridLayout layout = new GridLayout(20,10);

    public MapButtonPanel() {
        for(int i=0;i<200;i++){
            add(new UtilButton("","#ba68c8","#ffffff"));
        }
        setPreferredSize(new Dimension(500,380));
        setLayout(layout);
    }
}
