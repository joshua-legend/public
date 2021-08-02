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

import com.sun.jdi.Value;


public class Simulation_Menu_One extends JPanel {
    ImageIcon politicianImage;
    ImageIcon partyImage;
    JButton btn[] = new JButton[2];
    private Peple_SetingData ps = new Peple_SetingData();
    private int number;
    private String str[] = {"당선자 정보","투표마감"};
    private JPanel panelFirst  = new JPanel();
    private JPanel btnPanel;
    private JLabel nameLabel;
    private JLabel numberLabel;
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
        buttonPanel(str);
        buttonSeting();
    }
    private void candidateSeting() {
        partyImage= ps.backgroundImage;
        politicianImage = ps.icon;
        nameLabel.setText(ps.candidateName);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setText(ps.symbolNumber);
    }

    private void partySeting() {
        if(ps.candidateParty=="더불어민주당") {
            candidateSeting();
        }else if(ps.candidateParty=="국민의힘") {
            candidateSeting();
        }else if(ps.candidateParty=="정의당") {
            candidateSeting();
            numberLabel.setForeground(Color.BLACK);
        }else if(ps.candidateParty=="국민의당") {
            candidateSeting();
        }else if(ps.candidateParty=="열린민주당") {
            candidateSeting();
        }else if(ps.candidateParty=="기본소득당") {
            candidateSeting();
        }else if(ps.candidateParty=="시대전환") {
            candidateSeting();
        }else if(ps.candidateParty=="국가혁명당") {
            candidateSeting();
        }
    }
    private void buttonSeting() {
        JButton button = new JButton();
        ImageIcon icon = new ImageIcon("img/50blue.png");
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
                electedPerson();
                panelFirst.add(button);
                panelFirst.setVisible(true);
                setVisible(true);
            }
        });
        panelFirst.add(button);
    }
    private void buttonPanel(String[] str) {
        Font font = new Font("맑은 고딕",Font.PLAIN,20);
        btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.setLayout(new GridLayout(2,2));
        for(int i=0;i<btn.length;i++) {
            btn[i] = new JButton(str[i]);
            btn[i].setFont(font);
            btn[i].setFocusPainted(false);
            btn[i].setBackground(Color.WHITE);
            buttonEvent(btn[i]);
            btnPanel.add(btn[i]);
        }
        add("South",btnPanel);
    }
    private void buttonEvent(JButton inButton) {
        inButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                if(button.getText().equals("당선자 정보")) {
                    electedPerson();
                    add("Center",panelFirst);
                    panelFirst.setVisible(true);
                }else if(button.getText().equals("투표마감")) {
                    System.exit(0);
                }
            }
        });
    }
    private void electedPerson() {
        panelFirst.setLayout(null);
        panelFirst .setBackground(Color.WHITE);
        Font font = new Font("맑은 고딕",Font.BOLD,60);
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
        panelFirst.add(nameLabel);
        panelFirst.add(numLabel);
        panelFirst.add(imgLabel);
        panelFirst.add(backgroundImg);

    }
    private void winnerSeting() {
        List<Entry<String, Double>> list = new ArrayList<Entry<String,Double>>(SimulationCar.listHundred.entrySet());

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list, new Comparator<Entry<String,Double>>() {
            // compare로 값을 비교
            public int compare(Entry<String, Double> obj1, Entry<String, Double> obj2) {
                // 오름 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        // 결과 출력
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
