package cc.openhome.model;/*
 * created by on 12/10/18
 */

public interface AccountDAO {
    boolean isUserExisted(Account account);
    void addAccount(Account account);
    Account getAccount(Account account);
    void deleteAccount(Account account);
}
