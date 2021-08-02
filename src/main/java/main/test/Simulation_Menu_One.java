package main.test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.jdi.Value;


public class Simulation_Menu_One extends JPanel {
    ImageIcon politicianImage;
    ImageIcon partyImage;
    JButton btn[] = new JButton[4];
    private Peple_SetingData ps = new Peple_SetingData();
    private String str[] = {"후보자 정보","지역 투표율","당선자 정보","투표마감"};
    private String[] nameStr= {"이재명","이낙연","정세균","추미애","김두관","박용진","이준석","홍준표","최재형","윤석열","심상정","안철수"};
    private JPanel panelFirst  = new JPanel();
    private JPanel panelSecond = new JPanel();
    private JPanel panelThird  = new JPanel();
    private JPanel btnPanel;
    private JLabel nameLabel;
    private JLabel imgLabel;
    private JLabel numberLabel;
    private int nameNumber;
    public Simulation_Menu_One() {
        panelBody();
    }
    private void panelBody() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        buttonPanel(str);
        ps.peple(nameStr[nameNumber],0);
        candidateInformationPanel();
        candidateInformation_Button(panelFirst);
    }
    private void panelFirst_BasicForm(JLabel nameLabel,JLabel imgLabel,JLabel numberLabel) {
        panelFirst.setBackground(Color.WHITE);
        panelFirst.setLayout(null);
        panelFirst.add(nameLabel);
        panelFirst.add(imgLabel);
        panelFirst.add(numberLabel);
    }
    private void candidateSeting() {
        partyImage= ps.backgroundImage;
        politicianImage = ps.icon;
        nameLabel.setText(ps.candidateName);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setText(ps.symbolNumber);
    }
    private void candidateInformationPanel(){
        nameLabel = new JLabel();
        imgLabel = new JLabel();
        numberLabel = new JLabel();
        partySeting();
        candidateInformation_BasicForm(nameLabel,imgLabel,numberLabel);
        panelFirst_BasicForm(nameLabel,imgLabel,numberLabel);
        candidateInformation_backgroundImage();
        add("Center",panelFirst);
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
        }
    }
    private void candidateInformation_BasicForm(JLabel nameLabel,JLabel imgLabel,JLabel numberLabel) {
        Font strFont = new Font("맑은 고딕",Font.BOLD,80);
        Font numFont = new Font("맑은 고딕",Font.BOLD,80);
        imgLabel.setIcon(politicianImage);
        imgLabel.setBounds(20, 120,230,280);
        nameLabel.setBounds(240, 485, 400, 90);
        nameLabel.setFont(strFont);
        numberLabel.setBounds(400, 0, 50, 90);
        numberLabel.setFont(numFont);
    }
    private void candidateInformation_backgroundImage() {
        JLabel icon = new JLabel();
        icon.setIcon(partyImage);
        icon.setBounds(0, 0, 500, 700);
        panelFirst.add(icon);
    }
    private void candidateInformation_Button(JPanel panel) {
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
                ++nameNumber;
                if(nameNumber==12) nameNumber=0;
                ps.peple(nameStr[nameNumber],0);
                candidateInformationPanel();
                panelFirst.add(button);
                panelFirst.setVisible(true);
                setVisible(true);
            }
        });
        panel.add(button);
    }
    private void setingEvent(JPanel panel) {
        if(panel==panelFirst) {
            panelSecond.setVisible(false);
            panelThird.setVisible(false);
        }else if(panel==panelSecond) {
            panelFirst.setVisible(false);
            panelThird.setVisible(false);
        }else if(panel==panelThird) {
            panelFirst.setVisible(false);
            panelSecond.setVisible(false);
        }
    }
    private void buttonPanel(String[] str) {
        Font font = new Font("맑은 고딕",Font.PLAIN,20);
        btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.setLayout(new GridLayout(2,2));
        for(int i=0;i<4;i++) {
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
                if(button.getText().equals("후보자 정보")) {
                    setingEvent(panelFirst);
                    add("Center",panelFirst);
                    panelFirst.setVisible(true);
                }else if(button.getText().equals("지역 투표율")) {
                    setingEvent(panelSecond);
                    secondPanel();
                    add("Center",panelSecond);
                    panelSecond.setVisible(true);
                }else if(button.getText().equals("당선자 정보")) {
                    setingEvent(panelThird);
                    electedPerson();
                    add("Center",panelThird);
                    panelThird.setVisible(true);
                }else if(button.getText().equals("투표마감")) {
                    System.exit(0);
                }
            }
        });
    }
    private void secondPanel() {
        panelSecond.setLayout(new BorderLayout());
        panelSecond.setBackground(Color.WHITE);
        JLabel title = new JLabel("지역 투표율",JLabel.CENTER);
        Font font = new Font("맑은 고딕",Font.BOLD,30);
        title.setFont(font);
        panelSecond.add("North",title);
    }
    private void electedPerson() {
        panelThird.setLayout(null);
        panelThird .setBackground(Color.WHITE);
        Peple_SetingData sp = new Peple_SetingData();
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        sp.peple("홍준표",21);
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요
        ///최종 우승자 설정필요

        Font font = new Font("맑은 고딕",Font.BOLD,60);
        JLabel title = new JLabel("당선자",JLabel.CENTER);
        Font fontTitle = new Font("맑은 고딕",Font.BOLD,30);
        title.setFont(fontTitle);
        JLabel backgroundImg = new JLabel();
        backgroundImg.setIcon(sp.backgroundImage);
        backgroundImg.setBounds(0,0,500,700);
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(sp.icon);
        imgLabel.setBounds(10, 85, 280, 330);
        JLabel nameLabel = new JLabel();
        nameLabel.setText(sp.candidateName);
        nameLabel.setFont(font);
        nameLabel.setBounds(300,430,300,80);
        JLabel numLabel = new JLabel();
        numLabel.setText(sp.candidatePercentage+"%");
        numLabel.setFont(font);
        numLabel.setBounds(300,500,300,80);
        panelThird.add(title);
        panelThird.add(nameLabel);
        panelThird.add(numLabel);
        panelThird.add(imgLabel);
        panelThird.add(backgroundImg);
    }
}
