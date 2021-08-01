package sql;

import java.sql.*;
import java.util.HashMap;


public class SQL_Math {

    Connection conn;
    PreparedStatement pst,pst1;
    ResultSet resultSet,resultSet1;
    String text="";
    HashMap<String,Integer> hashMap = new HashMap<>();
    HashMap<String,Integer> hashMapfinalData = new HashMap<>();

    public SQL_Math(int google,int views,int sub,int ratio) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");

        String order = "select whose,google,youtube_views,subscribe,ratio from interest";
        pst = conn.prepareStatement(order);
        pst1 = conn.prepareStatement(order);
        resultSet = pst.executeQuery();
        resultSet1 = pst1.executeQuery();

        int total=0;
        while (resultSet.next()){
            String word = resultSet.getString(1);
            int googleTotal = resultSet.getInt(2) * google;
            int viewsTotal = resultSet.getInt(3) * views;
            int subTotal = resultSet.getInt(4) * sub;
            int ratioTotal = resultSet.getInt(5) * ratio;
            total+=googleTotal+viewsTotal+subTotal+ratioTotal;
            hashMap.put(word,googleTotal+viewsTotal+subTotal+ratioTotal);
        }

        while (resultSet1.next()){
            String word = resultSet1.getString(1);
            int sum = hashMap.get(word);
            hashMapfinalData.put(word,sum*100/total);
        }
        conn.close();
        resultSet.close();
        pst.close();
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMapfinalData;
    }
}
