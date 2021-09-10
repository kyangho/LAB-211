package util;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duc Ky
 */
public class Validation {
    static final Scanner in = new Scanner(System.in);
    static final String errM_null = "Input can not be null!";
    static final String errM = "Invalid input! Enter again!";
    static final String errM_positiveInt = "Number entered must be positive number!";
    static final String errM_intNumber = "Number entered must be integer number!";
    static final String errM_floatNumber = "Number entered must be real number!";
    static final String errM_invalidNumber = "This is not a number!";
    static final String errM_invalidDate = "Invalid date! Enter again!";
    static final String errM_invalidName = "This name is not valid";
    public static final DecimalFormat format = new DecimalFormat("0.#");
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    //Input String
    /**
     * 
     * @param message
     * @param canNull
     * @return 
     */
    public static String inputString(String message, boolean canNull){
        String result;
        while(true){
            System.out.print(message);
            try{
                result = in.nextLine();
                if (result.replaceAll("\\s+", "").isEmpty() && canNull){
                    return null;
                }else if (!canNull && result.replaceAll("\\s+", "").isEmpty()){
                    System.err.println(errM_null);
                    continue;
                }else{
                    break;
                }
            }catch(Exception e){
                System.err.println(errM);
            }
        }
        return result;
    }
    //Input integer
    /**
     * 
     * @param message
     * @param canNull
     * @param canNegative
     * @return 
     */
    public static Integer inputInteger(String message, boolean canNull, boolean canNegative){
        String tmp;
        while(true){
            System.out.print(message);
            try{
               tmp = in.nextLine();
               if (tmp.replaceAll("\\s+", "").isEmpty() && canNull){
                   return null;
               }
               if (tmp.replaceAll("\\s+", "").isEmpty()&& !canNull){
                   System.err.println(errM_null);
                   continue;
               }
               if (Integer.parseInt(tmp) != Double.parseDouble(tmp)){
                   System.err.println(errM_intNumber);
                   continue;
               }
               if (Integer.parseInt(tmp) <= 0 && !canNegative){
                   System.err.println(errM_positiveInt);
                   continue;
               }else{
                   break;
               }
            }catch(Exception e){
                System.err.println(errM_invalidNumber);
            }
        }
        return Integer.parseInt(tmp);
    }
    //Input double
    /**
     * @param message
     * @param canNull
     * @param canNegative
     * @return 
     */
    public static Double inputDouble(String message, boolean canNull, boolean canNegative){
        String tmp;
        while(true){
            System.out.print(message);
            try{
               tmp = in.nextLine();
               if (tmp.replaceAll("\\s+", "").isEmpty() && canNull){
                   return null;
               }
               if (tmp.replaceAll("\\s+", "").isEmpty()&& !canNull){
                   System.err.println(errM_null);
                   continue;
               }
               if (Double.parseDouble(tmp) <= 0 && !canNegative){
                   System.err.println(errM_positiveInt);
                   continue;
               }else{
                   break;
               }
            }catch(NumberFormatException e){
                System.err.println(errM_invalidNumber);
            }
        }
        return Double.parseDouble(tmp);
    }
    //Input int in interval[first, end]
    /**
     * @param first
     * @param end
     * @return 
     */
    public static Integer inputIntLimit(String message, int first, int end, boolean canNull){
        Integer input;
        while(true){
            input = inputInteger(message, canNull, true);
            if (input == null && canNull){
                return null;
            }
            if(input == null && !canNull){
                System.err.println(errM_null);
                continue;
            }
            if (first <= input && input <= end){
                return input;
            }else{
                if (first != end) System.err.printf("Enter a integer number from %d to %d!\n", first, end);
                else System.err.printf("A integer valiable is %d!\n", first);
            }
        }
    }
    //Check if input is yes or no
    /**
     * 
     * @param message
     * @return 
     */
    public static boolean checkYesNo(String message){
        

        boolean check = false;
        while(true){
            System.out.print(message);
            String s = in.nextLine();
            s.replaceAll(" ", "");
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0){
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0){
                return false;
            }
            System.err.println(errM);
        }
    }
    //Change string by form
    /**
     * 
     * @param stringInput
     * @return 
     */
    public static String beautyName(String stringInput){
        if (stringInput == null || stringInput.isEmpty()) return null;
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
    public static Date inputDate(String message, boolean canNull){
        Date date;
        List<SimpleDateFormat> sdfList = new ArrayList<>(
                Arrays.asList(new SimpleDateFormat("dd-MM-yyyy"),
                        new SimpleDateFormat("dd/MM/yyyy"))
        );
        String tmp;
        while(true){
            tmp = inputString(message, canNull);
            if (tmp == null && canNull){
                return null;
            }
            if (tmp.matches("\\d{1,2}-\\d{1,2}-\\d{4}")
                || tmp.matches("\\d{1,2}/\\d{1,2}/\\d{4}")){
                
            }else{
                System.err.println(errM_invalidDate);
                continue;
            }
            for (SimpleDateFormat pattern : sdfList){
                pattern.setLenient(true);
                try{
                    if (pattern.parse(tmp) != null){
                        date = pattern.parse(tmp);
                        return date;
                    }
                }catch(Exception e){
                    
                }
            }
            System.err.println(errM_invalidDate);
        }
    }
    public static String inputName(String message, boolean canNull){
        String result = "";
        
        while(true){
            System.out.print(message);
            try{
                result = in.nextLine();
                if (result.replaceAll("\\s+", "").isEmpty() && canNull){
                    return null;
                }else if (!canNull && result.replaceAll("\\s+", "").isEmpty()){
                    System.err.println(errM_null);
                    continue;
                }else if (!result.matches("[a-zA-Z\\s]+")){
                    System.err.println(errM_invalidName);
                    continue;
                }else{
                    break;
                }
            }catch(Exception e){
                System.err.println(errM);
            }
        }
        return result;
    }   
            
}
