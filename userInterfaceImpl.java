package userInterface;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.Connect;

public class userInterfaceImpl implements ScootyOutlets
{
	private Connection con=Connect.getConnect();
	Scanner sc=new Scanner(System.in);
	String oname;
	@Override
	public int checkAvailabilty() {
		try
		{
			System.out.println("\t******App is Initializing **********");
			
			System.out.println("Select your near by location: ");
			Statement st=con.createStatement();
			String query="select outlet_name from company";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				System.out.println("\t"+rs.getString(1));
				
			}
			System.out.print("\tEnter the selected outlet name:");
			{
				oname=sc.nextLine();
			}
			
			
			//make reservation;
			Reservation(oname);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	
	public void Reservation(String name)  {
		System.out.println("\t**********Reservation of Vehicle********");
		try
		{
			String query="insert into "+name+"(c_name,v_no,available) values(?,?,?)";
			PreparedStatement st=con.prepareStatement(query);
			System.out.print("\tEnter  your name:");
			st.setString(1, sc.nextLine());
			System.out.print("\tEnter vehicle number: ");
			st.setString(2, sc.nextLine());
			st.setInt(3, 1);
			if(st.executeUpdate()>0)
			{
				System.out.print("\tSuccessfully reservation completed.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println();
	}
	public void park()
	{
		System.out.println("Enter outlet name: ");
			String otlet=sc.nextLine();
			try
			{
				String query="update "+otlet+" where v_no=? and availability=?";
				PreparedStatement st=con.prepareStatement(query);
				System.out.print("\tEnter vehicle number: ");
				String v_num=sc.nextLine();
				if(checkAvail(v_num))
				{
					st.setString(1, v_num);
					st.setInt(2, 0);
					if(st.executeUpdate()>0)
					{
						System.out.print("\tParking slot reserved.");
					}
				}
				else
				{
					System.out.println("Sorry no space");
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		public boolean checkAvail(String vno)
		{
			try
			{
				System.out.println("Enter near by outlet name: ");
				String tbname=sc.nextLine();
				String query="select * from "+tbname+" where v_no=?";
		
				PreparedStatement st=con.prepareStatement(query);
				
				
				st.setString(1, vno);
				ResultSet rs=null;
				rs=st.executeQuery();
				if(rs.getInt(4)==1)
				{
					return true;
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
		}
	public static void main(String args[])
	{
		userInterfaceImpl obj=new userInterfaceImpl();
		obj.checkAvailabilty();
	}

}
