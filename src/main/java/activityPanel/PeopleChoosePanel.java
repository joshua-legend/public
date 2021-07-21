package activityPanel;

import button.PeopleButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeopleChoosePanel extends JPanel {

    GridLayout layout = new GridLayout(4,3,10,10);
    Image mainImage = new ImageIcon("img/background/peoplechoosebackground.png").getImage();
    PoliticianData data = new PoliticianData();

    public PeopleChoosePanel() {
        setLayout(layout);
        setBorder(BorderFactory.createEmptyBorder(10 , 10, 10 , 10));

        JButton utilButton = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton1 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton2 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton3 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton4 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton5 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton6 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton7 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton8 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton9 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton10 = new PeopleButton(PoliticianData.map.get("이준석"));
        JButton utilButton11 = new PeopleButton(PoliticianData.map.get("이준석"));


        utilButton.addActionListener(new ActionButton());
        add(utilButton);
        add(utilButton1);
        add(utilButton2);
        add(utilButton3);
        add(utilButton4);
        add(utilButton5);
        add(utilButton6);
        add(utilButton7);
        add(utilButton8);
        add(utilButton9);
        add(utilButton10);
        add(utilButton11);
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
