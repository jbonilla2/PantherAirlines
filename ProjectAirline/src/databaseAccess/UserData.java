package databaseAccess;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;



public class UserData {

    private static Statement statement;
    private static ObservableList<User> users;
    private static Connection conn = DBconnect.connect();

    public static ObservableList<User> getUsers(){
        users = FXCollections.observableArrayList();  

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
            statement.executeUpdate("INSERT INTO user" + 
        "VALUES(customer.getSSN, customer.getFirstname(), customer.getLastname(), customer.getAddress(), customer.getZip(), customer.getState(), customer.getUsername(), customer.getPassword(), customer.getEmail(), customer.getSecurityQ(), customer.getSecurityA()");            
            users.add(user); // observable array list
            //customer.setSSN(customers.indexOf(customer) + 1);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to update a customer
    //public static void updateCustomer(Customer customer){
    //    try{
    //        statement.executeUpdate("UPDATE customer SET FirstName = " + customer.getFirstname() +
    //        		"', last_name = '" + customer.getLast_name() + "', age = " + customer.getAge() + ", passport_number = '" +
    //        		customer.getPassport_number() + "', phone_nr = '" + customer.getPhone_nr() + "' WHERE customer_id = " + customer.getCustomer_id() + ";");
    //        customers.set(customer.getCustomer_id() - 1, customer);
    //    }

    //    catch(Exception e){
    //        e.printStackTrace();
    //    }
   
	

}
