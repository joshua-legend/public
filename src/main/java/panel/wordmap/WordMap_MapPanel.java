package panel.wordmap;


import buttons.UtilButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WordMap_MapPanel extends JPanel {
    private int i;
    public WordMap_MapPanel(){
        btnPanel();
        setBounds(0,200,500,480);
    }
    private void btnPanel() {
        setBackground(Color.WHITE);
        UtilButton button[] = new UtilButton[310];
        for(i=0;i<button.length;i++) {
            button[i] = new UtilButton();
            button[i].setFont(new Font("맑은 고딕",Font.PLAIN,10));
            button[i].setBackground(Color.WHITE);

            button[i].setPreferredSize(new Dimension(20,20));

            btnSetVisble(button);
            btnEventSetArea(button);
            btnEventSetCity(button);
            setLayout(new GridLayout(0,16,7,6));
            add(button[i]);
        }
    }
    private void btnSetVisble(UtilButton[] button) {
        if(i>=0 && i<9 || i>=10 && i<21) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=27 && i<36 || i>=44 && i<51) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=60 && i<67 || i>=77 && i<84) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=93 && i<99 || i>=110 && i<114) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=126 && i<132 || i>=142 && i<148) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=157 && i<164 || i>=174 && i<181) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=190 && i<196 || i>=206 && i<211) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=221 && i<226 || i>=234 && i<243 || i>=247 && i<249) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=251 && i<259 || i>=261 && i<262 || i>=263 && i<274) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
        if(i>=276 && i<277 || i>=278 && i<307) {
            button[i].setBorderPainted(false);
            button[i].setEnabled(false);
            button[i].setVisible(false);
        }
    }
    private void btnEventSetArea(UtilButton[] button) {
        int[] gyeonggi = {21,36,37,38,51,52,53,54,70,71,84,85,86,87,101,102};
        int[] northChungcheong = {103,104,105,106,119,120,135,151,167};
        int[] southChungcheong = {99,100,114,115,116,117,118,132,133,148,149,164};
        int[] northJeolla = {165,166,181,182,183,196,197,198,214};
        int[] southJeolla = {211,212,213,226,227,228,229,230,231,243,244,245,246,259,260,262,274,275,277};
        int[] gangwon = {9,22,23,24,25,26,39,40,41,42,43,55,56,57,58,59,72,73,74,75,76,88,89,90,91,92};
        int[] northGyeongsang = {107,108,109,121,122,123,124,125,136,137,138,139,140,141,152,153,154,155,156,168,169,170,171,172,173,185,187,188,189,203,204};
        int[] southGyeongsang = {184,199,200,201,202,215,216,217,218,219,232,233,249,250};

        String gyeonggiStr = "경기도";
        String northChungcheongStr = "충청북도";
        String southChungcheongStr = "충청남도";
        String northJeollaStr = "전라북도";
        String southJeollaStr = "전라남도";
        String gangwonStr = "강원도";
        String northGyeongsangStr = "경상북도";
        String southGyeongsangStr = "경상남도";

        eventSetArray(button,gyeonggi,gyeonggiStr);
        eventSetArray(button,northChungcheong,northChungcheongStr);
        eventSetArray(button,southChungcheong,southChungcheongStr);
        eventSetArray(button,northJeolla,northJeollaStr);
        eventSetArray(button,southJeolla,southJeollaStr);
        eventSetArray(button,gangwon,gangwonStr);
        eventSetArray(button,northGyeongsang,northGyeongsangStr);
        eventSetArray(button,southGyeongsang,southGyeongsangStr);
    }
    private void btnEventSetCity(UtilButton[] button) {
        int seoul = 69;
        int sejong= 134;
        int daejeon= 150;
        int daegu= 186;
        int ulsan= 205;
        int busan= 220;
        String seoulStr="서울시";
        String sejongStr="세종시";
        String daejeonStr="대전광역시";
        String daeguStr="대구광역시";
        String ulsanStr="울산광역시";
        String busanStr="부산광역시";
        eventSetInt(button,seoul,seoulStr);
        eventSetInt(button,sejong,sejongStr);
        eventSetInt(button,daejeon,daejeonStr);
        eventSetInt(button,daegu,daeguStr);
        eventSetInt(button,ulsan,ulsanStr);
        eventSetInt(button,busan,busanStr);

        int[] incheon= {67,68};
        int[] jeju= {307,308,309};
        String incheonStr = "인천광역시";
        String jejuStr = "제주도";
        eventSetArray(button,incheon,incheonStr);
        eventSetArray(button,jeju,jejuStr);
    }
    private void eventSetInt(UtilButton[] button,int city,String cityStr) {

        if(i==city) {
            button[city].setToolTipText(cityStr);
            button[city].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    button[city].setBackground(Color.WHITE);

                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    intColor(button[city],cityStr);
                }
            });
            button[city].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(cityStr=="서울시") {
                        System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                    }else if(cityStr=="세종시") {
                        System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                    }else if(cityStr=="대전광역시") {
                        System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                    }else if(cityStr=="대구광역시") {
                        System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                    }else if(cityStr=="울산광역시") {
                        System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                    }else if(cityStr=="부산광역시") {
                        System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                    }
                }
            });

        }
    }
    private void eventSetArray(UtilButton[] button,int[] city,String cityStr) {
        for(int b = 0; b<city.length;b++) {
            if(i==city[b]) {
                button[city[b]].setToolTipText(cityStr);
                button[city[b]].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseExited(MouseEvent e) {
                        for(int b = 0; b<city.length;b++) {
                            button[city[b]].setBackground(Color.WHITE);

                        };
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        for(int b = 0; b<city.length;b++) {
                            areaColor(button[city[b]],cityStr);
                        };
                    }
                });
                button[city[b]].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cityStr=="인천광역시") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="제주도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="경기도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="충청북도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="충청남도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="전라북도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="전라남도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="강원도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="경상북도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }else if(cityStr=="경상남도") {
                            System.out.println("테스트 출력 --------->>> "+cityStr+" 선택");
                        }

                    }
                });

            }
        }
    }
    private void intColor(UtilButton button,String cityStr) {
        if(cityStr=="서울시") {
            button.setBackground(new Color(174,25,50));
        }else if(cityStr=="세종시") {
            button.setBackground(new Color(185, 221, 250));
        }else if(cityStr=="대전광역시") {
            button.setBackground(new Color(210, 250, 221));
        }else if(cityStr=="대구광역시") {
            button.setBackground(new Color(69,121,189));
        }else if(cityStr=="울산광역시") {
            button.setBackground(new Color(9, 218, 146));
        }else if(cityStr=="부산광역시") {
            button.setBackground(new Color(222, 239, 255));
        }
    }
    private void areaColor(UtilButton button, String cityStr) {
        if(cityStr=="인천광역시") {
            button.setBackground(new Color(0, 178, 169));
        }else if(cityStr=="제주도") {
            button.setBackground(new Color(245, 142, 7));
        }else if(cityStr=="경기도") {
            button.setBackground(new Color(22, 65, 148));
        }else if(cityStr=="충청북도") {
            button.setBackground(new Color(145, 237, 133));
        }else if(cityStr=="충청남도") {
            button.setBackground(new Color(203, 174, 245));
        }else if(cityStr=="전라북도") {
            button.setBackground(new Color(100, 167, 11));
        }else if(cityStr=="전라남도") {
            button.setBackground(new Color(247, 209, 23));
        }else if(cityStr=="강원도") {
            button.setBackground(new Color(214, 210, 196));
        }else if(cityStr=="경상북도") {
            button.setBackground(new Color(155, 228, 250));
        }else if(cityStr=="경상남도") {
            button.setBackground(new Color(250, 197, 185));
        }
    }

}