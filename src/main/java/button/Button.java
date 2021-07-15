package button;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(String str,String backRGB,String foreRGB) {
        setFont(new Font("휴먼매직체",Font.PLAIN,20));
        setText(str);
        setBackground(Color.decode(backRGB));
        setForeground(Color.decode(foreRGB));
        setUI(new StyledButtonUI());
        setBounds(100,500,300,60);
    }
}
