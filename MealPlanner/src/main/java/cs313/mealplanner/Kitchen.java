/*
 * This class is meant to be a wrapper for JDBC, making it lots easier to use.
 */
package cs313.mealplanner;

import java.util.*;
import java.sql.*;

/**
 *
 * @author nathanulmer
 */
public class Kitchen {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static private String DB_URL;
    static private String USER;
    static private String PASS;
    
    
    // Default constructor initializes values for OpenShift site
    public Kitchen () {
        USER = "admingBniAur";
        PASS = "cIE7pZ1LstTf";
        DB_URL = "jdbc:mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/kitchen";
    }
    
    // Use this constructor when testing on your local machine.
    public Kitchen (String u, String p) {
        USER = u;
        PASS = p;
        DB_URL = "jdbc:mysql://localhost/kitchen";;
    }
    /**
     * getAccountInfo
     * RETURNS a Map containing user info and meal plan info
     */
    // PS, don't forget your \" when building prepared statements.
    public Map getAccountInfo (String email, String password) {
        Map user_table_data = new HashMap();
        //Map meal_plan_table_data = new HashMap();
        
        user_table_data = retrieve("SELECT * FROM users WHERE users.email = \""+email+"\" AND users.password = \""+password+"\"");
        /*
        user_table_data.put("user_id", user_table_data.get("id")); // "id" is going to be overwritten here in a sec...
        
        if (user_table_data.get("mealplan_id") != null) {
            meal_plan_table_data = retrieve("SELECT * FROM meal_plans WHERE meal_plans.id = "+((String)user_table_data.get("mealplan_id"))+"");
            user_table_data.putAll( meal_plan_table_data );
            user_table_data.put("plan_id", meal_plan_table_data.get("id")); // "id" has been overwritten, so lets name it what it really is now...
        }
        
        user_table_data.remove("id"); // and get rid of the redundant/ambiguously-named variable 'id'.
        */
        return user_table_data;
    }
    
    public boolean userExists(String email) {
        Map user = new HashMap();
        user = retrieve("SELECT email FROM users WHERE users.email = \""+email+"\"");
        return (user.get("email") != null);
    }
    
    // mealplan_id is found in the Map returned from getAccountInfo, above.
    public Map getMealPlan (int mealplan_id) {
        Map mealplan = new HashMap();
        Map temp = retrieve("SELECT * FROM meal_plans WHERE meal_plans.id = \""+mealplan_id+"\"");
        Set<String> meals_of_days = temp.keySet();
        
        for (String meal : meals_of_days) {
            if (!(meal.equals("id")))
                mealplan.put(meal, getRecipe(Integer.parseInt((String)(temp.get(meal)))));
        }
        
        return mealplan;
    }
    
    // recipeId's are found in the Map returned from getMealPlan, above
    public Map getRecipe (int recipeId) {
        return retrieve("SELECT * FROM recipes WHERE recipes.id = \""+recipeId+"\"");
    }
    
    public int createNewAccount (String email, String password, Map user_info) {
        String insert = 
                "INSERT INTO users (email, password, name, dob, gender, height, weight, activity, goal) VALUES ("
                + "\""+email+"\", "
                + "\""+password+"\", "
                + "\""+user_info.get("name")+"\", "
                + "\""+user_info.get("name")+ "\", "
                + "\""+user_info.get("gender")+"\", "
                + ""+user_info.get("height")+", "
                + ""+user_info.get("weight")+", "
                + "\""+user_info.get("activity")+"\", "
                + ""+user_info.get("goal")+")";
        return modify(insert);
    }
    
    // TODO: finish this...
    public int createNewMealPlan (int userId, Map plan) {
        // First 'modify' inserts plan into meal_plans table.
        // Second 'modify' updates users table with the newly inserted meal plan's id.
        // Two rows should be affected after all this. If not, we're in trouble, so return 0.
        int affected_rows = modify("") + modify("");
        return affected_rows > 1 ? affected_rows : 0;
    }
    
    /*public int insertNewUser (String name, String email, String password) {
        
        return modify("INSERT INTO users (email, password, user_info) VALUES (\""+email+"\", \""+password+"\", \""+name+"\")");
    }*/
    
    public int updatePassword (String email, String password) {
        return modify("UPDATE users SET password = (\"" + password + "\") WHERE email = (\"" + email + "\")");
    }
    
    private int modify(String query) {
        int affected_rows = 0;
		
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            affected_rows = stmt.executeUpdate(query);
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
        
        return affected_rows;
    }
    
    
    private Map retrieve (String query) {
        Map query_results = new HashMap();
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    query_results.put(rsmd.getColumnName(i),columnValue);
                }
            }
            rs.close();
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