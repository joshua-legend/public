package panel.candidate.sns;

import sql.SQL_OrderByWords;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SNSTop7Panel extends JPanel {

    Image mainImage = new ImageIcon("img/background/right.png").getImage();

    SQL_OrderByWords sql_orderByWords_best,sql_orderByWords_worst;

    JPanel top7Panel = new JPanel(new GridLayout(1,2));
    GoodPanel goodPanel = new GoodPanel();
    BadPanel badPanel = new BadPanel();
    JLabel bestLabel = new JLabel("긍정어 TOP7");
    JLabel worstLabel = new JLabel("부정어 TOP7");

    Font font = new Font("UhBee ZZIBA",Font.BOLD,30);

    ArrayList bestList;
    ArrayList worstList;



    public SNSTop7Panel(String whose) throws SQLException {

        setLayout(new GridLayout(1,1));

        bestLabel.setFont(font);
        worstLabel.setFont(font);
        bestLabel.setForeground(Color.decode("#ff77a9"));
        worstLabel.setForeground(Color.decode("#4fc3f7"));
        bestLabel.setHorizontalAlignment(JLabel.CENTER);
        worstLabel.setHorizontalAlignment(JLabel.CENTER);

        goodPanel.setLayout(new GridLayout(8,1));
        badPanel.setLayout(new GridLayout(8,1));
        goodPanel.add(bestLabel);
        badPanel.add(worstLabel);

        goodPanel.setBackground(Color.RED);

        sql_orderByWords_best = new SQL_OrderByWords(whose,"best");
        sql_orderByWords_worst=new SQL_OrderByWords(whose,"worst");
        bestList = sql_orderByWords_best.getList();
        worstList = sql_orderByWords_worst.getList();

        for(int i=0;i<bestList.size();i++){
            JLabel good = new JLabel(bestList.get(i).toString());
            JLabel bad = new JLabel(worstList.get(i).toString());
            good.setHorizontalAlignment(JLabel.CENTER);
            bad.setHorizontalAlignment(JLabel.CENTER);
            good.setOpaque(false);
            bad.setOpaque(false);
            good.setFont(font);
            bad.setFont(font);
            good.setForeground(Color.decode("#ff77a9"));
            bad.setForeground(Color.decode("#4fc3f7"));
            goodPanel.add(good);
            badPanel.add(bad);
        }
        top7Panel.add(goodPanel);
        top7Panel.add(badPanel);
        add(top7Panel);
        setBounds(0,25,480,420);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(mainImage, 0, 0, this);
    }
}
