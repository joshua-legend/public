package activityPanel;

import javax.swing.*;
import java.util.HashMap;

public class PoliticianData {

    //    안철수,유승민,윤석열,이낙연,이재명,이준석,정세균,추미애,홍준표

    static HashMap<String,PoliticianVO> map = new HashMap<>();

    public PoliticianData() {
        map.put("이준석",new PoliticianVO("이준석",new ImageIcon("img/people/leejunsuk.png"),Color.국민의힘.getColor()));
    }

}
