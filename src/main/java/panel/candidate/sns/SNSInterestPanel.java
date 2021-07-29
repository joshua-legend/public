package panel.candidate.sns;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import sql.SQL_OrderByWords;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SNSInterestPanel extends JPanel {

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    GridLayout gridLayout = new GridLayout(4,1);
    SQL_OrderByWords sql_orderByWords_best,sql_orderByWords_worst;

    JPanel goodPanel = new JPanel(gridLayout);
    JPanel badPanel = new JPanel(gridLayout);

    JLabel bestLabel = new JLabel("긍정어 TOP3");
    JLabel worstLabel = new JLabel("부정어 TOP3");

    LinePanel linePanel = new LinePanel();
    ArrayList bestList;
    ArrayList worstList;



    public SNSInterestPanel(String whose) throws SQLException {

        bestLabel.setHorizontalAlignment(JLabel.CENTER);
        worstLabel.setHorizontalAlignment(JLabel.CENTER);
        goodPanel.add(bestLabel);
        badPanel.add(worstLabel);

        sql_orderByWords_best = new SQL_OrderByWords(whose,"best");
        sql_orderByWords_worst=new SQL_OrderByWords(whose,"worst");
        bestList = sql_orderByWords_best.getList();
        worstList = sql_orderByWords_worst.getList();
        for(int i=0;i<bestList.size();i++){
            JLabel good = new JLabel(bestList.get(i).toString());
            good.setHorizontalAlignment(JLabel.CENTER);
            JLabel bad = new JLabel(bestList.get(i).toString());
            bad.setHorizontalAlignment(JLabel.CENTER);
            goodPanel.add(good);
            badPanel.add(bad);
        }


        controlConstraints(0,0,1,1);
        layout.setConstraints(goodPanel,constraints);
        add(goodPanel);

        controlConstraints(1,0,1,1);
        layout.setConstraints(badPanel,constraints);
        add(badPanel);

        controlConstraints(0,1,2,1);
        layout.setConstraints(linePanel,constraints);
        add(linePanel);

        setLayout(layout);
        setBounds(0,25,480,420);
    }

    void controlConstraints(int x,int y,int width,int height){

        constraints.weightx =1;
        constraints.weighty =1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
    }
}
