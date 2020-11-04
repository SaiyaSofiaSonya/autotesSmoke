package ru.ttestess.test;
import java.sql.*;

import org.testng.annotations.Test;




public class JDBCtest {


     @Test
    public void testConnectionJDBC(){
     Connection conn = null;

         try {
             conn = DriverManager.getConnection("jdbc:mysql://test",
                     "user=test","password=test");
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("SELECT timestamp_validated FROM test.news_alert WHERE timestamp_validated > '2019-11-15'");

         while(rs.next()) {System.out.println(rs);}

             rs.close();
             st.close();
             conn.close();


         } catch (SQLException e) {
             e.printStackTrace();

        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
      }
     }

}
