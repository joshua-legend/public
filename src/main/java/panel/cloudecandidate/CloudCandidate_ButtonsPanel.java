package panel.cloudecandidate;

import buttons.UtilButton;

import javax.swing.*;
import java.awt.*;

public class CloudCandidate_ButtonsPanel extends JPanel {

    public UtilButton claudeButton = new UtilButton("클라우드","#82e9de","#c3fdff");
    public UtilButton pieButton = new UtilButton("파이 그래프","#ffca28","#c3fdff");
    public UtilButton barButton = new UtilButton("막대 그래프","#ab47bc","#c3fdff");

    public CloudCandidate_ButtonsPanel() {
        setLayout(new GridLayout(1,3));
        add(claudeButton);
        add(pieButton);
        add(barButton);
        setBounds(0,450,500,50);
    }
}
