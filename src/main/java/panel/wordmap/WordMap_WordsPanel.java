package panel.wordmap;

import data.PoliticialFactorData;
import buttons.WordButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordMap_WordsPanel extends JPanel {

    GridLayout layout = new GridLayout(3,3,10,10);

    public WordButton[] wordButton = new WordButton[10];

    public WordMap_WordsPanel() {
        PoliticialFactorData politicalFactors = new PoliticialFactorData();
        for(int i=0;i<9;i++){
            add(wordButton[i] = new WordButton(politicalFactors.map.get(i+1)));
        }
        setBounds(0,200,500,480);
        setBorder(BorderFactory.createEmptyBorder(10 , 10, 10 , 10));
        setLayout(layout);
    }
    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            PublicMindFrame.selectActivity(new CloudCandidatePanel());
        }
    }
}
