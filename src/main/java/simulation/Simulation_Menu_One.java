package simulation;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buttons.UtilButton;


public class Simulation_Menu_One extends JPanel {
    ImageIcon politicianImage;
    ImageIcon partyImage;
    private JButton btn;
    private Peple_SetingData ps = new Peple_SetingData();
    private int number;
    private JPanel panelFirst  = new JPanel();
    private Simulation_Map simulation_map = new Simulation_Map();
    public static Simulation_Frame simulation_frame;


    private JPanel btnPanel;
    private String[] nameRank = new String[3];
    private double[] perRank = new double[3];
    public Simulation_Menu_One() {
        panelBody();
    }
    private void panelBody() {
        winnerSeting();
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        ps.peple(nameRank[number],perRank[number]);
        electedPerson();
        add("Center",panelFirst);
        buttonPanel();
        buttonSeting();
    }
    private void buttonSeting() {
        JButton button = new JButton();
        ImageIcon icon = new ImageIcon("img/50.png");
        button.setSize(50,50);
        button.setIcon(icon);
        button.setBounds(420,274, 50, 50);
        button.setBackground(getBackground());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelFirst.setVisible(false);
                panelFirst.removeAll();
                number++;
                if(number==3)number=0;
                ps.peple(nameRank[number],perRank[number]);
                panelFirst.add(button);
                electedPerson();
                panelFirst.setVisible(true);
                setVisible(true);
            }
        });
        panelFirst.add(button);
    }
    private void buttonPanel() {
        Font font = new Font("?????? ??????",Font.PLAIN,20);
        btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.setLayout(new GridLayout(1,2));

        UtilButton resultBtn = new UtilButton("????????????");
        btn = new UtilButton("??????");


        resultBtn.setFont(font);
        resultBtn.setFocusPainted(false);
        buttonEvent(resultBtn);
        btnPanel.add(resultBtn);
        btn.setFont(font);
        btn.setFocusPainted(false);
        buttonEvent(btn);
        btnPanel.add(btn);
        add("South",btnPanel);
    }
    private void buttonEvent(JButton inButton) {
        inButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getText().equals("??????")) {
                    NumberThread.simulationResultFrame.dispose();
                }
                if(button.getText().equals("????????????")) {
                    simulation_frame = new Simulation_Frame();
                }
            }
        });
    }
    private void electedPerson() {
        panelFirst.setLayout(null);
        panelFirst .setBackground(Color.WHITE);
        Font font = new Font("?????? ??????",Font.BOLD,60);
        JLabel backgroundImg = new JLabel();
        backgroundImg.setIcon(ps.backgroundImage);
        backgroundImg.setBounds(0,0,500,700);
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(ps.icon);
        imgLabel.setBounds(10, 85, 280, 330);
        JLabel nameLabel = new JLabel();
        nameLabel.setText(ps.candidateName);
        nameLabel.setFont(font);
        nameLabel.setBounds(300,430,300,80);
        JLabel numLabel = new JLabel();
        numLabel.setText(ps.candidatePercentage+"%");
        numLabel.setFont(font);
        numLabel.setBounds(300,500,300,80);
        JLabel rank = new JLabel();
        rank.setText(1+number+"???");
        rank.setForeground(Color.WHITE);
        rank.setFont(font);
        rank.setBounds(380,30, 150, 80);
        panelFirst.add(rank);
        panelFirst.add(nameLabel);
        panelFirst.add(numLabel);
        panelFirst.add(imgLabel);
        panelFirst.add(backgroundImg);

    }
    private void winnerSeting() {
        List<Entry<String, Double>> list = new ArrayList<Entry<String,Double>>(SimulationCalculation.listHundred.entrySet());

        // ???????????? Comparator??? ???????????? ?????????????????? ??????
        Collections.sort(list, new Comparator<Entry<String,Double>>() {
            // compare??? ?????? ??????
            public int compare(Entry<String, Double> obj1, Entry<String, Double> obj2) {
                // ?????? ?????? ??????
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        // ?????? ??????
        int num = 0;
        for(Entry<String, Double> entry : list) {
            if(num<3) {
                nameRank[num] = entry.getKey();
                perRank[num]= entry.getValue();
                if(num==3) break;
                num++;
            }
        }
    }
}
