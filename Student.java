package StudentDatabase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String Name, Surname, Gender, DOB, Contact;
		Integer Day, Year, Gr, Month;
		String pName, pSurname, Address;
		Integer numKids;

		Name = JOptionPane.showInputDialog("Input Student Name");

		Surname = JOptionPane.showInputDialog("Input Student Surname");

		Gender = JOptionPane.showInputDialog("Input Student Gender Male/Gender");

		Day = Integer.parseInt(JOptionPane.showInputDialog("Input Student day of birth"));

		Month = Integer.parseInt(JOptionPane.showInputDialog("Input Student birth month"));

		Year = Integer.parseInt(JOptionPane.showInputDialog("Input Student year of birth"));

		Gr = Integer.parseInt(JOptionPane.showInputDialog("Input Student Grade"));

		pName = JOptionPane.showInputDialog("Input Parent Name");

		pSurname = JOptionPane.showInputDialog("Input Parent Surame");

		Address = JOptionPane.showInputDialog("Input Parent" + " Address");

		numKids = Integer.parseInt(JOptionPane.showInputDialog("Input number of children at school"));

		Contact = JOptionPane.showInputDialog("Input parent phone number");

		DOB = Integer.toString(Day) + "/" + Integer.toString(Month) + "/" + Integer.toString(Year);


		  try
	        {
	             Class.forName("com.mysql.jdbc.Driver");
	             Connection con = DriverManager.getConnection(
	            		 "jdbc:mysql://localhost:8293/StudentData", "password", "password");

	             
	             
	             System.out.println("Database Connection Success");
	             String query = "INSERT INTO sDetails VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	             PreparedStatement preparedStmt = con.prepareStatement(query);
	             preparedStmt.setString(1, Name);
	             preparedStmt.setString(2, Surname);
	             preparedStmt.setString(3, DOB);
	             preparedStmt.setString(4, Gender);
	             preparedStmt.setInt(5, Gr);
	             preparedStmt.setString(6, pName);
	             preparedStmt.setString(7, pSurname);
	             preparedStmt.setString(8, Address);
	             preparedStmt.setString(9, Contact);
	             preparedStmt.setInt(10, numKids);
	             preparedStmt.executeUpdate();
	             System.out.println("Record inserted successfully.");
	        }
	        catch (ClassNotFoundException ex) {Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);}
	        catch (SQLException ex) {Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);}
	    }
	
}

