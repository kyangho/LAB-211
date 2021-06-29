package util;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    static String errM_null = "Input can not be null!";
    static String errM = "Invalid input! Enter again!";
    static String errM_positiveInt = "Number entered must be positive number!";
    static String errM_intNumber = "Number entered must be integer number!";
    static String errM_floatNumber = "Number entered must be real number!";
    static String errM_notNumber = "This is not a number!";
    static String errM_invalidDate = "Date entered is not valid";
    static String errM_invalidName = "This name is not valid";
    static DecimalFormat format = new DecimalFormat("0.##");
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
                System.err.println(errM_notNumber);
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
                }else if (tmp.matches("[0-9]+[.]+") || tmp.matches("-[0-9]+[.]+") && canNegative){
                    System.err.println(errM);
                    continue;
                }else if (Double.parseDouble(tmp) == Double.parseDouble(tmp)){
                    break;
                }
               
            }catch(NumberFormatException e){
                System.err.println(errM_notNumber);
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
    public static Integer inputIntLimit(int first, int end,String message ,boolean canNull){
        Integer input;
        while(true){
            input = inputInteger(message, canNull, true);
            if (canNull && input == null){
                    return null;
            }
            if (!canNull && input == null){
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
        //Input int in interval[first, end]
    /**
     * @param first
     * @param end
     * @return 
     */
    public static Double inputDoubleLimit(double first, double end, boolean canNull, String message){
        Double input;
        
        while(true){
            input = inputDouble(message, canNull, true);
            if (canNull && input == null){
                    return null;
            }
            if (!canNull && input == null){
                    continue;
            }
            if (first <= input.doubleValue() && input.doubleValue() <= end){
                return input;
            }else{
                if (first != end) System.err.printf("Enter a number from %s to %s!\n", format.format(first), format.format(end));
                else System.err.printf("A number valiable is %s!\n", format.format(end));
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
            if (s.trim().compareToIgnoreCase("yes") == 0 || s.trim().compareToIgnoreCase("y") == 0){
                return true;
            }
            if (s.trim().compareToIgnoreCase("no") == 0 || s.trim().compareToIgnoreCase("n") == 0){
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
    //Check if input date is validate or not
    public static String inputDate(String message, boolean canNull){
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String tmp;
        sdf.setLenient(false);
        while(true){
            try{
                tmp = inputString(message, canNull);
                if (tmp == null && canNull){
                    return null;
                }
                if (sdf.parse(tmp) != null){
                    date = sdf.parse(tmp);
                    break;
                }
            }catch(Exception e){
                System.err.println(errM_invalidDate);
            }
        }
        return sdf.format(date);
    }
    //
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
                    System.out.println(errM_invalidName);
                    continue;
                }else{
                    break;
                }
            }catch(Exception e){
                System.err.println(errM);
            }
        }
        return beautyName(result);
    }
}
