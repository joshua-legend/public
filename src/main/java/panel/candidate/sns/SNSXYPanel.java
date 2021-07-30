package panel.candidate.sns;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

@Deprecated
public class SNSXYPanel extends JPanel {

    BorderLayout layout = new BorderLayout();

    public SNSXYPanel(){
        XYZDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createBubbleChart(
                "AGE vs WEIGHT vs WORK",
                "Weight",
                "AGE",
                dataset,
                PlotOrientation.HORIZONTAL,
                true, true, false);
        // Set range for X-Axis
        XYPlot plot = chart.getXYPlot();
        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        domain.setRange(0, 100);

        // Set range for Y-Axis
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0, 100);

        //Format label
        XYBubbleRenderer renderer=(XYBubbleRenderer)plot.getRenderer();
        BubbleXYItemLabelGenerator generator=new BubbleXYItemLabelGenerator(
                " {0}:({1},{2},{3}) ",new DecimalFormat("0"),
                new DecimalFormat("0"),
                new DecimalFormat("0"));
        renderer.setBaseItemLabelGenerator(generator);
        renderer.setBaseItemLabelsVisible(true);

        // Create Panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(480,420));
        setLayout(layout);
        add(BorderLayout.CENTER,chartPanel);
        setBounds(0,25,480,420);
    }

    private XYZDataset createDataset() {
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        dataset.addSeries("INDIA", new double[][] {{ 40 }, { 65 }, { 25 }});
        dataset.addSeries("USA", new double[][] { { 30 }, { 20 }, { 25 }});
        dataset.addSeries("CHINA", new double[][] { { 80 }, { 50 }, { 25 } });
        dataset.addSeries("JAPAN", new double[][] { { 11 }, { 50 }, { 25 } });
        return dataset;
    }
}
