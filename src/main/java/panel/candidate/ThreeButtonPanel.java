package panel.candidate;

import buttons.UtilButton;

import javax.swing.*;
import java.awt.*;

public class ThreeButtonPanel extends JPanel {

    final String selectedColor = "#29b6f6";
    final String unselectedColor = "#ffffff";


    public UtilButton googleButton = new UtilButton("구글 트렌드","#29b6f6","#37474f");
    public UtilButton youtubeButton = new UtilButton("유튜브 댓글","#ffffff","#37474f");
    public UtilButton mapButton = new UtilButton("지도 및 지역","#ffffff","#37474f");


    public ThreeButtonPanel() {
        setLayout(new GridLayout(1,3));
        add(googleButton);
        add(youtubeButton);
        add(mapButton);
        setBounds(0,150,500,50);
    }

    public void selectButton(String select){
        switch(select){
            case "google":
                googleButton.setBackground(Color.decode(selectedColor));
                youtubeButton.setBackground(Color.decode(unselectedColor));
                mapButton.setBackground(Color.decode(unselectedColor));
                break;
            case "youtube":
                googleButton.setBackground(Color.decode(unselectedColor));
                youtubeButton.setBackground(Color.decode(selectedColor));
                mapButton.setBackground(Color.decode(unselectedColor));
                break;
            case "map":
                googleButton.setBackground(Color.decode(unselectedColor));
                youtubeButton.setBackground(Color.decode(unselectedColor));
                mapButton.setBackground(Color.decode(selectedColor));
                break;
        }
    }
}
