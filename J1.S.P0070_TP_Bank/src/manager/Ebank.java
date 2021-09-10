
package manager;

import entity.Account;
import java.util.ArrayList;
import view.Validation;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ebank {
    Locale locale;
    ArrayList<Account> accList;
    public Ebank(){

    }
    public Ebank(Locale locale){
        this.accList = accList;
    }
    public void setLocale(Locale locale){
        this.locale = locale;
    }
    public String checkAccountNumber(String accountNumber){
        if (accountNumber.matches("[\\d]{10}")) return accountNumber;
        return null;
    }

    public String checkPassword(String password){
        Pattern pattern = Pattern.compile("\\w{8,31}");
        Matcher matcher = pattern.matcher(password);
        if (!Validation.hasNumeric(password)) return null;
        if (matcher.matches()) return password;
        return null;
    }
    public String generateCaptcha(){
        String tmpCaptcha = "";
        for (char c = 'a'; c <= 'z'; c++) tmpCaptcha += c + "";
        for (char c = 'A'; c <= 'Z'; c++) tmpCaptcha += c + "";
        for (char c = '0'; c <= '9'; c++) tmpCaptcha += c + "";
        Random rn = new Random();
        String captcha = "";
        for (int i = 0; i < 4 + rn.nextInt(3); i++){
            captcha = captcha + tmpCaptcha.charAt(rn.nextInt(tmpCaptcha.length()));
        }
        return captcha;
    }
    public String checkCaptcha(String captchaInput, String captchaGenerate){    
        if (captchaGenerate.length() != captchaInput.length()) return null;
        if (!captchaGenerate.contains(captchaInput)){
            return null;
        }
        return captchaInput;
    }
}
