package activityPanel;

import sql.SQL_Area;
import sql.SQL_Math;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;

public class SimulationPanel extends JPanel {

    public SimulationPanel() throws SQLException {
        test(4,4,2,0);
    }

    private void test(int google,int view,int sub,int ratio) throws SQLException {
        HashMap finalHashmap = new SQL_Math(google,view,sub,ratio).getHashMap();
        HashMap deaguHashMap = new SQL_Area(finalHashmap,"대구광역시").getHashMap();



    }
}
