
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duc ky
 */
public class Main {

    public static void main(String[] args) {
        boolean preferred;
        Scanner sc = new Scanner(System.in);
        sc.nextBoolean();
        try{
            String s = sc.nextLine();
            preferred = Boolean.parseBoolean(s);
        }catch(Exception e){
            System.out.println("err");
        }
    }

}
