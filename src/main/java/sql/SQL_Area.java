package sql;

import java.sql.*;
import java.util.HashMap;


public class SQL_Area {

    Connection conn;
    PreparedStatement pst,pst1;
    ResultSet resultSet,resultSet1;
    String text="";
    HashMap<String,Integer> hashMap = new HashMap<>();

    public SQL_Area(HashMap peopleMap,String area) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");


        String order = "select whose,interest from area where area ="+ "'"+area+"'";
        pst = conn.prepareStatement(order);
        resultSet = pst.executeQuery();

        while (resultSet.next()){
            int percent = (int) peopleMap.get(resultSet.getString(1));
            hashMap.put(resultSet.getString(1),percent+resultSet.getInt(2)/10-5);
        }

        //todo
        String order1 = "select population from population where area = "+"'"+area+"'";

        pst = conn.prepareStatement(order1);
        resultSet = pst.executeQuery();

        while (resultSet.next()){
            hashMap.put(resultSet.getString(1),resultSet.getInt(2)/10-5);
        }

        conn.close();
        resultSet.close();
        pst.close();
    }
    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }
}
