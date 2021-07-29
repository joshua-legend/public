package panel.candidate.sns;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import sql.SQL_OrderByWords;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class snsPiePanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    DefaultPieDataset dataset = new DefaultPieDataset();
    JFreeChart chart = ChartFactory.createPieChart3D("the words that comes to mind",dataset,true ,true,false);
    SQL_OrderByWords sql_orderByWords;
    HashMap hashMap;

    Font font = new Font("돋움", Font.PLAIN, 15);
    final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );


    public snsPiePanel(String whose) throws SQLException {
        chart.getTitle().setFont(font);
        chart.getLegend().setItemFont(font);
        plot.setLabelFont(font);
        sql_orderByWords = new SQL_OrderByWords(whose);
        hashMap =sql_orderByWords.getText();
        setDataset(hashMap);
        plot.setStartAngle( 270 );
        plot.setForegroundAlpha( 0.60f );
        plot.setInteriorGap( 0.02 );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(480,420));
        setLayout(layout);
        add(BorderLayout.CENTER,chartPanel);
        setBounds(0,25,480,420);
    }

    void setDataset(HashMap hashMap){
        Iterator<String> keys = hashMap.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            dataset.setValue(key, Double.parseDouble((String) hashMap.get(key)));
        }
    }

}
