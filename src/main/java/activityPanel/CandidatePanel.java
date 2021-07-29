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
import java.sql.SQLException;

public class CandidatePanel extends JPanel {

    TopPanel topPanel;

    ProfilePanel wordMapProfilePanel;
    TwoButtonPanel TwoButtonPanel = new TwoButtonPanel();
    MapPanel MapPanel = new MapPanel();

    InterestPanel interestPanel;
    JPanel nowPanel;
    PoliticialFactorData politicialFactorData = new PoliticialFactorData();
    PoliticianVO vo;


    public CandidatePanel(PoliticianVO vo) throws IOException, SQLException {
        setLayout(null);

        this.vo = vo;
        interestPanel  = new InterestPanel(vo.getEng_name());
        nowPanel =interestPanel;

        topPanel = new TopPanel(vo.getName(),TopPanel.NOTHINGLABEL);
        topPanel.backButton.addActionListener(new ActionButton());
        wordMapProfilePanel= new ProfilePanel(vo.getImage());


        add(topPanel);
        add(wordMapProfilePanel);
        add(TwoButtonPanel);
        add(interestPanel);

        TwoButtonPanel.snsButton.addMouseListener(new MouseAction());
        TwoButtonPanel.mapButton.addMouseListener(new MouseAction());

    }
    class MouseAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(e.getSource()== TwoButtonPanel.snsButton){
                TwoButtonPanel.selectButton("sns");
                remove(nowPanel);
                add(interestPanel);
                nowPanel = interestPanel;
                updateUI();
            }
            if(e.getSource()== TwoButtonPanel.mapButton){
                TwoButtonPanel.selectButton("map");
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
