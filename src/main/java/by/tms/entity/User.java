package by.tms.entity;

public class User {
    private static int incId = 1;
    private int id = incId++;

    private String password;
    private String name;
    private String login;

    public User(int id, String password, String name, String login) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.login = login;
    }

    public User(String password, String name, String login) {
        this.password = password;
        this.name = name;
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
