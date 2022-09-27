package connection;

import java.util.Scanner;

public class Employee_Start {

	public void menus()
	{
		System.out.println("\n\t*********[ MENUS ]********");
		System.out.println("\t1] INSERT");
		System.out.println("\t2] UPDATE");
		System.out.println("\t3] DELETE");
		System.out.println("\t4] SEARCH");
		System.out.println("\t5] SHOW ALL");
		System.out.println("\t6] EXIT");
	}
	public static void main(String[] args) {
		Employee_MainImpl em=new Employee_MainImpl();
		Employee_Start es=new Employee_Start();
		Scanner sc=new Scanner(System.in);
		int rotation=0;
		String s="\t*****WELCOME TO EMPLOYEE MANAGEMENT SYSTEM******";
		try {
			for(int i=0;i<s.length();i++)
			{
				System.out.print(s.charAt(i));
				Thread.sleep(200);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println();
		do
		{
			es.menus();
			System.out.print("\tEnter your Choice: ");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					int rt=0;
					do {
						em.insert();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR INSERT MORE RECORDS.");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 2:
				{
					int rt=0;
					do {
						em.update();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR UPDATE MORE RECORDS.");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 3:
				{
					int rt=0;
					do {
						em.delete();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR DELETE MORE RECORDS.");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 4:
				{
					int rt=0;
					do {
						em.search();
						System.out.println("\n");
						System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR SEARCH MORE RECORDS.");
						System.out.println("\n");
						System.out.print("\t");
						rt=sc.nextInt();
					}while(rt!=0);
					
					break;
				}
				case 5:
				{
					System.out.println("\n\n\t*********ALL EMPLOYEES DETAILS*********");
					em.showAll();
					System.out.println("\n");
					break;
				}
				default:
					System.out.println("\tCHOOSE VALID OPTION ??????");
					break;
			}
			System.out.println("\tPRESS 0: FOR EXIT\n\tPRESS 1: FOR PERFORM MORE OPERATIONS.");
			System.out.print("\t");
			rotation=sc.nextInt();
			if(rotation==0)
			{
				System.out.println("\t THANK YOU !!!");
			}
		}while(rotation!=0);

	}

}
