package button;

import javax.swing.*;
import java.awt.*;

public class UtilButton extends JButton {

    public UtilButton(String str, String backRGB, String foreRGB) {
        setFont(new Font("UhBee ZZIBA",Font.PLAIN,20));
        setText(str);
        setBackground(Color.decode(backRGB));
        setForeground(Color.decode(foreRGB));
        setUI(new StyledButtonUI());
    }
    public UtilButton(String str, String backRGB, String foreRGB,Rectangle rectangle) {
        setFont(new Font("UhBee ZZIBA",Font.PLAIN,20));
        setText(str);
        setBackground(Color.decode(backRGB));
        setForeground(Color.decode(foreRGB));
        setUI(new StyledButtonUI());
        setBounds(rectangle);
    }
}
