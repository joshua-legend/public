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
    HashMap<String,Integer> area = new HashMap<>();

    String order;
    int postiveNum,negativeNum;

    public SQL_OrderByWords(String whose,String sqlStatement) throws SQLException {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        conn = DriverManager.getConnection(url,"c##Class01","Class01");

        String name = whose;
        String name_ne = whose + "_NA";
        String name_po = whose + "_PO";
        whose += "_PO";
        switch (sqlStatement){
            case "area": order = "SELECT area,interest FROM area where whose = "+"'"+name+"'"; break;
            case "desc": order = "SELECT word,count FROM "+whose+" ORDER BY count DESC FETCH NEXT 10 ROWS ONLY"; break;
            case "best": order = "SELECT word FROM "+name_po+" where degree = 1"; break;
            case "worst": order = "SELECT word FROM "+name_ne+" where degree = 3"; break;
            case "total_positive" : order = "select sum(count) from "+ name_po; break;
            case "total_negative" : order = "select sum(count) from "+ name_ne; break;
        }

        pst = conn.prepareStatement(order);
        resultSet = pst.executeQuery();

        if(sqlStatement=="desc")
            while (resultSet.next()){ data.put(resultSet.getString(1),resultSet.getString(2)); }
        else if(sqlStatement=="area")
            while (resultSet.next()){ area.put(resultSet.getString(1),resultSet.getInt(2)); }
        else if(sqlStatement=="total_positive")
            while (resultSet.next()){ postiveNum = resultSet.getInt(1); }
        else if(sqlStatement=="total_negative")
            while (resultSet.next()){ negativeNum = resultSet.getInt(1); }
        else
            while (resultSet.next()){ list.add(resultSet.getString(1)); }
        conn.close();
        resultSet.close();
        pst.close();
    }
    public HashMap getText() {return data;}
    public HashMap getArea() {return area;}
    public int getPostiveNum() {return postiveNum;}
    public int getNegativeNum() { return negativeNum;}
    public ArrayList getList() {return list;}
}
