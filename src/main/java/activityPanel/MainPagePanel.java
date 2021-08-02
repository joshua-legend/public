package activityPanel;

import simulation.SimulationPanelMain;
import simulation.SimulationResultFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class MainPagePanel extends JPanel {

    Image mainImage = new ImageIcon("img/background/mainpagebackground.png").getImage();
    public static SimulationPanelMain simulationPanelMain;

    public MainPagePanel() {
        setLayout(null);
        addMouseListener(new Mouse());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mainImage, 0, 0, this);
    }

    class Mouse extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(e.getX()>265 && e.getX()<465 && e.getY()>360 && e.getY()<490){
                PublicMindFrame.selectActivity(new PeopleChoosePanel());
            }
            if(e.getX()>65 && e.getX()<265 && e.getY()>360 && e.getY()<490){
                simulationPanelMain = new SimulationPanelMain();

            }
        }
    }
}
