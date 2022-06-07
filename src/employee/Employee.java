package employee;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee
{
	static void select()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Deepika@5799");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	static void delete()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Deepika@5799");
			String s = "delete from employee where Emp_ID = ?";
			PreparedStatement ps = con.prepareStatement(s);
			ps.setInt(1, 2);
			ps.execute();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	static void update()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Deepika@5799");
			Statement st = con.createStatement();
			st.executeUpdate("update employee set Emp_Name = 'Deepika' where Emp_ID = 101");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	static void insert()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Deepika@5799");
			Statement st = con.createStatement();
			st.executeUpdate("insert into employee values(109,'Dhanya',23,65600)");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Inserted Successfully");
		}
	}
	@SuppressWarnings("static-access")
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Press");
		System.out.println("1. INSERT");
		System.out.println("2. UPDATE");
		System.out.println("3. SELECT");
		System.out.println("4. DELETE");
		int i = sc.nextInt();
		Employee emp = new Employee();
		
		switch(i)
		{
		
		case 1:
			emp.insert();
			break;
			
		case 2:
			emp.update();
			break;
			
		case 3:
			emp.select();
			break;
			
		case 4:
			emp.delete();
			break;
		}
		
	}
	
}
