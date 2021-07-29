package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class SQL_OrderByWords {

    Connection conn;
    PreparedStatement pst;
    ResultSet resultSet;
    ArrayList<String> list = new ArrayList<>();
    HashMap<String,String> data = new HashMap<>();
    String order;

    public SQL_OrderByWords(String whose,String sqlStatement) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");

        switch (sqlStatement){
            case "desc": order = "SELECT word,count FROM "+whose+" ORDER BY count DESC FETCH NEXT 10 ROWS ONLY"; break;
            case "best": order = "SELECT word FROM "+whose+" where degree = 1"; break;
            case "worst": order = "SELECT word FROM "+whose+" where degree = 3"; break;
        }

        pst = conn.prepareStatement(order);
        resultSet = pst.executeQuery();

        if(sqlStatement=="desc")
            while (resultSet.next()){ data.put(resultSet.getString(1),resultSet.getString(2)); }
        else
            while (resultSet.next()){ list.add(resultSet.getString(1)); }
        conn.close();
        resultSet.close();
        pst.close();
    }
    public HashMap getText() {return data;}
    public ArrayList getList() {return list;}
}
