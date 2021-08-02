package sql;

import java.sql.*;
import java.util.HashMap;


public class SQL_Popularity {

    Connection conn;
    PreparedStatement pst;
    ResultSet resultSet;
    HashMap<String, Integer> hashMap = new HashMap<>();

    public SQL_Popularity(String whose) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");

        String order = "select dates, "+whose+" from linegraph";
        pst = conn.prepareStatement(order);
        resultSet = pst.executeQuery();
        while (resultSet.next()){
            hashMap.put(resultSet.getString(1),resultSet.getInt(2));
        }
        conn.close();
        resultSet.close();
        pst.close();
    }
    public HashMap getHash() {return hashMap;}
}
