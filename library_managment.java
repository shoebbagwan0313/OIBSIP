import java.util.*;
public class library_managment{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int choice;
		login l=new login();
		do{
			System.out.println("select 1 for login as admin");
			System.out.println("select 2 for register as admin");
			System.out.println("select 3 for login as user");
			System.out.println("select 0 for exit");
			System.out.println("enter choice");
			choice=Integer.parseInt(sc.nextLine());
			switch(choice){
				case 1:
					l.admin_login();
					break;
				case 2:
					l.admin_register();
					break;
				case 3:
					//user login
					l.user_login();
					break;
				case 0:
					System.out.println("successfully exitted");
					break;
			}
		}while(choice!=0);
	}
}
class login{
	Scanner sc=new Scanner(System.in);
	int choice;
	String user[][]=new String[10][3];
	String book[][]=new String[100][2];
	int usize=0,bsize=0;
	String admin_name,admin_uname,admin_password;
	String user_name,user_uname,user_password;
	String l_uname,l_password;
	String book_title,book_author;
	void admin_register(){
		System.out.println("enter your name");
		admin_name=sc.nextLine();
		System.out.println("enter username");
		admin_uname=sc.nextLine();
		System.out.println("enter password");
		admin_password=sc.nextLine();
		System.out.println("admin registered successfully");
	}
	void admin_login(){
		System.out.println("enter admin username");
		l_uname=sc.nextLine();
		System.out.println("enter password");
		l_password=sc.nextLine();
		if(l_uname.equalsIgnoreCase(admin_uname)&&l_password.equals(admin_password)){
			System.out.println("logged in successfully as admin\nadmin name :"+admin_name);
			//admin actions
			do{
				System.out.println("select 1 for registering user");
				System.out.println("select 2 for deleting user");
				System.out.println("select 3 for adding book");
				System.out.println("select 4 for deleting book");
				System.out.println("select 5 for searching book");
				System.out.println("select 0 for logging out");
				System.out.println("enter choice"); 
				choice=Integer.parseInt(sc.nextLine());
				switch(choice){
					case 1:
						System.out.println("enter username to register");
						user_name=sc.nextLine();
						System.out.println("enter login username");
						user_uname=sc.nextLine();
						System.out.println("enter password");
						user_password=sc.nextLine();
						user[usize][0]=user_name;
						user[usize][1]=user_uname;
						user[usize][2]=user_password;
						usize++;
						System.out.println("user registered successfully");
						break;
					case 2:
						//deleting user
						int flag1=0;
						System.out.println("enter user to delete");
						user_name=sc.nextLine();
						System.out.println("enter login username");
						user_uname=sc.nextLine();
						for(int i=0;i<usize;i++){
							if(user[i][0].equalsIgnoreCase(user_name)&&user[i][1].equalsIgnoreCase(user_uname)){
								flag1=1;
								for(int j=i;j<usize-1;j++){
									user[j][0]=user[j+1][0];
									user[j][1]=user[j+1][1];
									user[j][2]=user[j+1][2];
								}
							}
						}
						usize--;
						if(flag1==0){
							System.out.println("user not exist");
						}
						else{
							System.out.println("user removed successfully");
						}
						break;
					case 3:
						//add book
						System.out.println("enter book title");
						book_title=sc.nextLine();
						System.out.println("enter book author name");
						book_author=sc.nextLine();
						book[bsize][0]=book_title;
						book[bsize][1]=book_author;
						bsize++;
						System.out.println("book added successfully");
						break;
					case 4:
						//delete book
						int flag2=0;
						System.out.println("enter book title");
						book_title=sc.nextLine();
						System.out.println("enter book author name");
						book_author=sc.nextLine();
						for(int i=0;i<bsize-1;i++){
							if(book[i][0].equalsIgnoreCase(book_title)&&book[i][1].equalsIgnoreCase(book_author)){
								flag2=1;
								for(int j=i;j<bsize-1;j++){
									book[j][0]=book[j+1][0];
									book[j][1]=book[j+1][1];
								}
							}
						}
						bsize--;
						if(flag2==0){
							System.out.println("book doesnot exist");
						}
						else{
							System.out.println("book removed successfully");
						}
						break;
					case 5:
						//search book
						int flag3=0;
						System.out.println("enter book title");
						book_title=sc.nextLine();
						System.out.println("enter book author name");
						book_author=sc.nextLine();
						for(int i=0;i<bsize;i++){
							if(book[i][0].equalsIgnoreCase(book_title)&&book[i][1].equalsIgnoreCase(book_author)){
								flag3=1;
								System.out.println("book is present");
							}
						}
						if(flag3==0){
								System.out.println("book not present");
							}
						break;
					case 0:
						System.out.println("loggedout successfully");
						break;
				}
			}while(choice!=0);
		}
		else{
			System.out.println("incorrect username or password");
		}
	}
	void user_login(){
		int flag=0;
		System.out.println("enter username");
		l_uname=sc.nextLine();
		System.out.println("enter password");
		l_password=sc.nextLine();
		for(int i=0;i<usize;i++){
			if(user[i][1].equalsIgnoreCase(l_uname)&&user[i][2].equals(l_password)){
				System.out.println("loggedin as "+user[i][0]);
				flag=1;
				do{
					System.out.println("select 1 for searching book");
					System.out.println("select 0 for logging out");
					System.out.println("enter choice");
					choice=Integer.parseInt(sc.nextLine());
					switch(choice){
						case 1:
							int flag1=0;
							System.out.println("enter book title");
							book_title=sc.nextLine();
							System.out.println("enter book author name");
							book_author=sc.nextLine();
							for(int j=0;j<bsize;j++){
								if(book[j][0].equalsIgnoreCase(book_title)&&book[j][1].equalsIgnoreCase(book_author)){
									flag1=1;
									System.out.println("book is present");
								}
							}
							if(flag1==0){
								System.out.println("book not present");
							}
							break;
						case 0:
							System.out.println("logged out successfully");
							break;
					}
				}while(choice!=0);
			}
		}
		if(flag==0){
			System.out.println("incorrect username or password");
		}
	}
}
