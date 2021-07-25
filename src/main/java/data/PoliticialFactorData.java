package data;

import javax.swing.*;
import java.util.HashMap;

public class PoliticialFactorData {


    public static HashMap<Integer, PoliticalFactorsVO> map = new HashMap<>();

    public PoliticialFactorData() {
        map.put(1,new PoliticalFactorsVO("코로나",new ImageIcon("img/category/virus.png"), "#c62828"));
        map.put(2,new PoliticalFactorsVO("일자리",new ImageIcon("img/category/labor.png"), "#80deea"));
        map.put(3,new PoliticalFactorsVO("부동산",new ImageIcon("img/category/realestate.png"), "#2196f3"));
        map.put(4,new PoliticalFactorsVO("외교",new ImageIcon("img/category/diplomacy.png"), "#546e7a"));
        map.put(5,new PoliticalFactorsVO("사회이슈",new ImageIcon("img/category/오세훈.png"), "#ffffff"));
        map.put(6,new PoliticalFactorsVO("환경",new ImageIcon("img/category/nature.png"), "#2e7d32"));
        map.put(7,new PoliticalFactorsVO("국방",new ImageIcon("img/category/halmet.png"), "#5d4037"));
        map.put(8,new PoliticalFactorsVO("코인",new ImageIcon("img/category/coin.png"), "#ffee58"));
        map.put(9,new PoliticalFactorsVO("세금",new ImageIcon("img/category/tax.png"), "#ffcdd2"));
    }
}
