package code;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	java.sql.Connection con = null;
        try
        {           
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sokoban","root","root");
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO Table_Score (Pseudo,Score) VALUES"+ "('Claiire la best',8)");
            ResultSet rs = st.executeQuery("select * from Table_Score");
            while(rs.next())
            {
            	System.out.println(rs.getString("Pseudo"));
            	System.out.println(rs.getString("Score"));
            }
        }
        catch(SQLException e)
        {
	       System.out.println(e);
	    }
	
	}
}
