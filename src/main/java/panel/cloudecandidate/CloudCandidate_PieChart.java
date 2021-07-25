package panel.cloudecandidate;

import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartUtilities;

import java.awt.*;
import java.io.File;

public class CloudCandidate_PieChart extends JPanel {

    DefaultPieDataset dataset = new DefaultPieDataset();
    JFreeChart chart = ChartFactory.createPieChart3D("Mobile Sales",dataset,true ,true,false);

    final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );

    public CloudCandidate_PieChart() {
        dataset.setValue( "IPhone 5s",20);
        dataset.setValue( "SamSung Grand",20);
        dataset.setValue( "MotoG", 40);
        dataset.setValue( "Nokia Lumia", 10);
        plot.setStartAngle( 270 );
        plot.setForegroundAlpha( 0.60f );
        plot.setInteriorGap( 0.02 );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(480,420));
        add(chartPanel);
        setBounds(0,25,480,420);
    }
}
