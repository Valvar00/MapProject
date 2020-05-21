package pl.valvar.models;

import java.util.List;
public class User {
    private Integer id;
    private String nickName;
    private String email;
    private String password;
    private String University="";
    private String City="";
    private int Kilometers=0;

    public User(Integer id, String firstName, String lastName,String password) {
        this.id = id;
        this.nickName = firstName;
        this.email = lastName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public User(Integer id, String nickName, String email, String password, String university, String city, int kilometers) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        University = university;
        City = city;
        Kilometers = kilometers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getKilometers() {
        return Kilometers;
    }

    public void setKilometers(int kilometers) {
        Kilometers = kilometers;
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
