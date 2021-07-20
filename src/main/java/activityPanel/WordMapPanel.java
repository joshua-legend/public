package activityPanel;

import panel.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WordMapPanel extends JPanel {

    SpringLayout springLayout = new SpringLayout();

    PeoplePanel charPanel = new PeoplePanel();
    PeopleInButtonPanel peopleInButtonPanel = new PeopleInButtonPanel();
    PeopleInWordButtonPanel peopleInWordButtonPanel = new PeopleInWordButtonPanel();
    MapButtonPanel mapButtonPanel = new MapButtonPanel();

    public WordMapPanel() {

        add(charPanel);
        springLayout.putConstraint(SpringLayout.NORTH, charPanel, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, charPanel, 0, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.EAST, charPanel, 0, SpringLayout.EAST, this);

        peopleInButtonPanel.wordButton.addMouseListener(new MouseAction());
        add(peopleInButtonPanel);
        springLayout.putConstraint(SpringLayout.NORTH, peopleInButtonPanel, 0, SpringLayout.NORTH, charPanel);

        add(peopleInWordButtonPanel);
        springLayout.putConstraint(SpringLayout.NORTH, peopleInWordButtonPanel, 0, SpringLayout.NORTH, peopleInButtonPanel);

    }

    class MouseAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(e.getSource()==peopleInButtonPanel.wordButton){
//                remove(peopleInWordButtonPanel);
//                add(mapButtonPanel);
                updateUI();
            }
        }
    }
}
