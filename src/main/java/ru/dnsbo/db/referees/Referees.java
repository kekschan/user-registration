package ru.dnsbo.db.referees;

public class Referees {
    private Integer id;
    private String secondName;
    private String name;
    private String email;
    private String password;

    public Referees(){

    }

    public Referees(Integer id, String secondName, String name, String email, String password) {
        this.id = id;
        this.secondName = secondName;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Referees(String secondName, String name, String email, String password) {
        this.secondName = secondName;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Referees(String secondName, String name, String password) {
        this.secondName = secondName;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
