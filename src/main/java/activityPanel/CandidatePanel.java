package activityPanel;

import panel.*;
import data.PoliticialFactorData;
import data.PoliticianVO;
import panel.candidate.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class CandidatePanel extends JPanel {

    TopPanel topPanel;

    ProfilePanel wordMapProfilePanel;
    ThreeButtonPanel ThreeButtonPanel = new ThreeButtonPanel();
    MapPanel MapPanel = new MapPanel();
    GooglePanel googlePanel = new GooglePanel();
    YoutubePanel youtubePanel = new YoutubePanel();

    JPanel nowPanel = googlePanel;
    PoliticialFactorData politicialFactorData = new PoliticialFactorData();
    PoliticianVO vo;


    public CandidatePanel(PoliticianVO vo) throws IOException {

        this.vo = vo;
        setLayout(null);

        topPanel = new TopPanel(vo.getName(),TopPanel.NOTHINGLABEL);
        topPanel.backButton.addActionListener(new ActionButton());
        add(topPanel);

        wordMapProfilePanel= new ProfilePanel(vo.getImage());
        add(wordMapProfilePanel);

        add(ThreeButtonPanel);
        add(googlePanel);


        ThreeButtonPanel.googleButton.addMouseListener(new MouseAction());
        ThreeButtonPanel.youtubeButton.addMouseListener(new MouseAction());
        ThreeButtonPanel.mapButton.addMouseListener(new MouseAction());

    }
    class MouseAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(e.getSource()== ThreeButtonPanel.googleButton){
                ThreeButtonPanel.selectButton("google");
                remove(nowPanel);
                add(googlePanel);
                nowPanel = googlePanel;
                updateUI();
            }
            if(e.getSource()== ThreeButtonPanel.youtubeButton){
                ThreeButtonPanel.selectButton("youtube");
                remove(nowPanel);
                add(youtubePanel);
                nowPanel = youtubePanel;
                updateUI();
            }
            if(e.getSource()== ThreeButtonPanel.mapButton){
                ThreeButtonPanel.selectButton("map");
                remove(nowPanel);
                add(MapPanel);
                nowPanel = MapPanel;
                updateUI();
            }
        }
    }

    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PublicMindFrame.selectActivity(new PeopleChoosePanel());
        }
    }
}
