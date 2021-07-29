package panel.candidate;

import buttons.UtilButton;

import javax.swing.*;
import java.awt.*;

public class TwoButtonPanel extends JPanel {

    final String selectedColor = "#29b6f6";
    final String unselectedColor = "#ffffff";

    public UtilButton snsButton = new UtilButton("SNS 빅데이터","#29b6f6","#37474f");
    public UtilButton mapButton = new UtilButton("지도 데이터","#ffffff","#37474f");


    public TwoButtonPanel() {
        setLayout(new GridLayout(1,2));
        add(snsButton);
        add(mapButton);
        setBounds(0,150,500,50);
    }

    public void selectButton(String select){
        switch(select){
            case "sns":
                snsButton.setBackground(Color.decode(selectedColor));
                mapButton.setBackground(Color.decode(unselectedColor));
                break;
            case "map":
                snsButton.setBackground(Color.decode(unselectedColor));
                mapButton.setBackground(Color.decode(selectedColor));
                break;
        }
    }
}
