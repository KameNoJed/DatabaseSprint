import java.sql.*;
import javax.swing.JOptionPane;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException cnfex) {
			System.out.println("Problem in loading" + " MS Access JDBC driver");
			cnfex.printStackTrace();
		}

		try {
			String url = "C:\\Users\\Our\\Desktop\\JedWork\\1.Java\\StudentData.mdb";
			String dbURL = "jdbc:odbc:Driver=" + "{Microsoft Access Driver (*.mdb, *.accdb)};" + "DBQ=" + url
					+ ";DriverID=22;READONLY=true";

			Connection con = DriverManager.getConnection(dbURL);

			Statement st = con.createStatement();

			String sql = "SELCET * FROM sDetails";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String sName = rs.getString("Name");
				String sSurname = rs.getString("Surname");
				String sGender = rs.getString("Gender");
				Integer sGrade = rs.getInt("Grade");
				String sDOB = rs.getString("DOB");
				System.out.println(
						sName + "\n" + sSurname + "\n" + sGender + "\n" + Integer.toString(sGrade) + "\n" + sDOB);
			}
			con.close();
		} catch (Exception sqlEx) {
			System.out.println(sqlEx);
		}
		
		
		String Name, Surname, Gender, Month, DOB;
		Integer Day, Year, Gr;

		Name = JOptionPane.showInputDialog("Input Name");

		Surname = JOptionPane.showInputDialog("Input Surname");

		Gender = JOptionPane.showInputDialog("Input Gender Male/Gender");

		Month = JOptionPane.showInputDialog("Input name of birth month");

		Day = Integer.parseInt(JOptionPane.showInputDialog("Input day of birth"));

		Year = Integer.parseInt(JOptionPane.showInputDialog("Input year of birth"));

		Gr = Integer.parseInt(JOptionPane.showInputDialog("Input Grade"));

		DOB = Integer.toString(Day) + " " + Month + " " + Integer.toString(Year);

		System.out.println(Name + " " + Surname);
		System.out.println(Gender);
		System.out.println(DOB);
		System.out.println(Integer.toString(Gr));
	}

}

