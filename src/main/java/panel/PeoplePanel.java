package panel;

import javax.swing.*;
import java.awt.*;

public class PeoplePanel extends JPanel {

    JLabel image = new JLabel();
    JLabel keyword = new JLabel("234");
    JLabel history = new JLabel("국민의힘 대표\n");

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    public PeoplePanel() {

        constraints.weightx =1;
        constraints.weighty =1;
        constraints.fill = GridBagConstraints.BOTH;

        controlConstraints(0,0,1,2);
        layout.setConstraints(image,constraints);
        image.setIcon(new ImageIcon("img/leejunsukPeople.png"));
        image.setHorizontalAlignment(JLabel.CENTER);
        add(image);

        controlConstraints(1,0,1,1);
        keyword.setHorizontalAlignment(JLabel.CENTER);
        layout.setConstraints(keyword,constraints);
        add(keyword);

        controlConstraints(1,1,1,1);
        history.setHorizontalAlignment(JLabel.CENTER);
        layout.setConstraints(history,constraints);
        add(history);

        setPreferredSize(new Dimension(500,200));
        setLayout(layout);
    }

    void controlConstraints(int x,int y,int width,int height){
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
    }

}
