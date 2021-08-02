package main.test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Simulation_Fifty extends JPanel{

    public JButton southButton = new JButton();
    private String rank;
    private JPanel cenPanel;
    private Peple_SetingData ps = new Peple_SetingData();
    private ImageIcon backgroundImage = new ImageIcon("img/oneback.png");
    private JLabel[] potoJLabel = new JLabel[3];
    private JLabel[] nameJLabel = new JLabel[3];
    private JLabel[] numberJLabel = new JLabel[3];

    private String[] nameRank = new String[3];
    private double[] perRank = new double[3];

    public Simulation_Fifty() {
        panelMain();
    }
    public void rankInput() {
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        nameRank[0] = "이재명";
        nameRank[1] = "윤석열";
        nameRank[2] = "안철수";
        perRank[0]= 45.1;
        perRank[1]= 45.1;
        perRank[2]= 45.1;
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
        // 데이터로 정보를 바꿔주세요
    }
    private void panelMain() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        centerPanel();
        southBtn();
        add("Center",cenPanel);
    }
    private void southBtn() {
        Font fontStr = new Font("맑은 고딕",Font.BOLD,20);
        southButton.setBackground(Color.WHITE);
        southButton.setFont(fontStr);
        southButton.setText("시작");
        southButton.setFocusPainted(false);
        southButton.setBounds(270, 600, 200, 50);
        cenPanel.add(southButton);
    }
    private void centerPanel() {
        cenPanel = new JPanel();
        cenPanel.setBackground(Color.WHITE);
        cenPanel.setLayout(null);
        // 임시로 넣었습니다 !
        // 임시로 넣었습니다 !
        // 임시로 넣었습니다 !
        // 임시로 넣었습니다 !
        rankInput();
        // 임시로 넣었습니다 !
        // 임시로 넣었습니다 !
        // 임시로 넣었습니다 !
        // 임시로 넣었습니다 !
        setingCandidate(nameRank[0],"1",perRank[0]);
        setingCandidate(nameRank[1],"2",perRank[1]);
        setingCandidate(nameRank[2],"3",perRank[1]);
        backgroundImage();
    }
    private void backgroundImage() {
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(backgroundImage);
        imageLabel.setBounds(0, 0, 500,600);
        cenPanel.add(imageLabel);
    }
    private void setingCandidate(String name,String checkRank, double num) {

        // 1위 2위 3위 들어올 자리
        if(checkRank.equals("1")) {
            ps.peple(name, num);
            rank="1";
            setCandidate(ps.candidatePercentage,ps.icon , ps.candidateName);
        }else if(checkRank.equals("2")) {
            ps.peple(name, num);
            rank="2";
            setCandidate(ps.candidatePercentage,ps.icon , ps.candidateName);
        }else if(checkRank.equals("3")) {
            ps.peple(name, num);
            rank="3";
            setCandidate(ps.candidatePercentage,ps.icon , ps.candidateName);
        }
    }
    private void setCandidate(double number,ImageIcon img,String name) {
        for(int i=0;i<3;i++) {
            potoJLabel[i] = new JLabel();
            nameJLabel[i] = new JLabel();
            numberJLabel[i] = new JLabel();
        }
        Font font = new Font("맑은 고딕",Font.BOLD,20);
        if(rank.equals("1")) {
            Font fontStr = new Font("맑은 고딕",Font.BOLD,28);
            Font fontNum = new Font("맑은 고딕",Font.BOLD,60);
            nameJLabel[0].setFont(fontStr);
            numberJLabel[0].setFont(fontNum);
            potoJLabel[0].setBounds(20, 130,230,280);
            nameJLabel[0].setBounds(40,420,100,30);
            numberJLabel[0].setBounds(130,450,200,100);
            potoJLabel[0].setIcon(img);
            nameJLabel[0].setText(name);
            numberJLabel[0].setText(number+"%");
            cenPanel.add(potoJLabel[0]);
            cenPanel.add(nameJLabel[0]);
            cenPanel.add(numberJLabel[0]);
        }else if(rank.equals("2")) {
            nameJLabel[1].setFont(font);
            numberJLabel[1].setFont(font);
            potoJLabel[1].setBounds(290, 50, 100, 125);
            nameJLabel[1].setBounds(400, 120, 100, 20);
            numberJLabel[1].setBounds(410, 150, 100, 20);
            potoJLabel[1].setIcon(img);
            nameJLabel[1].setText(name);
            numberJLabel[1].setText(number+"%");
            cenPanel.add(potoJLabel[1]);
            cenPanel.add(nameJLabel[1]);
            cenPanel.add(numberJLabel[1]);
        }else if(rank.equals("3")) {
            nameJLabel[2].setFont(font);
            numberJLabel[2].setFont(font);
            potoJLabel[2].setBounds(290, 200, 100, 125);
            nameJLabel[2].setBounds(400, 270, 100, 20);
            numberJLabel[2].setBounds(410, 300, 100, 20);
            potoJLabel[2].setIcon(img);
            nameJLabel[2].setText(name);
            numberJLabel[2].setText(number+"%");
            cenPanel.add(potoJLabel[2]);
            cenPanel.add(nameJLabel[2]);
            cenPanel.add(numberJLabel[2]);
        }
    }
}
