package buttons;

import data.PoliticalFactorsVO;

import javax.swing.*;
import java.awt.*;

public class UtilButton extends JButton {

    public UtilButton() {
        setUI(new StyledButtonUI());
    }

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
    public UtilButton(PoliticalFactorsVO vo) {
        setFont(new Font("UhBee ZZIBA",Font.PLAIN,20));
        setText(vo.getName());
        setBackground(Color.decode("#ffffff"));
        setForeground(Color.decode(vo.getRgb()));
        setUI(new StyledButtonUI());
    }
    public UtilButton(String text) {
        setFont(new Font("UhBee ZZIBA",Font.PLAIN,20));
        setText(text);
        setBackground(Color.decode("#90caf9"));
        setForeground(Color.decode("#424242"));
        setUI(new StyledButtonUI());
    }
}
