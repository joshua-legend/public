package panel;

import buttons.UtilButton;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints gcon = new GridBagConstraints();

    public UtilButton backButton = new UtilButton("<-","#64b5f6","#ffffff");
    JLabel nothingLabel1 = new JLabel(" ");
    JLabel titleLabel = new JLabel();
    JLabel nothingLabel2 = new JLabel(" ");
    UtilButton backButton1 = new UtilButton(" ","#64b5f6","#ffffff");

    Font font = new Font("맑은 고딕",Font.PLAIN,15);

    public TopPanel(String panelName) {
        setLayout(grid);

        controlConstraints(0,0,1,1);
        grid.setConstraints(backButton,gcon);
        add(backButton);

        controlConstraints(1,0,1,1);
        nothingLabel1.setBackground(Color.decode("#64b5f6"));
        nothingLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        grid.setConstraints(nothingLabel1,gcon);
        add(nothingLabel1);

        controlConstraints(2,0,1,1);
        titleLabel.setText(panelName);
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        grid.setConstraints(titleLabel,gcon);
        add(titleLabel);

        controlConstraints(3,0,1,1);
        nothingLabel2.setBackground(Color.decode("#64b5f6"));
        nothingLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        grid.setConstraints(nothingLabel2,gcon);
        add(nothingLabel2);

        controlConstraints(5,0,1,1);
        backButton1.setBackground(Color.decode("#64b5f6"));
        grid.setConstraints(backButton1,gcon);
        add(backButton1);

        setBounds(0,0,500,30);
    }

    void controlConstraints(int x,int y,int width,int height){
        gcon.weightx =1;
        gcon.weighty =1;
        gcon.fill = GridBagConstraints.BOTH;
        gcon.gridx = x;
        gcon.gridy = y;
        gcon.gridwidth = width;
        gcon.gridheight = height;
    }
}
