/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homework02sql;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author SOL
 */
public class Homework02SQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Homework02SQL pro = new Homework02SQL();
        
        pro.createConnection();
        //test connection
        }
            void createConnection()
        {
            //important to create connection
            try{
                //Class.forName("com.mysql.cj.jdbc.Drive");
                //change for admin and root users
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "123456");
                System.out.println("Connection successful");
            } catch (SQLException ex) {                        
            Logger.getLogger(Homework02SQL.class.getName()).log(Level.SEVERE, null, ex);
        }                        
                    
        }
    
}
