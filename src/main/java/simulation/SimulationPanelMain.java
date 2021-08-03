package simulation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimulationPanelMain extends JFrame implements ActionListener{
    GetPercentage gp;
    Simulation_Menu_One smo;
    NumberThread nt;
    public SimulationPanelMain () {
        frame();
    }
    private void frame() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(Color.WHITE);
        setResizable(false);
        setLocation(700,200);
        setSize(500,700);
        onePanel();
        setVisible(true);
    }
    private void onePanel() {
        gp = new GetPercentage();
        gp.btn.addActionListener(this);
        add(gp);
    }
    public void actionPerformed(ActionEvent e) {
        JButton button =(JButton) e.getSource();
        if(button.getText().equals("전송")) {
            gp.getPercent();
            if(gp.check) {
                numberStart();
            }
        }
    }
    private void numberStart() {
        gp.setVisible(false);
        nt = new NumberThread();
        add(nt);
    }
}
