package panel.candidate;

import buttons.UtilButton;
import panel.candidate.sns.SNSLinePanel;
import panel.candidate.sns.SNSTop7Panel;
import panel.candidate.sns.SNSPiePanel;
import wordcloud.CloudViewerPanel;
import wordcloud.WordCloud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataPanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    final private String GOOD = "#a5d6a7";
    final private String BAD = "#f8bbd0";

    public UtilButton goodBadButton = new UtilButton("긍정어","#a5d6a7","#37474f");

    public JPanel buttonsPanel = new JPanel(new GridLayout(1,2));
    public UtilButton nextButton = new UtilButton("Next","#e5ffff","#37474f");
    public UtilButton previousButton = new UtilButton("Previous","#e5ffff","#37474f");

    public WordCloud wordCloud = new WordCloud();
    public CloudViewerPanel positivePanel,negativePanel;
    public SNSPiePanel snsPiePanel;
    public SNSTop7Panel snsTop7Panel;
    public SNSLinePanel SNSLinePanel;
    public ArrayList<JPanel> jPanels = new ArrayList<>();
    public int now = 0;

    public DataPanel(String name) throws IOException, SQLException {

        setLayout(layout);
        positivePanel = wordCloud.cloud(name+"_PO");
        negativePanel = wordCloud.cloud(name+"_NA");

        snsPiePanel = new SNSPiePanel(name);
        snsTop7Panel = new SNSTop7Panel(name);
        SNSLinePanel = new SNSLinePanel();

        jPanels.add(positivePanel);
        jPanels.add(snsPiePanel);
        jPanels.add(snsTop7Panel);
        jPanels.add(SNSLinePanel);
        add(BorderLayout.CENTER, positivePanel);

        buttonsPanel.setLayout(new GridLayout(1,3));
        buttonsPanel.add(previousButton);
        buttonsPanel.add(goodBadButton);
        buttonsPanel.add(nextButton);

        add(BorderLayout.SOUTH, buttonsPanel);

        previousButton.addActionListener(new ActionButton());
        goodBadButton.addActionListener(new ActionButton());
        nextButton.addActionListener(new ActionButton());
        setBounds(0,200,500,480);
    }

    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==goodBadButton){
                if(goodBadButton.getText().equals("긍정어")){
                    System.out.println("긍정");
                    remove(jPanels.get(now));
                    jPanels.remove(0);
                    jPanels.add(0,negativePanel);
                    add(BorderLayout.CENTER,jPanels.get(0));
                    goodBadButton.setText("부정어");
                    goodBadButton.setBackground(Color.decode(BAD));
                    updateUI();
                }else{
                    remove(jPanels.get(now));
                    jPanels.remove(0);
                    jPanels.add(0,positivePanel);
                    add(BorderLayout.CENTER,jPanels.get(0));
                    goodBadButton.setText("긍정어");
                    goodBadButton.setBackground(Color.decode(GOOD));
                    updateUI();
                }
                updateUI();
            }
            if(e.getSource()==previousButton){
                if(now==0) return;
                remove(jPanels.get(now));
                add(BorderLayout.CENTER,jPanels.get(--now));
                updateUI();
                if(now==0){
                    buttonsPanel.setLayout(new GridLayout(1,3));
                    buttonsPanel.add(previousButton);
                    buttonsPanel.add(goodBadButton);
                    buttonsPanel.add(nextButton);
                }
                else{
                    buttonsPanel.removeAll();
                    buttonsPanel.setLayout(new GridLayout(1,2));
                    buttonsPanel.add(previousButton);
                    buttonsPanel.add(nextButton);
                }
                updateUI();
            }
            if(e.getSource()==nextButton){
                if(now==3) return;
                remove(jPanels.get(now));
                add(BorderLayout.CENTER,jPanels.get(++now));
                if(now==0){
                    buttonsPanel.setLayout(new GridLayout(1,3));
                    buttonsPanel.add(previousButton);
                    buttonsPanel.add(goodBadButton);
                    buttonsPanel.add(nextButton);
                }
                else{
                    buttonsPanel.removeAll();
                    buttonsPanel.setLayout(new GridLayout(1,2));
                    buttonsPanel.add(previousButton);
                    buttonsPanel.add(nextButton);
                }
                updateUI();
            }
        }
    }
}
