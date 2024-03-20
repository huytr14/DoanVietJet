package com.sinhvien.doan.Class;

public class User {
    String phonenumber,fullname,email,birthday,profession,gender;

    public User() {
    }

    public User(String phonenumber, String fullname, String email, String birthday, String profession,String gender) {
        this.phonenumber = phonenumber;
        this.fullname = fullname;
        this.email = email;
        this.birthday = birthday;
        this.profession = profession;
        this.gender=gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getProfession() {
        return profession;
    }

    public String getGender() {
        return gender;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
