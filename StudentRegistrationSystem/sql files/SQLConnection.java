package hic_admission_form;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author moham
 */
public class SQLConnection 
{
   Connection mycon =null;
    public static Connection ConnectDB()
    {
        try
        {
           Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegemanagementsystem","root","");
          // JOptionPane.showMessageDialog(null, "Connected to database");
            return mycon;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    
}
