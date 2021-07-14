import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {

    JLabel titleJlabel = new JLabel("Presidential Predictor ");
    Font font = new Font("orange juice",Font.ITALIC,55);

    Box createHorizontalBox = Box.createHorizontalBox();
    BoxLayout boxLayout = new BoxLayout(this,BoxLayout.Y_AXIS);


    Panel(String str) {
        setOpaque(false);
        setLayout(boxLayout);

        switch (str){
            case "empty":
                createHorizontalBox.add(Box.createHorizontalStrut(0));
                createHorizontalBox.add(new JLabel(" "));
                add(createHorizontalBox);
                break;
            case "title":
                createHorizontalBox.add(Box.createHorizontalStrut(1));
                titleJlabel.setFont(font);
                createHorizontalBox.add(titleJlabel);
                add(createHorizontalBox);
                break;
            case "image":
                createHorizontalBox.add(Box.createHorizontalStrut(1));
                ImageIcon icon = new ImageIcon("img/오늘.png");
                JLabel a = new JLabel(icon);
                createHorizontalBox.add(a);
                add(createHorizontalBox);
                break;
            case "start":
                createHorizontalBox.add(Box.createVerticalStrut(1));
//                RoundButton asd = new RoundButton();
//                createHorizontalBox.add(asd);
                JButton button = new JButton("Button #");
                button.setBackground(new Color(0x2dce98));
                button.setForeground(Color.white);
                // customize the button with your own look
                button.setUI(new StyledButtonUI());
                createHorizontalBox.add(button);
                createHorizontalBox.add(Box.createVerticalStrut(1));
                add(createHorizontalBox);
                break;
        }
    }

}


