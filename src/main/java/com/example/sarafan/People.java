package com.example.sarafan;

public class People {
    private int id;
    private String surname;
    private String name;
    private String secondName;
    private String fateOfBirth;
    private String gender;

    public People(int id, String q, String w, String e, String r, String t) {
        this.id = id;
        this.secondName =e;
        this.surname = q;
        this.name = w;
        this.fateOfBirth = r;
        this.gender = t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFateOfBirth() {
        return fateOfBirth;
    }

    public void setFateOfBirth(String fateOfBirth) {
        this.fateOfBirth = fateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
