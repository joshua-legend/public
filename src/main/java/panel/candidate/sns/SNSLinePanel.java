package panel.candidate.sns;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import sql.SQL_Popularity;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;

public class SNSLinePanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    public SNSLinePanel(String name) throws SQLException {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "1년별 인지도 차드",
                "2020~2021","Search Percentage",
                createDataset(name),
                PlotOrientation.VERTICAL,
                true,true,false);
        Font font = new Font("돋움", Font.PLAIN, 15);

        lineChart.getTitle().setFont(font);
        lineChart.getLegend().setItemFont(font);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(480,420));
        setLayout(layout);
        add(BorderLayout.CENTER,chartPanel);
        setBounds(0,25,480,420);
    }

    private DefaultCategoryDataset createDataset(String name) throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        HashMap<String,Integer> hashMap = new SQL_Popularity(name).getHash();

        for( String key : hashMap.keySet() ){
            dataset.addValue( hashMap.get(key) , "구글 트렌드" , key );
        }
        return dataset;
    }
}
