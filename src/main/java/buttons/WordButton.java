package buttons;

import data.PoliticalFactorsVO;

import javax.swing.*;
import java.awt.*;

public class WordButton extends JButton {

    BorderLayout layout = new BorderLayout();

    public PoliticalFactorsVO vo;
    JLabel imageLabel = new JLabel();
    JLabel nameLabel = new JLabel();

    public WordButton(PoliticalFactorsVO vo) {
        this.vo = vo;
        setLayout(layout);
        setBackground(Color.decode(vo.getRgb()));
        setUI(new StyledButtonUI());

        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setIcon(vo.getImage());
        add(BorderLayout.CENTER,imageLabel);

        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setText(vo.getName());
        nameLabel.setFont(new Font("UhBee ZZIBA",Font.PLAIN,25));
        nameLabel.setForeground(Color.WHITE);
        add(BorderLayout.SOUTH,nameLabel);
    }

    public String getVoTitle() {
        return vo.getName();
    }
}
