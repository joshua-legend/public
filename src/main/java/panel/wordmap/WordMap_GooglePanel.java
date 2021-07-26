package panel.wordmap;

import buttons.WordButton;
import data.PoliticialFactorData;
import wordcloud.CloudViewer;
import wordcloud.WordCloud;
import wordcloud.image.CloudImageGenerator;
import wordcloud.words.StringProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WordMap_GooglePanel extends JPanel {

    public static final String TEXT = "이준석_일자리.txt";
    public static final String FILTER = "korean_filtering.txt";
    GridLayout layout = new GridLayout(3,3,10,10);

    public WordMap_GooglePanel() throws IOException {
        add(WordCloud.cloud());
        setBounds(0,200,500,480);
        setLayout(layout);
    }
    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            PublicMindFrame.selectActivity(new CloudCandidatePanel());
        }
    }
}
