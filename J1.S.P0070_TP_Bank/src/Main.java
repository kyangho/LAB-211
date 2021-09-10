
import manager.AccountDB;
import manager.Ebank;
import entity.Account;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import view.ViewAccount;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a;
        while (true) {
            try {
                a = sc.nextInt();
                break;
            } catch (Exception e) {
                System.err.println("Loi! Moi ban nhap lai!");
            }
            
        }
        System.out.println(a);
        System.out.println("print dong nay");
    }

}
