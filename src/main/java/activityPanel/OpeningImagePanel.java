package activityPanel;

import button.UtilButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningImagePanel extends JPanel {

    ImageIcon icon = new ImageIcon("img/background/openingbackground.png");
    Image image = icon.getImage();
    Rectangle rectangle = new Rectangle(100,500,300,60);


    public OpeningImagePanel() {
        setLayout(null);
        JButton utilButton = new UtilButton("민심 확인하러가기","#4fc3f7","#e1f5fe",rectangle);
        utilButton.addActionListener(new ActionButton());
        add(utilButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PublicMindFrame.selectActivity(new MainPagePanel());
        }
    }


}
