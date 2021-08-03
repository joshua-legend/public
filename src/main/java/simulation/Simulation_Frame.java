package simulation;

import panel.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Simulation_Frame extends JFrame {

    TopPanel topPanel = new TopPanel("전체결과 보기",TopPanel.NOTHINGLABEL);
    Simulation_Map simulation_map = new Simulation_Map();



    public Simulation_Frame() throws HeadlessException {
        add(BorderLayout.NORTH,topPanel);
        topPanel.backButton.addActionListener(this::actionPerformed);
        add(BorderLayout.CENTER,simulation_map);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(700,200);
        setSize(500,700);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        JButton button =(JButton) e.getSource();
        if(button.getText().equals("Back")) { dispose(); }
    }

}
