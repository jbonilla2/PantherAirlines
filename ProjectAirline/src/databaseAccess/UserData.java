package databaseAccess;

import Backend.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;


public class UserData {

    private static Statement statement;
    private static PreparedStatement pstatement;
    private static ArrayList<User> users;
    private static Connection conn = DBconnect.connect();

    //Gets user data from user database
    public static ArrayList<User> getUsers(){
        users = new ArrayList<>();

        try{
        	 statement = conn.createStatement();

        	 ResultSet rs = statement.executeQuery("SELECT * FROM user");


            if(rs != null)
                while (rs.next()) {
                	User user = new User();
                    user.setSSN(rs.getInt(1));
                    user.setFirstname(rs.getString(2));
                    user.setLastname(rs.getString(3));
                    user.setAddress(rs.getString(4));
                    user.setZip(rs.getInt(5));
                    user.setState(rs.getString(6));
                    user.setUsername(rs.getString(7));
                    user.setPassword(rs.getString(8));
                    user.setEmail(rs.getString(9));
                    user.setSecurityQ(rs.getString(10));
                    user.setSecurityA(rs.getString(11));

                    users.add(user);
                    
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public static void insertUser(User user) {
        
    	try{
        	String qry = "INSERT INTO user" +
        			"(SSN, FirstName, LastName, Address, ZIP, State, Username, Password, Email, SecurityQuestion, SecurityAnswer)" + 
        			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
        	pstatement = conn.prepareStatement(qry);
            
            pstatement.setInt(1, user.getSSN());
            pstatement.setString(2, user.getFirstname());
            pstatement.setString(3, user.getLastname());
            pstatement.setString(4, user.getAddress());
            pstatement.setInt(5, user.getZip());
            pstatement.setString(6, user.getState());
            pstatement.setString(7, user.getUsername());
            pstatement.setString(8, user.getPassword());
            pstatement.setString(9, user.getEmail());
            pstatement.setString(10, user.getSecurityQ());
            pstatement.setString(11, user.getSecurityA());
            
            pstatement.executeUpdate();

            
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }
   
	

}
