package pl.valvar.models;

import java.util.List;
public class User {
    private Integer id;
    private String nickName;
    private String email;
    private String password;

    public User(Integer id, String firstName, String lastName,String password) {
        this.id = id;
        this.nickName = firstName;
        this.email = lastName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return nickName;
    }

    public void setFirstName(String firstName) {
        this.nickName = firstName;
    }

    public String getLastName() {
        return email;
    }

    public void setLastName(String lastName) {
        this.email = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
