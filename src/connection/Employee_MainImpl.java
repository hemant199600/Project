package connection;
import java.sql.*;
import java.util.*;
public class Employee_MainImpl implements Employee_Main
{
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Scanner sc=new Scanner(System.in);
	Employee_MainImpl()
	{
		con=Connectionclass.getConnection();
		
	}
	@Override
	public void insert() {
		System.out.print("\n\n\tEnter id      : ");
		int id=sc.nextInt();
		System.out.print("\tEnter name    : ");
		sc.nextLine();
		String nm=sc.nextLine();
		System.out.print("\tEnter city    : ");
		String ct=sc.nextLine();
		System.out.print("\tEnter Country : ");
		String cont=sc.nextLine();
		
		String query="insert into employeeProject values(?,?,?,?)";
	
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, nm);
			ps.setString(3, ct);
			ps.setString(4,cont);
			ps.executeUpdate();
			System.out.println("\tRecord inserted SuccessFully !!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("\t--------------------------------------------");
	}

	@Override
	public void delete() {
		System.out.print("\t\n\nEnter id for delete the record : ");
		int id=sc.nextInt();
		 String Query="delete from employeeProject where id=?";
		  try {
			ps=con.prepareStatement(Query);
			ps.setInt(1, id);
			if(ps.execute())
			{
				System.out.println("\tRecord deleted Sucessfully.");
			}
			else
			{
				System.out.println("\tTechnical Error.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		  System.out.println("\t--------------------------------------------");
	}

	@Override
	public void update() {
		
		System.out.print("\n\n\tEnter id for update record          : ");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("\tEnter which column name for update  : ");
		String col=sc.nextLine();
		System.out.print("\tEnter the data                      : ");
		String data=sc.nextLine();
		
		String query="Update employeeProject set "+col.toLowerCase()+"=? where id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, data);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("\tRecord updated SuccessFully !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\t--------------------------------------------");
	}
	@Override
	public void search() {
		System.out.print("\n\n\tEnter id for Search the record : ");
		int id=sc.nextInt();
		System.out.println("\n\n\t*********EMPLOYEE DETAILS*********");
		 String Query="Select * from employeeProject where id=?";
		  try {
				ps=con.prepareStatement(Query);
				ps.setInt(1, id);
				
				rs=ps.executeQuery();
				System.out.println();
				System.out.println("\tID\tName\tCity\tCountry");
			   System.out.println("\t---------------------------------------");
			   while(rs.next()) {
				   
				   System.out.println("\t"+rs.getInt(1)+ "\t" +rs.getString(2)+ "\t"+rs.getString(3)+ "\t"+rs.getString(4));
				   
			   }
			   System.out.println("\t---------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		
	}
		
	@Override
	public void showAll() {
		
		try {
				st=con.createStatement();
				rs=st.executeQuery("select * from employeeProject");
				System.out.println("\tID\tName\tCity\tCountry");
			   System.out.println("\t--------------------------------------------");
			   while(rs.next()) {
				   
				   System.out.println("\t"+rs.getInt(1)+ "\t" +rs.getString(2)+ "\t"+rs.getString(3)+ "\t"+rs.getString(4));
				   
			   }
			   System.out.println("\t--------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
