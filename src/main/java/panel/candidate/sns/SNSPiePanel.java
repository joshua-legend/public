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
import java.util.HashMap;
import java.util.Iterator;

public class SNSPiePanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    DefaultPieDataset dataset = new DefaultPieDataset();
    JFreeChart chart = ChartFactory.createPieChart3D("the words that comes to mind",dataset,true ,true,false);
    SQL_OrderByWords sql_positive, sql_negative;
    HashMap hashMap;

    Font font = new Font("돋움", Font.PLAIN, 15);
    final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );


    public SNSPiePanel(String whose) throws SQLException {
        chart.getTitle().setFont(font);
        chart.getLegend().setItemFont(font);
        plot.setLabelFont(font);
        sql_positive = new SQL_OrderByWords(whose,"total_positive");
        sql_negative = new SQL_OrderByWords(whose,"total_negative");
        dataset.setValue("긍정어", sql_positive.getPostiveNum());
        dataset.setValue("부정어", sql_negative.getNegativeNum());
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
