package activityPanel;

import button.PeopleButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeopleChoosePanel extends JPanel {

    GridLayout layout = new GridLayout(4,3,10,10);
    Image mainImage = new ImageIcon("img/background/peoplechoosebackground.png").getImage();
    ImageIcon leejunsukImage = new ImageIcon("img/lee1.png");
    Rectangle rectangle = new Rectangle(50,550,100,100);

    public PeopleChoosePanel() {
        setLayout(layout);

        JButton utilButton = new PeopleButton("이준석",leejunsukImage,"#4fc3f7","#e1f5fe",rectangle);
        JButton utilButton1 = new PeopleButton("이준석",leejunsukImage,"#4fc3f7","#e1f5fe",rectangle);
        JButton utilButton2 = new PeopleButton("이준석",leejunsukImage,"#4fc3f7","#e1f5fe",rectangle);
        JButton utilButton3 = new PeopleButton("이준석",leejunsukImage,"#4fc3f7","#e1f5fe",rectangle);
        JButton utilButton4 = new PeopleButton("이준석",leejunsukImage,"#4fc3f7","#e1f5fe",rectangle);
        JButton utilButton5 = new PeopleButton("이준석",leejunsukImage,"#4fc3f7","#e1f5fe",rectangle);

        utilButton.addActionListener(new ActionButton());
        add(utilButton);
        add(utilButton1);
        add(utilButton2);
        add(utilButton3);
        add(utilButton4);
        add(utilButton5);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mainImage, 0, 0, this);
    }

    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PublicMindFrame.selectActivity(new WordMapPanel());
        }
    }
}
