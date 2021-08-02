package panel.candidate;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    JLabel image = new JLabel();
    JLabel keyword = new JLabel();
    JLabel history = new JLabel();

    Font font = new Font("UhBee ZZIBA",Font.PLAIN,20);

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    public ProfilePanel(ImageIcon imageIcon,String key, String his) {

        this.keyword.setText(key);
        this.history.setText(his);
        constraints.weightx =1;
        constraints.weighty =1;
        constraints.fill = GridBagConstraints.BOTH;

        controlConstraints(0,0,1,2);
        layout.setConstraints(image,constraints);
        image.setIcon(imageIcon);
        image.setHorizontalAlignment(JLabel.CENTER);
        add(image);

        controlConstraints(1,0,1,1);
        keyword.setHorizontalAlignment(JLabel.CENTER);
        keyword.setFont(font);
        layout.setConstraints(keyword,constraints);
        add(keyword);

        controlConstraints(1,1,1,1);
        history.setHorizontalAlignment(JLabel.CENTER);
        history.setFont(font);
        layout.setConstraints(history,constraints);
        add(history);

        setBounds(0,30,525,120);
        setLayout(layout);
    }

    void controlConstraints(int x,int y,int width,int height){
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
    }

}
