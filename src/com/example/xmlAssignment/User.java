package com.example.xmlAssignment;

public class User {
    public User() {
    }

    private Integer StdID;
    private String fullname;
    private Integer age;
    private String ProgrammingLanguage;

    public Integer getStdID() {
        return StdID;
    }

    public void setStdID(Integer stdID) {
        this.StdID = stdID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProgrammingLanguage() {
        return ProgrammingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        ProgrammingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + StdID +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", ProgrammingLanguage='" + ProgrammingLanguage + '\'' +
                '}';
    }
}
