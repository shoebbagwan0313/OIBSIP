import java.util.*;

public class Atm_Interface {
    public static void main(String[] args) {
        Details d = new Details();
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println(" Enter 1: login\nEnter 2: register\nEnter 3: exit\nEnter the choice:");
            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1:
                    d.log();
                    break;
                case 2:
                    d.reg();
                    break;
                case 3:
                    System.out.println("Exited successfully");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (ch != 0);
    }
}

class Details {
    String name;
    int uid;
    int upin;
    int n;
    int p;

    public void reg() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter user id: ");
        uid = Integer.parseInt(sc.nextLine());
        System.out.println("Enter pin: ");
        upin = Integer.parseInt(sc.nextLine());
    }

    public void log() {
        AccountDetails ac = new AccountDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id: ");
        n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter pin: ");
        p = Integer.parseInt(sc.nextLine());
        if (n == uid && p == upin) {
            int ch;
            System.out.println("Login successful as " + name);

            do {
                System.out.println(" Enter 1: deposit \n Enter 2: withdraw \n Enter 3: transfer \n Enter 4: transaction history \n Enter 5: balance \n Enter 0: logout \n Enter choice:");
                ch = Integer.parseInt(sc.nextLine());

                switch (ch) {
                    case 1:
                        ac.deposit();
                        break;
                    case 2:
                        ac.withdraw();
                        break;
                    case 3:
                        ac.transfer();
                        break;
                    case 4:
                        ac.transaction_history();
                        break;
                    case 5:
                        ac.balance();
                        break;
                    case 0:
                        System.out.println("Logged out successfully");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } while (ch != 0);
        } else {
            System.out.println("Username or password incorrect");
        }
    }
}

class AccountDetails {
    Scanner sc = new Scanner(System.in);
    int balance = 0;
    StringBuilder transactionHistory = new StringBuilder();

    public void deposit() {
        System.out.println("Enter amount to be deposited: ");
        int dep = Integer.parseInt(sc.nextLine());
        balance += dep;
        System.out.println(dep + " deposited successfully");
        transactionHistory.append(dep).append(" deposited successfully\n");
    }

    public void withdraw() {
        System.out.println("Enter amount to be withdrawn: ");
        int wit = Integer.parseInt(sc.nextLine());
        if (balance >= wit) {
            balance -= wit;
            System.out.println(wit + " withdrawn successfully");
            transactionHistory.append(wit).append(" withdrawn successfully\n");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transfer() {
        System.out.println("Enter recipient name: ");
        String rn = sc.nextLine();
        System.out.println("Enter amount to transfer: ");
        int ta = Integer.parseInt(sc.nextLine());
        if (balance >= ta) {
            balance -= ta;
            System.out.println(ta + " transferred successfully to " + rn);
            transactionHistory.append(ta).append(" transferred to ").append(rn).append("\n");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void balance() {
        System.out.println(balance);
    }

    public void transaction_history() {
        System.out.println(transactionHistory);
    }
}
