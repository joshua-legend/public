package panel.candidate;

import buttons.UtilButton;
import panel.candidate.google.GoogleInterestPanel;
import panel.candidate.google.GooglePiePanel;
import panel.candidate.google.GoogleXYPanel;
import wordcloud.CloudViewerPanel;
import wordcloud.WordCloud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GooglePanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    public JPanel buttonPanel = new JPanel(new GridLayout(2,1));
    public JPanel northButtonPanel = new JPanel(new GridLayout(1,3));
    public JPanel southButtonPanel = new JPanel(new GridLayout(1,2));


    public JLabel timeJLabel = new JLabel();
    public UtilButton nextTimeButton = new UtilButton("다음 시간","#e5ffff","#37474f");
    public UtilButton previousTimeButton = new UtilButton("이전 시간","#e5ffff","#37474f");
    public UtilButton nextButton = new UtilButton("Next","#e5ffff","#37474f");
    public UtilButton previousButton = new UtilButton("Previous","#e5ffff","#37474f");

    public CloudViewerPanel cloudViewerPanel = WordCloud.cloud();
    public GooglePiePanel googlePiePanel = new GooglePiePanel();
    public GoogleInterestPanel googleInterestPanel = new GoogleInterestPanel();
    public GoogleXYPanel googleXYPanel = new GoogleXYPanel();

    public String time[] = {"1주일전","1달전","3달전","6달전","1년전","3년전"};
    public JPanel jPanel[] ={cloudViewerPanel,googlePiePanel,googleInterestPanel,googleXYPanel};

    private int nowPanel = 0;
    private int nowTime = 0;

    public GooglePanel() throws IOException {

        setLayout(layout);
        add(BorderLayout.CENTER,cloudViewerPanel);

        northButtonPanel.add(previousTimeButton);
        timeJLabel.setHorizontalAlignment(JLabel.CENTER);
        timeJLabel.setText(time[nowTime]);
        northButtonPanel.add(timeJLabel);
        northButtonPanel.add(nextTimeButton);
        southButtonPanel.add(previousButton);
        southButtonPanel.add(nextButton);
        buttonPanel.add(northButtonPanel);
        buttonPanel.add(southButtonPanel);

        previousTimeButton.addActionListener(new ActionButton());
        nextTimeButton.addActionListener(new ActionButton());
        previousButton.addActionListener(new ActionButton());
        nextButton.addActionListener(new ActionButton());

        add(BorderLayout.SOUTH,buttonPanel);
        setBounds(0,200,500,480);
    }
    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==previousButton){
                if(nowPanel ==0) return;
                remove(jPanel[nowPanel]);
                add(jPanel[--nowPanel]);
                updateUI();
            }
            if(e.getSource()==nextButton){
                if(nowPanel ==3) return;
                remove(jPanel[nowPanel]);
                add(jPanel[++nowPanel]);
                updateUI();
            }
            if(e.getSource()==previousTimeButton){
                if(nowTime ==0) return;
                timeJLabel.setText(time[--nowTime]);
                updateUI();
            }
            if(e.getSource()==nextTimeButton){
                if(nowTime ==5) return;
                timeJLabel.setText(time[++nowTime]);
                updateUI();
            }
        }
    }

}
