package com.oolong.java3mtp.dto;

import java.util.Arrays;
import java.util.List;

/*
 * This class contains the data for the Employee table
 * It passes the table information to the GUI
 * The Data is populated by the service layer
 */

public class EmployeeDto implements Dto{
    private int id;
    private String lastName;
    private String firstname;
    private String title;
    private String birthDate;
    private String hireDate;
    private String address;
    private String city;
    private String phone;
    private int extension;
    private String notes;
    private String reportsTo;

    public EmployeeDto(int id, String lastName, String firstname,
                       String title, String birthDate, String hireDate,
                       String address, String city, String phone,
                       int extension, String notes, String reportsTo) {

        this.id = id;
        this.lastName = lastName;
        this.firstname = firstname;
        this.title = title;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.extension = extension;
        this.notes = notes;
        this.reportsTo = reportsTo;
    }

    @Override
    public List<Object> getData() {
        return Arrays.asList(
                id,
                lastName,
                firstname,
                title,
                birthDate,
                hireDate,
                address,
                city,
                phone,
                extension,
                reportsTo
        );
    }

    @Override
    public List<String> getColumnNames() {
        return List.of(
                "Id",
                "Last Name",
                "First Name",
                "Title",
                "Birth Day",
                "Hire Day",
                "Address",
                "City",
                "Phone",
                "Extension",
                "ReportsTo"
        );
    }
}
