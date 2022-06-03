package application.DataClasses;

import java.util.ArrayList;

public class Student {
    private String id;
    private String dob;
    private char gender;
    private String name;
    private String address;
    private String password;
    private String egPhoneNumber;
    private ArrayList<Books> needBooks;

    public Student() {
        needBooks = new ArrayList<>();
    }

    public Student(String id, String dob, char gender, String name, String address, String password, String egPhoneNumber) {
        this();
        this.id = id;
        this.dob = dob;
        this.gender = gender;
        this.name = name;
        this.address = address;
        this.password = password;
        this.egPhoneNumber = egPhoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Books> getNeedBooks() {
        return needBooks;
    }

    public void setNeedBooks(ArrayList<Books> needBooks) {
        this.needBooks = needBooks;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEgPhoneNumber() {
        return egPhoneNumber;
    }

    public void setEgPhoneNumber(String egPhoneNumber) {
        this.egPhoneNumber = egPhoneNumber;
    }
}
