package panel.candidate.sns;

import javax.swing.*;
import java.awt.*;

public class GoodPanel extends JPanel {
    Image mainImage = new ImageIcon("img/background/left.png").getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mainImage, 0, 0, this);
    }

}
