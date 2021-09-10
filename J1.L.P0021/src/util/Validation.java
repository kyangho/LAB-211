package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duc Ky
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation{
    public static Scanner in = new Scanner(System.in);
    
    /**
     * Check if input String is letter or not
     */
    public static boolean isLetter(String p){
        p = p.replaceAll(" ", "");
        for (int i = 0; i < p.length(); i++){
            if (!Character.isLetter(p.charAt(i))){
                System.out.println("Only letter!");
                return false;
            }
        }
        return true;
    }
    /**
     * Check if input is String or not
     * @param message
     * @return 
     */
    public static String inputString(String p){
        String s = "";
        System.out.print(p);
        do{
            s = in.nextLine();
            if (!s.replaceAll(" ", "").isEmpty()) break;
            else System.out.print("Invalid input, enter again: "); 
        }while(true);
        return s;
    }
    /**
     * Check if input is int or not
     * @param message
     * @return 
     */
    public static int inputInt(String p){
        String tmp;
        int i = 0;
        System.out.print(p);
        do{
            try{
                tmp = in.nextLine();
                if (Integer.parseInt(tmp) == Integer.parseInt(tmp)){
                    i = Integer.parseInt(tmp);
                }
                break;
            }catch(Exception e){
                System.out.print("Invalid input, enter again: ");
            }
        }while(true);
        return i;
    }
    /**
     * Check if input is double or not
     * @param message
     * @return 
     */
    public static double inputDouble(String p){
        String tmp;
        double d = 0;
        System.out.print(p);
        do{
            try{
                tmp = in.nextLine();
                if (Double.parseDouble(tmp) == Double.parseDouble(tmp)){
                    d = Double.parseDouble(tmp);
                }
                break;
            }catch(Exception e){
                System.out.print("Invalid input, enter again: ");
            }
        }while(true);
        return d;
    }
    /**
     * Check if input is boolean or not
     * @param message
     * @return 
     */
    public static boolean inputBoolean(String p){
        String tmp;
        boolean b = true;
        System.out.print(p);
        do{
            try{
                tmp = in.nextLine();
                if (Boolean.parseBoolean(tmp) == Boolean.parseBoolean(tmp)){
                    b = Boolean.parseBoolean(tmp);
                }
                break;
            }catch(Exception e){
                System.out.print("Invalid input, enter again: ");
            }
        }while(true);
        return b;
    }
    /**
     * Check if input is char or not
     * @param message
     * @return 
     */
    public static char inputChar(String p){
        System.out.print(p);
        String c;
        while(true){
            c = in.nextLine();
            if (c.length() == 1){
                return c.charAt(0);
            }else{
                System.out.print("Invalid input, enter again: ");
            }
        }
    }
    /**
     * Check if input date is valid or not
     * @param message
     * @param format date
     * @return 
     */
    public static String inputDate(String p, String pattern){
        System.out.print(p);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date();
        String tmp;
        while(true){
            try{
                tmp = in.nextLine();
                date = sdf.parse(tmp);
                if (tmp.equals(sdf.format(date))){
                    return tmp;
                }else{
                    System.out.print("Invalid input, enter again: ");
                }
            }catch(Exception e){
                System.out.print("Invalid input, enter again: ");
            }
        }
    }
    public static boolean isInt(String tmp){
        try{
            if (Integer.parseInt(tmp) == Integer.parseInt(tmp)){
                return true;
            }
        }catch(Exception e){
            System.out.print("Invalid input, enter again: ");
        }
        return false;
    }
    
    public static boolean checkYesNo(String tmp){
        System.out.print(tmp);

        boolean check = false;
        while(true){
            String s = in.nextLine();
            s.replaceAll(" ", "");
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0){
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0){
                return false;
            }
            System.out.print("Invalid input! Enter again: ");
        }
    }
    
    public static String upperLetter(String tmp){
        char [] charArray = tmp.toCharArray();
        for (int i = 0; i < charArray.length; i++){
            if (Character.isLowerCase(charArray[i])){
                charArray[i] -= 32;
            }
        }
        return new String(charArray);
    }
    
    public static String beautyName(String stringInput){
        if (stringInput.isEmpty()) return null;
        String [] strA = stringInput.replaceAll("\\s+", " ").trim().split(" ");
        if (stringInput.replaceAll(" ", "").isEmpty()) return null;
        String tmp = "";
        String result = "";
        for (String s : strA){
            s = s.toLowerCase();
            if (s.length() == 1){
                result = result + s.toUpperCase() + " ";
                continue;
            }
            tmp = s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            result += tmp;
        }
        return result.trim();
    }
}
