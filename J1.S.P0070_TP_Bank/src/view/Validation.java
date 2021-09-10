package view;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation{   
    public static Scanner in = new Scanner(System.in);
    public static String inputString(String p, boolean canNull){
        String s = "";
        System.out.print(p);
        do{
            s = in.nextLine();
            if (canNull == true && s.isEmpty()) return null; 
            if (!s.replaceAll("\\s+", "").isEmpty())
                break;
            else System.err.print("Invalid input, enter again: "); 
        }while(true);
        return s;
    }
    public static Integer inputInt(String p){
        String tmp;
        int i = 0;
        System.out.print(p);
        do{
            try{
                tmp = in.nextLine();
                if (tmp.replaceAll(" ", "").trim().isEmpty()){
                    return null;
                }
                if (Integer.parseInt(tmp) == Integer.parseInt(tmp)){
                    i = Integer.parseInt(tmp);
                }
                break;
            }catch(Exception e){
                System.err.print("Invalid input, enter again: ");
                //thread
            }
        }while(true);
        return i;
    }
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
                System.err.print("Invalid input, enter again: ");
            }
        }while(true);
        return b;
    }  
    public static Integer inputIntLimit(int first, int end){
        Integer input;
        
        while(true){
            input = inputInt("");
            if (input == null) return null;
            if (first <= input && input <= end){
                return input;
            }else{
                if (first != end) System.err.printf("Enter a integer number from %d to %d: ", first, end);
                else System.err.printf("A integer valiable is %d! Enter again: ", first);
            }
        }
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
            System.err.print("Invalid input! Enter again: ");
        }
    }  
    public static boolean hasNumeric(String stringInput){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(stringInput);
        while (matcher.find()) return true;
        return false;
    }
}
