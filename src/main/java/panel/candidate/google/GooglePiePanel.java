package panel.candidate.google;

import buttons.UtilButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import wordcloud.WordCloud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GooglePiePanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    DefaultPieDataset dataset = new DefaultPieDataset();
    JFreeChart chart = ChartFactory.createPieChart3D("Mobile Sales",dataset,true ,true,false);

    final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );

    public GooglePiePanel(){
        dataset.setValue( "IPhone 5s",20);
        dataset.setValue( "SamSung Grand",20);
        dataset.setValue( "MotoG", 40);
        dataset.setValue( "Nokia Lumia", 10);
        plot.setStartAngle( 270 );
        plot.setForegroundAlpha( 0.60f );
        plot.setInteriorGap( 0.02 );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(480,420));
        setLayout(layout);
        add(BorderLayout.CENTER,chartPanel);
        setBounds(0,25,480,420);
    }
}
