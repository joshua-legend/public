package wordcloud;

import buttons.UtilButton;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CloudViewerPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage bi;
    private BorderLayout layout = new BorderLayout();
    public CloudViewerPanel(BufferedImage bi) {
        setLayout(layout);
        this.bi = bi;
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bi, 0, 0, null);
    }
}
