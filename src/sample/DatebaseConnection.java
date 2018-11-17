package sample;

import java.sql.*;

public class DatebaseConnection {
    private static DatebaseConnection instance = null;
    private Connection con = null;
    private Statement st = null;


    private DatebaseConnection() throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workshop", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatebaseConnection getInstance() {
        if (instance == null) {
            try {
                instance = new DatebaseConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    public ResultSet getData(String x) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(x);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
