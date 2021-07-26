package activityPanel;

import panel.cloudecandidate.CloudCandidate_BarChart;
import panel.cloudecandidate.CloudCandidate_ButtonsPanel;
import panel.cloudecandidate.CloudCandidate_PieChart;
import panel.cloudecandidate.CloudCandidate_ProfilePanel;
import panel.TopPanel;
import data.PoliticianVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class CloudCandidatePanel extends JPanel {
    TopPanel topPanel;
    JPanel nowPanel;
    JButton nowButton;

//    CloudPanel claudePanel = new CloudPanel();
    CloudCandidate_BarChart cloudCandidate_BarChart = new CloudCandidate_BarChart();
    CloudCandidate_PieChart cloudCandidate_Piechart = new CloudCandidate_PieChart();
    CloudCandidate_ButtonsPanel cloudCandidate_buttonsPanel = new CloudCandidate_ButtonsPanel();
    CloudCandidate_ProfilePanel cloudCandidate_profilePanel;
    PoliticianVO vo;

    public CloudCandidatePanel(PoliticianVO vo,String word) {
        setLayout(null);
        this.vo = vo;
        nowPanel = cloudCandidate_BarChart;

        topPanel = new TopPanel(vo.getName()+"과 "+word+"의 토픽 모델",TopPanel.NOTHINGLABEL);
        topPanel.backButton.addActionListener(new ActionButton());
        cloudCandidate_profilePanel = new CloudCandidate_ProfilePanel(vo.getImage());
        cloudCandidate_buttonsPanel.pieButton.addMouseListener(new MouseAction());
        cloudCandidate_buttonsPanel.barButton.addMouseListener(new MouseAction());

        add(topPanel);
        add(cloudCandidate_buttonsPanel);
        add(cloudCandidate_profilePanel);
    }

      public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                PublicMindFrame.selectActivity(new WordMapPanel(vo));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    //TODO
    class MouseAction extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(e.getSource()==cloudCandidate_buttonsPanel.pieButton){
                remove(nowPanel);
                add(cloudCandidate_Piechart);
                nowPanel = cloudCandidate_Piechart;
                updateUI();
            }
            if(e.getSource()== cloudCandidate_buttonsPanel.barButton){
                remove(nowPanel);
                add(cloudCandidate_BarChart);
                nowPanel = cloudCandidate_BarChart;
                updateUI();
            }

        }
    }



}
