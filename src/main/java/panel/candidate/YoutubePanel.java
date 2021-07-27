package panel.candidate;

import buttons.UtilButton;
import panel.candidate.youtube.YoutubeInterestPanel;
import panel.candidate.youtube.YoutubePiePanel;
import panel.candidate.youtube.YoutubeXYPanel;
import wordcloud.CloudViewerPanel;
import wordcloud.WordCloud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class YoutubePanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    public JPanel buttonPanel = new JPanel();
    public UtilButton nextButton = new UtilButton("Next","#e5ffff","#37474f");
    public UtilButton previousButton = new UtilButton("Previous","#e5ffff","#37474f");

    public CloudViewerPanel cloudViewerPanel = WordCloud.cloud();
    public YoutubePiePanel youtubePiePanel = new YoutubePiePanel();
    public YoutubeInterestPanel youtubeInterestPanel = new YoutubeInterestPanel();
    public YoutubeXYPanel youtubeXYPanel = new YoutubeXYPanel();

    public JPanel jPanel[] ={cloudViewerPanel,youtubePiePanel,youtubeInterestPanel,youtubeXYPanel};
    public int now = 0;

    public YoutubePanel() throws IOException {

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
