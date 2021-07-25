package activityPanel;

import panel.*;
import data.PoliticialFactorData;
import data.PoliticianVO;
import panel.wordmap.WordMap_MapPanel;
import panel.wordmap.WordMap_ProfilePanel;
import panel.wordmap.WordMap_TwoButtonPanel;
import panel.wordmap.WordMap_WordsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WordMapPanel extends JPanel {

    TopPanel topPanel;
    WordMap_ProfilePanel wordMapProfilePanel;
    WordMap_TwoButtonPanel wordMapTwoButton = new WordMap_TwoButtonPanel();
    WordMap_WordsPanel wordMapPeopleInWordButtonPanel = new WordMap_WordsPanel();
    WordMap_MapPanel wordMap_MapPanel = new WordMap_MapPanel();

    PoliticianVO vo;
    String whichOne = "left";
    public WordMapPanel(PoliticianVO vo) {

        this.vo = vo;
        PoliticialFactorData politicialFactorData = new PoliticialFactorData();
        setLayout(null);

        topPanel = new TopPanel(vo.getName());
        topPanel.backButton.addActionListener(new ActionButton());
        add(topPanel);

        WordMap_ProfilePanel wordMapProfilePanel= new WordMap_ProfilePanel(vo.getImage());
        add(wordMapProfilePanel);

        add(wordMapTwoButton);
        wordMapTwoButton.wordButton.addMouseListener(new MouseAction());
        wordMapTwoButton.mapButton.addMouseListener(new MouseAction());

        add(wordMapPeopleInWordButtonPanel);

        for(int i=0;i<9;i++)
            wordMapPeopleInWordButtonPanel.wordButton[i].addActionListener(new WordButton(vo,wordMapPeopleInWordButtonPanel.wordButton[i].getVoTitle()));

//        add(wordMap_buttonMapPanel);
    }
    class MouseAction extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(e.getSource()== wordMapTwoButton.wordButton){
                if(whichOne.equals("right")){
                    remove(wordMap_MapPanel);
                    add(wordMapPeopleInWordButtonPanel);
                    updateUI();
                    whichOne="left";
                }
            }
            if(e.getSource()== wordMapTwoButton.mapButton){
                if(whichOne.equals("left")){
                    remove(wordMapPeopleInWordButtonPanel);
                    add(wordMap_MapPanel);
                    updateUI();
                    whichOne="right";
                }
            }
        }
    }
    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PublicMindFrame.selectActivity(new PeopleChoosePanel());
        }
    }
    public class WordButton implements ActionListener {
        PoliticianVO vo;
        String title;

        public WordButton(PoliticianVO vo, String title) {
            this.vo = vo;
            this.title = title;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            PublicMindFrame.selectActivity(new CloudCandidatePanel(vo,title));
        }
    }
}
