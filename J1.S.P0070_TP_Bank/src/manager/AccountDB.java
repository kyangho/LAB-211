
package manager;

import entity.Account;
import java.util.ArrayList;


public class AccountDB {
    private ArrayList<Account> accountList = new ArrayList<>();

    public AccountDB() {
        create();
    }
    private void create(){
        accountList.add(new Account("1234567890", "quangbx123"));
        accountList.add(new Account("1231231231", "quangbx123"));
        accountList.add(new Account("2342342342", "quangbx123"));
        accountList.add(new Account("3453453453", "quangbx123"));
        accountList.add(new Account("4564564564", "quangbx123"));
        accountList.add(new Account("5675675675", "quangbx123"));
    }
    public boolean checkAccount(Account inputAcc){
        for (Account a : accountList){
            if (a.equals(inputAcc)){
                return true;
            }
        }
        return false;
    }
}
