package simulation;

import sql.SQL_Area;
import sql.SQL_Math;

import java.sql.SQLException;
import java.util.HashMap;

public class SimulationCar {
    private int totalPopulation = 51672400;
    String name;
    double persent;
    static HashMap<String,Double> listHundred = new HashMap<String,Double>();
    public SimulationCar() throws SQLException {

    }
    public void test(int google,int view,int sub,int ratio) throws SQLException {
        HashMap percent_foreach_Hashmap = new SQL_Math(google,view,sub,ratio).getHashMap();
        System.out.println(percent_foreach_Hashmap);
        HashMap <String, HashMap> totalHashmap = new SQL_Area(percent_foreach_Hashmap).getHashMap();
        System.out.println(totalHashmap);
        HashMap <String, Integer>  rankHashMap = new SQL_Area(percent_foreach_Hashmap).getRankHashMap();
        System.out.println(rankHashMap);
        for(String key : rankHashMap.keySet()){
            name = key;
            persent = Math.round((double) rankHashMap.get(key)/totalPopulation*100);
            listHundred.put(key,persent);
        }
    }
}
