package oop.encapsulation;

public class Account {
    private String username;
    private String password;
    private boolean paid;

    public Account(String username, String password, boolean paid) {
        setUsername(username);
        setPassword(password);
        this.paid = paid;
    }

    public boolean login(String username, String password) {
        return checkCredentials(username, password);
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() > 5 && username.length() < 12) {
            this.username = username;
        } else {
            System.out.println("Username should be more than 5 characters and less than 12 characters.");
        }
    }

    public void setPassword(String password) {
        if (password.length() >= 8 && password.length() < 20) {
            this.password = password;
        } else {
            System.out.println("Password should be more than 8 characters and less than 20 characters.");
        }
    }

    private boolean checkCredentials(String username, String password) {
        if (!username.equals(this.username)) {
            System.out.println("Invalid username.");
            return false;
        }
        if (!password.equals(this.password)) {
            System.out.println("Invalid password.");
            return false;
        }
        System.out.println("logged in successfully.");
        return true;
    }
}
