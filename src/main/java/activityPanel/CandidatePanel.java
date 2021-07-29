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
    TwoButtonPanel twoButtonPanel = new TwoButtonPanel();
    MapPanel mapPanel;

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
        mapPanel = new MapPanel(vo.getName());


        add(topPanel);
        add(wordMapProfilePanel);
        add(twoButtonPanel);
        add(interestPanel);

        twoButtonPanel.snsButton.addMouseListener(new MouseAction());
        twoButtonPanel.mapButton.addMouseListener(new MouseAction());

    }
    class MouseAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(e.getSource()== twoButtonPanel.snsButton){
                twoButtonPanel.selectButton("sns");
                remove(nowPanel);
                add(interestPanel);
                nowPanel = interestPanel;
                updateUI();
            }
            if(e.getSource()== twoButtonPanel.mapButton){
                twoButtonPanel.selectButton("map");
                remove(nowPanel);
                add(mapPanel);
                nowPanel = mapPanel;
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
