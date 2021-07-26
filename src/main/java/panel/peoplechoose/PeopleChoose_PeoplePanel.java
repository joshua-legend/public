package panel.peoplechoose;

import activityPanel.PublicMindFrame;
import activityPanel.WordMapPanel;
import buttons.PeopleButton;
import data.Party;
import data.PoliticianData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PeopleChoose_PeoplePanel extends JPanel {

    GridLayout gridLayout = new GridLayout(3,3,10,10);

    PoliticianData data = new PoliticianData();
    PeopleButton peopleButton[] = new PeopleButton[12];

    String names[] = new String[12];
    ArrayList<ArrayList<String>> datas = new ArrayList<>();
    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> second = new ArrayList<>();
    ArrayList<String> third = new ArrayList<>();
    ArrayList<String> fourth = new ArrayList<>();
    ArrayList<String> fifth = new ArrayList<>();
    ArrayList<String> sixth = new ArrayList<>();

    int cnt=0;

    public PeopleChoose_PeoplePanel() {
        Iterator<String> keys = data.map.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            names[cnt] = key;
            divideByParty(key,PoliticianData.map.get(key).getParty());
            peopleButton[cnt]=new PeopleButton(PoliticianData.map.get(key));
            peopleButton[cnt].addActionListener(new ActionButton());
            add(peopleButton[cnt++]);
        }
        datas.add(first);
        datas.add(second);
        datas.add(third);
        datas.add(fourth);
        datas.add(fifth);
        datas.add(sixth);
        Arrays.sort(names);
        setLayout(gridLayout);
        setBounds(0,30,490,650);
    }

    public void sortByName(){
        removeAll();
        for(int i=0;i<names.length;i++){
            peopleButton[i]=new PeopleButton(PoliticianData.map.get(names[i]));
            peopleButton[i].addActionListener(new ActionButton());
            add(peopleButton[i]);
        }
        updateUI();
    }

    public void sortByParty(){
        removeAll();
        for(int i=0;i<datas.size();i++){
            for(int j=0;j<datas.get(i).size();j++){
                peopleButton[i]=new PeopleButton(PoliticianData.map.get(datas.get(i).get(j).toString()));
                peopleButton[i].addActionListener(new ActionButton());
                add(peopleButton[i]);
            }
        }
        updateUI();
    }

    public void divideByParty(String str,Party party){
        switch (party){
            case 더불어민주당:
                this.first.add(str);
                break;
            case 국민의힘:
                this.second.add(str);
                break;
            case 국민의당:
                this.third.add(str);
                break;
            case 정의당:
                this.fourth.add(str);
                break;
            case 국가혁명당:
                this.fifth.add(str);
                break;
            case 무소속:
                this.sixth.add(str);
                break;
        }
    }

    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PeopleButton peopleButton = (PeopleButton)e.getSource();
            try {
                PublicMindFrame.selectActivity(new WordMapPanel(peopleButton.vo));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}
