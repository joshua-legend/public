package sql;

import data.PoliticianData;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class SQL_Area {

    Connection conn;
    PreparedStatement pst,pst1;
    ResultSet resultSet,resultPopulation;
    PoliticianData data;
    String[] area = {
            "제주특별자치도",
            "서울특별시",
            "인천광역시",
            "강원도",
            "대전광역시",
            "울산광역시",
            "대구광역시",
            "부산광역시",
            "경상북도",
            "경상남도",
            "경기도",
            "충청남도",
            "전라북도",
            "광주광역시",
            "전라남도",
            "충청북도"
    };

    HashMap<String,HashMap> totalHashMap = new HashMap<>();
    HashMap<String,Integer> rankHashMap = new HashMap<>();

    public SQL_Area(HashMap peopleMap) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");


        int i=0;
        while(i<16){
            HashMap<String,Integer> hashMap = new HashMap<>();
            String key = area[i++];
            String order = "select whose,interest from area where area ="+"'"+key+"'";
            String populationOrder = "select population from population where area= "+"'"+key+"'";
            pst = conn.prepareStatement(order);
            pst1 = conn.prepareStatement(populationOrder);
            resultSet = pst.executeQuery();
            resultPopulation = pst1.executeQuery();
            resultPopulation.next();
            int population = resultPopulation.getInt(1);
            while (resultSet.next()){
                int weight = ((resultSet.getInt(2)+5)/10)-5;
                int origin = (int) peopleMap.get(resultSet.getString(1));
                int result = (int) Math.round(population * (double)(origin+weight)/100);
                if(result<0) result=0;
                hashMap.put(resultSet.getString(1),result);

                if(!rankHashMap.containsKey(resultSet.getString(1)))
                    rankHashMap.put(resultSet.getString(1),result);
                else
                    rankHashMap.put(resultSet.getString(1),rankHashMap.get(resultSet.getString(1))+result);
            }
            totalHashMap.put(key,hashMap);
        }


        conn.close();
        resultSet.close();
        pst.close();
    }
    public HashMap<String, HashMap> getHashMap() {
        return totalHashMap;
    }
    public HashMap<String, Integer> getRankHashMap() {
        return rankHashMap;
    }

}
