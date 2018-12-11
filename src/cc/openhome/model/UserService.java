package cc.openhome.model;/*
 * created by on 12/10/18
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class UserService {
    private LinkedList<Blah> newest = new LinkedList<Blah>();
    private String users;
    private AccountDAO accountDAO;
    private BlahDAO blahDAO;

    public UserService (String users,AccountDAO userDAO,BlahDAO blahDAO){
        this(userDAO,blahDAO);
        this.users = users;

    }
    public UserService(AccountDAO userDAO,BlahDAO blahDAO){
        this.accountDAO = userDAO;
        this.blahDAO = blahDAO;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public BlahDAO getBlahDAO() {
        return blahDAO;
    }

    public boolean isInvalidEmail(String email){
        return email == null || !email.matches("^[_a-z0-9-]+([.]"
                +"[_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
    }

    public boolean isInvalidPassword(String password, String confirmedPasswd){
        return password == null ||
                password.length() < 6 ||
                password.length() > 16 ||
                !password.equals(confirmedPasswd);
    }
    public boolean isUserExisted(Account account){
        return accountDAO.isUserExisted(account);
    }

    public void add(Account account){
        accountDAO.addAccount(account);
    }

    public void delete(Account account) {accountDAO.deleteAccount(account);}

    public boolean checkLogin(Account account){
        if(account.getName() != null &&
         account.getPassword() != null){
            Account storeAcct = accountDAO.getAccount(account);
            return storeAcct != null && storeAcct.getPassword().equals(account.getPassword());
        }
        return  false;
    }

    private class DateComparator implements Comparator<Blah>{
        @Override
        public int compare(Blah b1, Blah b2) {
            return -b1.getDate().compareTo(b2.getDate());
        }
    }

    private DateComparator comparator = new DateComparator();

    public List<Blah> getBlahs(Blah blah){
        List<Blah> blahs = blahDAO.getBlahs(blah);
        Collections.sort(blahs,comparator);
        return blahs;
    }

    public void addBlah(Blah blah){
        blahDAO.addBlah(blah);
        newest.addFirst(blah);
        if(newest.size() > 20){
            newest.removeLast();
        }
    }

    public void deleteBlah(Blah blah){
        blahDAO.deleteBlah(blah);
        newest.remove(blah);
    }

    public List<Blah> getNewest(){
        return newest;
    }
}
