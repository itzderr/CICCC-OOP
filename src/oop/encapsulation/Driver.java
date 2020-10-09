package oop.encapsulation;

// Account
// + username: String, password: String
// + login(String username, String password)
public class Driver {
    public static void main(String[] args) {
        Account acct1 = new Account("abc123", "123", true);
        acct1.login("abc12311", "123");

        System.out.println(acct1.getUsername());
        acct1.setUsername("abcde123");
        System.out.println(acct1.getUsername());
        acct1.setPassword("213");

    }
}
