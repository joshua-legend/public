package activityPanel;

import panel.peoplechoose.PeopleChoose_PeoplePanel;
import panel.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeopleChoosePanel extends JPanel {

    Image mainImage = new ImageIcon("img/background/peoplechoosebackground.png").getImage();
    TopPanel topPanel = new TopPanel("인물 고르기",TopPanel.SELECTBOX);
    PeopleChoose_PeoplePanel peoplePanel = new PeopleChoose_PeoplePanel();

    public PeopleChoosePanel() {
        setLayout(null);
        topPanel.backButton.addActionListener(new ActionButton());
        topPanel.selectBox.addActionListener(new SelectBox());
        add(topPanel);
        add(peoplePanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mainImage, 0, 0, this);
    }
    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PublicMindFrame.selectActivity(new MainPagePanel());
        }
    }

    public class SelectBox implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(topPanel.selectBox.getSelectedItem().toString().equals("이름별"))
                peoplePanel.sortByName();
            if(topPanel.selectBox.getSelectedItem().toString().equals("정당별"))
                peoplePanel.sortByParty();
        }
    }

}
