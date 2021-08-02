package simulation;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GetPercentage extends JPanel {
    public int[] percent;
    public JButton btn;

    private JLabel nameLabel;
    private JLabel explanationLabel;
    private JLabel[] labelQuestion;
    private JTextField[] percentage;
    private JPanel panelCenter;
    private JPanel backgroundImage;
    private Font font;
    private int number;
    public boolean check;
    public GetPercentage() {
        setPanel();
    }
    void getPercent() {
        try {
            percent = new int[4];
            SimulationCar sc = new SimulationCar();
            for(int i=0;i<percent.length;i++) {
                if(!percentage[i].getText().equals("")) {
                    percent[i]= Integer.parseInt(percentage[i].getText());
                    number+=percent[i];
                }
            }
            if(number==100) {
                sc.test(percent[0],percent[1],percent[2],percent[3]);
                check = true;
            }else {
                check = false;
                number=0;
                JOptionPane.showMessageDialog(this, "100%가 아닙니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void setPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        titleLabel();
        explanationLabel();
        centerPanelSeting();
        buttonSeting();
        inputSeting();
        setBackgroundImg();
        add(backgroundImage);
    }
    private void titleLabel() {
        font = new Font("맑은 고딕",Font.PLAIN,25);
        UIManager.put("OptionPane.messageFont",font);
        nameLabel = new JLabel();
        nameLabel.setFont(font);
        nameLabel.setBounds(50, 10, 400, 100);
        nameLabel.setText("각 항목의 퍼센트를 입력해주세요");
        add(nameLabel);
    }
    private void explanationLabel() {
        font = new Font("맑은 고딕",Font.PLAIN,20);
        explanationLabel = new JLabel();
        explanationLabel.setFont(font);
        explanationLabel.setBounds(70, 100, 400, 100);
        explanationLabel.setText("총합이 100%가 되도록 적어주세요");
        add(explanationLabel);
    }
    private void centerPanelSeting() {
        panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCenter.setBounds(60, 180, 400, 500);
        panelCenter.setOpaque(false);
        add(panelCenter);
    }
    private void inputSeting() {
        font = new Font("맑은 고딕",Font.BOLD,20);
        percentage = new JTextField[4];
        labelQuestion = new JLabel[4];
        for(int i=0;i<percentage.length;i++) {
            percentage[i] = new JTextField(20);
            labelQuestion[i] = new JLabel();
            percentage[i].setFont(font);
            labelQuestion[i].setFont(font);
            panelCenter.add(labelQuestion[i]);
            panelCenter.add(percentage[i]);
        }
        labelQuestion[0].setText("구글 트렌드의 비율");
        labelQuestion[1].setText("유튜브 조회수의 비율");
        labelQuestion[2].setText("유튜브 구독자수의 비율");
        labelQuestion[3].setText("긍정어와 부정어 데이터의 비율");
    }
    private void buttonSeting(){
        btn = new JButton("전송");
        btn.setBackground(Color.WHITE);
        btn.setBounds(270, 600, 200, 50);
        btn.setFont(font);
        add(btn);
    }
    private void setBackgroundImg() {
        backgroundImage = new JPanel();
        ImageIcon icon = new ImageIcon("img/KoreaBlr.png");
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(icon);
        imgLabel.setBounds(0, 0, 500, 676);
        backgroundImage.setLayout(null);
        backgroundImage.add(imgLabel);
        backgroundImage.setBounds(0, 0, 500, 676);
    }
}