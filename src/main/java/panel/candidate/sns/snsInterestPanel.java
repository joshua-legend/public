package panel.candidate.sns;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class snsInterestPanel extends JPanel {

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    GridLayout gridLayout = new GridLayout(4,1);

    DefaultPieDataset dataset = new DefaultPieDataset();
    JFreeChart chart = ChartFactory.createPieChart3D("Mobile Sales",dataset,true ,true,false);
    final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );


    JPanel goodPanel = new JPanel(gridLayout);
    JPanel badPanel = new JPanel(gridLayout);

    JLabel bestLabel = new JLabel("긍정어 TOP3");
    JLabel worstLabel = new JLabel("부정어 TOP3");

    InterestPanel jButton = new InterestPanel();


    public snsInterestPanel(){

        //TODO 여기서 하기
        bestLabel.setHorizontalAlignment(JLabel.CENTER);
        worstLabel.setHorizontalAlignment(JLabel.CENTER);
        goodPanel.add(bestLabel);
        badPanel.add(worstLabel);


        for(int i=0;i<3;i++){
            goodPanel.add(new JLabel("1"));
            badPanel.add(new JLabel("2"));
        }


        controlConstraints(0,0,1,1);
        layout.setConstraints(goodPanel,constraints);
        add(goodPanel);

        controlConstraints(1,0,1,1);
        layout.setConstraints(badPanel,constraints);
        add(badPanel);


        controlConstraints(0,1,2,1);
        layout.setConstraints(jButton,constraints);
        add(jButton);

//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new Dimension(480,420));
        setLayout(layout);
//        add(BorderLayout.CENTER,chartPanel);
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
