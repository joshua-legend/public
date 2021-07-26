package panel.wordmap;

import buttons.UtilButton;

import javax.swing.*;
import java.awt.*;

public class WordMap_ThreeButtonPanel extends JPanel {

    public UtilButton wordButton = new UtilButton("구글 트렌드","#29b6f6","#ffffff");
    public UtilButton youtubeButton = new UtilButton("유튜브 댓글","#ffffff","#29b6f6");
    public UtilButton mapButton = new UtilButton("지도 및 지역","#ffffff","#29b6f6");


    public WordMap_ThreeButtonPanel() {
        setLayout(new GridLayout(1,3));
        add(wordButton);
        add(youtubeButton);
        add(mapButton);
        setBounds(0,150,500,50);
    }
}
