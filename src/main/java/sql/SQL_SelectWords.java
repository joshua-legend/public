package sql;

import java.sql.*;
import java.util.ArrayList;


public class SQL_SelectWords {

    Connection conn;
    PreparedStatement pst;
    ResultSet resultSet;
    String text="";

    public SQL_SelectWords(String whose) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");

        String order = "select * from "+whose;
        pst = conn.prepareStatement(order);
        resultSet = pst.executeQuery();
        while (resultSet.next()){
            String word = resultSet.getString(1);
            int times = Integer.parseInt(resultSet.getString(2));
            for(int i=0;i<times;i++) text += word+" ";
        }
        conn.close();
        resultSet.close();
        pst.close();
    }
    public String getText() {return text;}
}
