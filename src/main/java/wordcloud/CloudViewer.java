package wordcloud;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CloudViewer extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage bi;
    
    public CloudViewer(BufferedImage bi) {
        this.bi = bi;
    }
    
    public void paint(Graphics g) {
        g.drawImage(bi, 0, 0, null);
    }
}
