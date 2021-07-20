package button;

import javax.swing.*;
import java.awt.*;

public class PeopleButton extends JButton {

    JLabel nameLable = new JLabel();

    public PeopleButton(String name,ImageIcon imageIcon, String backRGB, String foreRGB, Rectangle rectangle) {
        setBorder(BorderFactory.createEmptyBorder(10 , 10, 10 , 10));
        setBackground(Color.decode(backRGB));
        setForeground(Color.decode(foreRGB));
        setUI(new StyledButtonUI(imageIcon));
//        setBounds(rectangle);
        nameLable.setText(name);
        nameLable.setFont(new Font("UhBee ZZIBA",Font.PLAIN,15));
        nameLable.setForeground(Color.WHITE);
//        nameLable.setBounds(10,5,15,15);
        add(nameLable);
    }
}
