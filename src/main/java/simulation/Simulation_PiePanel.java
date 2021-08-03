package simulation;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import sql.SQL_OrderByWords;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;

public class Simulation_PiePanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    DefaultPieDataset dataset = new DefaultPieDataset();
    JFreeChart chart;


    Font font = new Font("돋움", Font.PLAIN, 15);
    PiePlot3D plot;


    public Simulation_PiePanel(HashMap<String,Integer> hashMap,String area) {

        chart = ChartFactory.createPieChart3D(area+" 총 득표율",dataset,true ,true,false);
        chart.getTitle().setFont(font);
        chart.getLegend().setItemFont(font);
        plot = ( PiePlot3D ) chart.getPlot( );
        plot.setLabelFont(font);

        for( String key : hashMap.keySet() ){
            dataset.setValue(key, hashMap.get(key));
        }

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
