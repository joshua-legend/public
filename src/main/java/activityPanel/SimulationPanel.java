package activityPanel;

import sql.SQL_Area;
import sql.SQL_Math;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;

public class SimulationPanel extends JPanel {


    private int totalPopulation = 51672400;

    public SimulationPanel() throws SQLException {
        test(4,4,2,0);
    }

    private void test(int google,int view,int sub,int ratio) throws SQLException {
        HashMap percent_foreach_Hashmap = new SQL_Math(google,view,sub,ratio).getHashMap();
        System.out.println(percent_foreach_Hashmap);
        HashMap totalHashmap = new SQL_Area(percent_foreach_Hashmap).getHashMap();
        System.out.println(totalHashmap);
        HashMap <String, Integer>  rankHashMap = new SQL_Area(percent_foreach_Hashmap).getRankHashMap();
        System.out.println(rankHashMap);
        for( String key : rankHashMap.keySet() ){
            System.out.println(Math.round((double) rankHashMap.get(key)/totalPopulation*100));
        }
    }
}
