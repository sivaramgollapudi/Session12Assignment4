package com.sivaram.session12assignment4;

/**
 * Created by User on 05/10/2017.
 */

public class PersonInfo {
    private String Name;
    private String ContactNumber;
    private String DateOfBirth;

    public PersonInfo(String name, String contactNumber, String dateOfBirth) {
        Name = name;
        ContactNumber = contactNumber;
        DateOfBirth = dateOfBirth;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
}
