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

public class Simulation_Pie_Frame extends JFrame {

    HashMap<String,Integer> getVoteHashmap;

    public Simulation_Pie_Frame(String city){
        getVoteHashmap = SimulationCalculation.totalHashmap.get(city);
        add(BorderLayout.CENTER,new Simulation_PiePanel(getVoteHashmap,city));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(700,200);
        setSize(500,700);
        setVisible(true);
    }
}
