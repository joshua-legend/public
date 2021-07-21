package activityPanel;

import javax.swing.*;

public class PublicMindFrame extends JFrame {


    static PublicMindFrame main;
    static final int WIDTH = 510;
    static final int HEIGHT = 720;

    static JPanel nowPanel;
    static OpeningImagePanel openingImagePanel = new OpeningImagePanel();
    static PeopleChoosePanel peopleChoosePanel = new PeopleChoosePanel();

    PublicMindFrame(){
        init();
        setVisible(true);
        setTitle("Public Mind");
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    void init(){
        add(openingImagePanel);
        nowPanel = openingImagePanel;
    }

    static void selectActivity(JPanel selectedPanel){
        main.remove(nowPanel);
        nowPanel = selectedPanel;
        main.add(selectedPanel);
        main.revalidate();
        main.repaint();
    }

    public static void main(String[] args) {
        main = new PublicMindFrame();
    }
}