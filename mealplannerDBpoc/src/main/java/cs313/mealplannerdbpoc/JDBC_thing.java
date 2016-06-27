package cs313.mealplannerdbpoc;

import java.util.*;
import java.sql.*;

public class JDBC_thing {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/kitchen";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    private String query_string;
    
    // default constructor...
    JDBC_thing () {}
    public void setQuery(String s) {
        this.query_string = s;
    }
    // non-default constructor - takes the query you want to do
    JDBC_thing (String qs) {
        this.query_string = qs;
    }
	
    public Map doTheThing() {
		Map query_results = new HashMap();
		
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

			String first_word = (query_string.split(" "))[0];
			boolean do_SELECT = first_word.equals("SELECT") || first_word.equals("select");
			
			if (do_SELECT) {
				ResultSet rs = stmt.executeQuery(query_string);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				while (rs.next()) {
					for (int i = 1; i <= columnsNumber; i++) {
						String columnValue = rs.getString(i);
						query_results.put(rsmd.getColumnName(i),columnValue);
					}
				}
				rs.close();
			} else {
				int s = stmt.executeUpdate(query_string);
				query_results.put("rows affected", s);
			}
        }
        catch(SQLException se){ se.printStackTrace(); }
        catch(Exception e){ e.printStackTrace(); }
        
        finally{
            // clean up in case a throw occured.
            try{
             if(stmt!=null)
                conn.close();
            }catch(SQLException se){/*do nothin*/}
            try{
             if(conn!=null)
                conn.close();
            }catch(SQLException se){ se.printStackTrace(); }
        }
        
        return query_results;
    }
}