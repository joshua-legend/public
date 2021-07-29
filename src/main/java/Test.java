import java.sql.*;
import java.util.ArrayList;


public class Test {

    Connection conn;
    PreparedStatement pst;
    ResultSet resultSet;
    public ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
    public Test() {

//       1. jvm 에 jdbc드라이브 로딩
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        2. db연결
        String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
        try {
            conn = DriverManager.getConnection(url,"c##Class01","Class01");
//        3. sql문
            String order = "select * from yunsukyeol";

//        4. 쿼리문 이용하여
            pst = conn.prepareStatement(order);
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                ArrayList<String> tmp = new ArrayList<>();
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                tmp.add(resultSet.getString(1));
                tmp.add(resultSet.getString(2));
                datas.add(tmp);
            }
            conn.close();
            resultSet.close();
            pst.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList getSQL(){
        return datas;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.getSQL();
    }
}
