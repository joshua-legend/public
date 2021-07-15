package panel;

import javax.swing.*;
import java.awt.*;

public class backgroundImagePanel extends JPanel {

    ImageIcon icon = new ImageIcon("img/background.png");
    Image image = icon.getImage();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
