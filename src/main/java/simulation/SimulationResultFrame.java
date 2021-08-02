package simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationResultFrame extends JFrame{
    GetPercentage gp;
    Simulation_Menu_One smo;
    NumberThread nt;
    public SimulationResultFrame() {
        frame();
    }
    private void frame() {
        smo = new Simulation_Menu_One();
        add(smo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(Color.WHITE);
        setResizable(false);
        setSize(500,700);
        setVisible(true);
    }
}
