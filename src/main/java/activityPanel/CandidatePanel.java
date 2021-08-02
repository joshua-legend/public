package activityPanel;

import panel.*;
import data.PoliticialFactorData;
import data.PoliticianVO;
import panel.candidate.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

public class CandidatePanel extends JPanel {

    TopPanel topPanel;

    ProfilePanel profilePanel;
    TwoButtonPanel twoButtonPanel = new TwoButtonPanel();

    JPanel map_explainPanel = new JPanel();
    MapPanel mapPanel;

    DataPanel dataPanel;
    JPanel nowPanel;
    PoliticianVO vo;


    public CandidatePanel(PoliticianVO vo) throws IOException, SQLException {
        setLayout(null);

        this.vo = vo;
        dataPanel = new DataPanel(vo.getEng_name());
        nowPanel = dataPanel;

        topPanel = new TopPanel(vo.getName(),TopPanel.NOTHINGLABEL);
        topPanel.backButton.addActionListener(new ActionButton());
        profilePanel = new ProfilePanel(vo.getImage(),vo.getParty().toString(),vo.getStatus());

        mapPanel = new MapPanel(vo.getName());

        add(topPanel);
        add(profilePanel);
        add(dataPanel);
        add(twoButtonPanel);

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
                add(dataPanel);
                nowPanel = dataPanel;
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
