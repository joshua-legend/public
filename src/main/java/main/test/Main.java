package main.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener{
    GetPercentage gp;
    Simulation_Fifty sf;
    Simulation_Menu_One smo;
    NumberThread nt;
    public Main () {
        frame();
    }
    private void frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setResizable(false);
        setSize(500,700);
        onePanel();
        setVisible(true);
        numberNextSeting();
    }
    private void onePanel() {
        gp = new GetPercentage();
        gp.btn.addActionListener(this);
        add(gp);
    }
    private void twoPanel() {
        sf = new Simulation_Fifty();
        sf.southButton.addActionListener(this);
        add(sf);
    }
    public void actionPerformed(ActionEvent e) {
        JButton button =(JButton) e.getSource();
        if(button.getText().equals("전송")) {
            gp.getPercent();
            if(gp.check) {
                gp.setVisible(false);
                twoPanel();
            }
        }else if(button.getText().equals("시작")) {
            sf.setVisible(false);
            numberStart();
        }
    }
    private void numberStart() {
        nt = new NumberThread();
        add(nt);
    }
    private void numberNextSeting() {
        while(!NumberThread.numberCheck){
            try {
                Thread.sleep(4200);
            } catch (Exception ea) {
                ea.printStackTrace();
            }
            if(NumberThread.numberCheck) {
                nt.setVisible(false);
                setVisible(false);
                smo = new Simulation_Menu_One();
                add(smo);
                setVisible(true);
                break;
            }
        }
    }
    public static void main(String[] args) {
        new Main();
    }

}
