package panel.candidate;

import buttons.UtilButton;
import panel.candidate.sns.SNSInterestPanel;
import panel.candidate.sns.SNSPiePanel;
import panel.candidate.sns.SNSXYPanel;
import wordcloud.CloudViewerPanel;
import wordcloud.WordCloud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class InterestPanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    public JPanel buttonPanel = new JPanel();
    public UtilButton nextButton = new UtilButton("Next","#e5ffff","#37474f");
    public UtilButton previousButton = new UtilButton("Previous","#e5ffff","#37474f");

    public WordCloud wordCloud = new WordCloud();
    public CloudViewerPanel cloudViewerPanel;
    public SNSPiePanel snsPiePanel;
    public SNSInterestPanel snsInterestPanel;
    public SNSXYPanel snsXYPanel;
    public ArrayList<JPanel> jPanels = new ArrayList<>();
    public int now = 0;

    public InterestPanel(String name) throws IOException, SQLException {

        setLayout(layout);
        cloudViewerPanel = wordCloud.cloud(name);
        snsPiePanel = new SNSPiePanel(name);
        snsInterestPanel = new SNSInterestPanel(name);
        snsXYPanel = new SNSXYPanel();


        jPanels.add(cloudViewerPanel);
        jPanels.add(snsPiePanel);
        jPanels.add(snsInterestPanel);
        jPanels.add(snsXYPanel);


        add(BorderLayout.CENTER,cloudViewerPanel);

        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        previousButton.addActionListener(new ActionButton());
        nextButton.addActionListener(new ActionButton());

        add(BorderLayout.SOUTH,buttonPanel);
        setBounds(0,200,500,480);
    }

    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==previousButton){
                if(now==0) return;
                remove(jPanels.get(now));
                add(BorderLayout.CENTER,jPanels.get(--now));
                updateUI();
            }
            if(e.getSource()==nextButton){
                if(now==3) return;
                remove(jPanels.get(now));
                add(BorderLayout.CENTER,jPanels.get(++now));
                updateUI();
            }
        }
    }
}
