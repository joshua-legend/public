package panel.peoplechoose;

import activityPanel.PublicMindFrame;
import activityPanel.WordMapPanel;
import buttons.PeopleButton;
import data.PoliticianData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeopleChoose_PeoplePanel extends JPanel {

    GridLayout gridLayout = new GridLayout(3,3,10,10);
    PoliticianData data = new PoliticianData();


    public PeopleChoose_PeoplePanel() {
        PeopleButton utilButton = new PeopleButton(PoliticianData.map.get("이준석"));
        PeopleButton utilButton1 = new PeopleButton(PoliticianData.map.get("윤석열"));
        PeopleButton utilButton2 = new PeopleButton(PoliticianData.map.get("안철수"));
        PeopleButton utilButton3 = new PeopleButton(PoliticianData.map.get("심상정"));
        PeopleButton utilButton4 = new PeopleButton(PoliticianData.map.get("이재명"));
        PeopleButton utilButton5 = new PeopleButton(PoliticianData.map.get("정세균"));
        PeopleButton utilButton6 = new PeopleButton(PoliticianData.map.get("이낙연"));
        PeopleButton utilButton7 = new PeopleButton(PoliticianData.map.get("오세훈"));
        PeopleButton utilButton8 = new PeopleButton(PoliticianData.map.get("유승민"));

        utilButton.addActionListener(new ActionButton());
        utilButton1.addActionListener(new ActionButton());
        utilButton2.addActionListener(new ActionButton());
        utilButton3.addActionListener(new ActionButton());
        utilButton4.addActionListener(new ActionButton());
        utilButton5.addActionListener(new ActionButton());
        utilButton6.addActionListener(new ActionButton());
        utilButton7.addActionListener(new ActionButton());
        utilButton8.addActionListener(new ActionButton());

        add(utilButton);
        add(utilButton1);
        add(utilButton2);
        add(utilButton3);
        add(utilButton4);
        add(utilButton5);
        add(utilButton6);
        add(utilButton7);
        add(utilButton8);
        setLayout(gridLayout);

        setBounds(0,30,490,650);
    }
    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PeopleButton peopleButton = (PeopleButton)e.getSource();
            PublicMindFrame.selectActivity(new WordMapPanel(peopleButton.vo));
        }
    }
}
