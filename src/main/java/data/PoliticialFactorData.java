package data;

import javax.swing.*;
import java.util.HashMap;

public class PoliticialFactorData {


    public static HashMap<Integer, PoliticalFactorsVO> map = new HashMap<>();

    public PoliticialFactorData() {
        map.put(1,new PoliticalFactorsVO("재 정",new ImageIcon("img/category/tax.png"), "#ffcdd2"));
        map.put(2,new PoliticalFactorsVO("교 육",new ImageIcon("img/category/education.png"), "#d1c4e9"));
        map.put(3,new PoliticalFactorsVO("외 교",new ImageIcon("img/category/diplomacy.png"), "#bbdefb"));
        map.put(4,new PoliticalFactorsVO("국 방",new ImageIcon("img/category/halmet.png"), "#b2dfdb"));
        map.put(5,new PoliticalFactorsVO("보건복지",new ImageIcon("img/category/virus.png"), "#E48F3A"));
        map.put(6,new PoliticalFactorsVO("환 경",new ImageIcon("img/category/nature.png"), "#aabb97"));
        map.put(7,new PoliticalFactorsVO("국토교통",new ImageIcon("img/category/subway.png"), "#cfd8dc"));
        map.put(8,new PoliticalFactorsVO("고용노동",new ImageIcon("img/category/labor.png"), "#d7ccc8"));
        map.put(9,new PoliticalFactorsVO("행정안전",new ImageIcon("img/category/police.png"), "#ffccbc"));
    }
}
