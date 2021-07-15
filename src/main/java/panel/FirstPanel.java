package panel;

import javax.swing.*;
import java.awt.*;

public class FirstPanel extends JPanel {

    ImageIcon icon = new ImageIcon("img/firstback.png");
    Image image = icon.getImage();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
