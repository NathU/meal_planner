/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.ancestors;

import java.util.*;
import java.sql.*;

public class JDBC_Query {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/ancestors";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    private String query_string;
    
    // default constructor...
    JDBC_Query () {}
    
    public void setQueryString(String s) {
        this.query_string = s;
    }
    // non-default constructor - takes the query you want to do
    JDBC_Query (String qs) {
        this.query_string = qs;
    }

    // Executes query in the query_string
    //  This is either a Map containing everything from the SELECT statement
    //  Or it is a Map containing the key-value pair "rows affected"=<the number of rows affected by the INSERT, DELETE, or UPDATE statement>
    public Map execute_query() {
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
				ResultSetMetaData meta = rs.getMetaData();
				int columnsNumber = meta.getColumnCount();
                                int r = 0;
				while (rs.next()) {
                                        Map row = new HashMap();
					for (int i = 1; i <= columnsNumber; i++) {
						String columnValue = rs.getString(i);
                                                row.put(meta.getColumnName(i),columnValue);
					}
                                        query_results.put(r,row);
                                        r++;
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