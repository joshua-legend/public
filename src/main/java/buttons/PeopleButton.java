package buttons;

import data.PoliticianVO;

import javax.swing.*;
import java.awt.*;

public class PeopleButton extends JButton {

    BorderLayout layout = new BorderLayout();

    public PoliticianVO vo;
    JLabel imageLabel = new JLabel();
    JLabel nameLabel = new JLabel();

    public PeopleButton(PoliticianVO politicianVO) {

        vo = politicianVO;
        setLayout(layout);
        setBackground(Color.decode(politicianVO.getRgb()));
        setUI(new StyledButtonUI());

        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setIcon(politicianVO.getImage());
        add(BorderLayout.CENTER,imageLabel);

        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setText(politicianVO.getName());
        nameLabel.setFont(new Font("UhBee ZZIBA",Font.PLAIN,25));
        nameLabel.setForeground(Color.WHITE);
        add(BorderLayout.SOUTH,nameLabel);
    }
}
