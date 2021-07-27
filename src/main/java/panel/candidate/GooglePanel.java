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

    public JPanel buttonPanel = new JPanel();
    public UtilButton nextButton = new UtilButton("Next","#e5ffff","#37474f");
    public UtilButton previousButton = new UtilButton("Previous","#e5ffff","#37474f");

    public CloudViewerPanel cloudViewerPanel = WordCloud.cloud();
    public GooglePiePanel googlePiePanel = new GooglePiePanel();
    public GoogleInterestPanel googleInterestPanel = new GoogleInterestPanel();
    public GoogleXYPanel googleXYPanel = new GoogleXYPanel();

    public JPanel jPanel[] ={cloudViewerPanel,googlePiePanel,googleInterestPanel,googleXYPanel};
    public int now = 0;

    public GooglePanel() throws IOException {

        setLayout(layout);
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
                remove(jPanel[now]);
                add(jPanel[--now]);
                updateUI();
            }
            if(e.getSource()==nextButton){
                if(now==3) return;
                remove(jPanel[now]);
                add(jPanel[++now]);
                updateUI();
            }
        }
    }
}
