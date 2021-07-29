package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class SQL_OrderByWords {

    Connection conn;
    PreparedStatement pst;
    ResultSet resultSet;
    ArrayList<ArrayList<String>> datas = new ArrayList<>();
    HashMap<String,String> data = new HashMap<>();

    public SQL_OrderByWords(String whose) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");
        String order = "SELECT word,count FROM "+whose+" ORDER BY count DESC FETCH NEXT 10 ROWS ONLY";
        pst = conn.prepareStatement(order);
        resultSet = pst.executeQuery();
        while (resultSet.next()){
            data.put(resultSet.getString(1),resultSet.getString(2));
        }
        conn.close();
        resultSet.close();
        pst.close();
    }
    public HashMap getText() {return data;}
}
