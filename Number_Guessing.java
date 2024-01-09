import java.util.*;
public class Number_Guessing{
	public static void main(String args[]){
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int k=5,guess;
		int key=rand.nextInt(100);
		System.out.println("you have "+k+" lives to guess the number");
		boolean flag=false;
		while(k!=0){
			System.out.println("guess the number");
			guess=Integer.parseInt(sc.nextLine());
			if(guess==key){
				flag=true;
				System.out.println("you won the game");4
				System.out.println("your score is "+k);
				return;
			}
			else if(guess>key){
				System.out.println("the guessed number is higher than original number");
				k--;
				System.out.println("you have "+k+" lives to guess the number");
			}
			else if(guess<key){
				System.out.println("the guessed number is lower than original number");
				k--;
				System.out.println("you have "+k+" lives to guess the number");
			}
		}
		if(k==0){
			System.out.println("you lost the game");
		}
	}
}
