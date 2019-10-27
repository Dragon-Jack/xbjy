package com.dfbz.entity;

public class User {
    private Integer id;
    private String name;
    private String account;
    private String pw;
    private Integer age;
    private String born;

    public User() {
    }

    public User(Integer id, String name, String account, String pw, Integer age, String born) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.pw = pw;
        this.age = age;
        this.born = born;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", pw='" + pw + '\'' +
                ", age=" + age +
                ", born='" + born + '\'' +
                '}';
    }
}
