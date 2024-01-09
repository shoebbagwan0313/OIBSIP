import java.util.*;
public class Online_Reservation_System{
	static boolean seats[]=new boolean[10];
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]){
		int choice;
		do{
			System.out.println("select 1 for seat map");
			System.out.println("select 2 for reserve seat");
			System.out.println("select 3 for cancel reservation");
			System.out.println("select 0 for exit");
			choice=Integer.parseInt(sc.nextLine());
			switch(choice){
				case 1:
					//view seatmap
					seatmap();
					break;
				case 2:
					//reserve seat
					reservation();
					break;
				case 3:
					//cancel reservation
					cancellation();
					break;
				case 0:
					System.out.println("exitted successfully");
					break;
			}
		}while(choice!=0);
	}
	static void seatmap(){
		int i;
		System.out.println("the current seat map is:");
		for(i=0;i<seats.length;i++){
			if(seats[i]){
				System.out.print("X ");
			}
			else{
				System.out.print(i+1+" ");
			}
		}
		System.out.println("");
	}
	static void reservation(){
		int seat;
		System.out.println("enter the seat number ");
		seat=Integer.parseInt(sc.nextLine());
		if(seat<1||seat>10){
			System.out.println("Invalid seat number");
		}
		else if(seats[seat-1]){
			System.out.println("seat already reserved");
		}
		else{
			seats[seat-1]=true;
			System.out.println("seat reserved successfully");
		}
	}
	static void cancellation(){
		int seat;
		System.out.println("enter the seat number for cancellation");
		seat=Integer.parseInt(sc.nextLine());
		if(seat<1||seat>10){
			System.out.println("Invalid seat number");
		}
		else if(!seats[seat-1]){
			System.out.println("seat not reserved");
		}
		else{
			seats[seat-1]=false;
			System.out.println("seat reservation cancelled successfully");
		}
	}
}
