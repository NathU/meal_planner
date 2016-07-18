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
        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        DB_URL = String.format("jdbc:mysql://%s:%s/kitchen", host, port);
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
        user_table_data = retrieve("SELECT * FROM users WHERE users.email = \""+email+"\" AND users.password = \""+password+"\"");
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
        //mealplan = retrieve("SELECT * FROM meal_plans WHERE meal_plans.id = \""+mealplan_id+"\""); // this just returns day_meals and recipe id's
        Map temp = retrieve("SELECT * FROM meal_plans WHERE meal_plans.id = \""+mealplan_id+"\"");
        Set<String> meals_of_days = temp.keySet();
        
        for (String meal : meals_of_days) {
            if (!(meal.equals("id"))) {
                if (temp.get(meal) != null) {
                    int recipe_id = Integer.parseInt((String)temp.get(meal));
                    mealplan.put(meal, getRecipe(recipe_id));
                } else {
                    Map empty_recipe = new HashMap();
                    empty_recipe.put("id", null);
                    empty_recipe.put("label", null);
                    empty_recipe.put("url", null);
                    mealplan.put(meal, empty_recipe);
                }
            }
        }
        return mealplan;
    }
    
    // recipeId's are found in the Map returned from getMealPlan, above
    public Map getRecipe (int recipeId) {
        return retrieve("SELECT * FROM recipes WHERE recipes.id = \""+recipeId+"\"");
    }
    
    // THis will work fine IF url to a given recipe doesn't change. ie, url is basically a unique identifier.
    public Map getRecipe (String label, String url) {
        return retrieve("SELECT * FROM recipes WHERE recipes.label = \""+label+"\" AND recipes.url = \""+url+"\"");
    }
    
    public int createNewAccount (String email, String password, Map user_info) {
        int rows_affected = 0;
        // Create the new user...
        String insert = 
                "INSERT INTO users (email, password, name, dob, gender, height, weight, activity, goal) VALUES ("
                + "\""+email+"\", "
                + "\""+password+"\", "
                + "\""+user_info.get("name")+"\", "
                + "\""+user_info.get("dob")+ "\", "
                + "\""+user_info.get("gender")+"\", "
                + ""+user_info.get("height")+", "
                + ""+user_info.get("weight")+", "
                + "\""+user_info.get("activity")+"\", "
                + ""+user_info.get("goal")+")";
        rows_affected += modify(insert);
        
        // ...then create his/her meal plan...
        rows_affected += modify("INSERT INTO meal_plans (Sunday_breakfast) VALUES(NULL)");
        
        Map most_recent_mealplan_id = new HashMap();
        most_recent_mealplan_id = retrieve("SELECT MAX(id) FROM meal_plans");
        int id = Integer.parseInt((String)most_recent_mealplan_id.get("MAX(id)"));
        
        // ...then link the two together.
        //rows_affected += modify("INSERT INTO users.mealplan_id VALUES("+id+") ");
        rows_affected += modify("UPDATE users SET mealplan_id = (" + id + ") WHERE email = (\"" + email + "\")");
        
        // Now return the number of rows affected. Should be 3 i think...
        return rows_affected;
    }
    
    public int insertRecipe (String label, String url) {
        // can't add a recipe that has no url! Doing this here cause I forgot to require it in DB... oops.
        if (url == null || url.equals("")) {
            return 0;
        }
        return modify("INSERT INTO recipes (label, password, url) VALUES (\""+label+"\", \""+url+"\")");
    }
    
    public int updatePassword (String email, String password) {
        return modify("UPDATE users SET password = (\"" + password + "\") WHERE email = (\"" + email + "\")");
    }
    
    // THis method allows you to plan a recipe that's not in DB yet.
    // In other words, it adds the recipe to DB if it's not already in there.
    public int addRecipeToPlan(String label, String url, String day_meal, int mealplan_id) {
        //first, make sure this recipe is in the DB
        Map recipe = new HashMap();
        recipe = getRecipe(label, url);
        
        if (recipe.get("id") == null) {
            // if it's not yet, add it.
            insertRecipe(label, url);
            recipe = getRecipe(label, url);
        }
        
        int id = Integer.parseInt((String)recipe.get("id"));
        
        // then, add the recipe to the plan
        return modify("UPDATE meal_plans SET "+day_meal+" = (\"" + id + "\") WHERE id = ("+mealplan_id+")");
        
    }
    
    
    public Map deleteRecipeFromPlan(int recipe_id, String day_meal, int mealplan_id) {
        // first, make sure that mealplan really has that recipe in it.
        Map plan = new HashMap();
        plan = getMealPlan(mealplan_id);
        int deleteMe = Integer.parseInt((String)plan.get(day_meal));
        int rows_affected = 0;
        
        if (deleteMe == recipe_id) {
            rows_affected = modify("DELETE meal_plans."+day_meal+" FROM meal_plans WHERE id = ("+mealplan_id+")");
        }
        
        // return the updated plan. or an error.
        if (rows_affected != 1) {
            Map error = new HashMap();
            error.put("error", "something went wrong...");
            return error;
        } else {
            return getMealPlan(mealplan_id); //you'll want to set the meal_plan session var to this.
        }
        
        
        // We're doing a lot of authentication here. Should we just delete without worrying?
        //modify("DELETE meal_plans."+day_meal+" FROM meal_plans WHERE id = ("+mealplan_id+")");
        //return getMealPlan(mealplan_id);
        
    }
    
    public int simpleDelete(String day_meal, int mealplan_id) {
        return modify("DELETE meal_plans."+day_meal+" FROM meal_plans WHERE id = ("+mealplan_id+")");
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