package button;

import activityPanel.PoliticianVO;

import javax.swing.*;
import java.awt.*;

public class PeopleButton extends JButton {

    JLabel nameLable = new JLabel();

    public PeopleButton(PoliticianVO politicianVO) {
        setBorder(BorderFactory.createEmptyBorder(10 , 10, 10 , 10));
        setBackground(Color.decode(politicianVO.getRgb()));
        setForeground(Color.decode("#e1f5fe"));
        setUI(new StyledButtonUI(politicianVO.getImage()));
        nameLable.setText(politicianVO.getName());
        nameLable.setFont(new Font("UhBee ZZIBA",Font.PLAIN,15));
        nameLable.setForeground(Color.WHITE);
        add(nameLable);
    }
}
