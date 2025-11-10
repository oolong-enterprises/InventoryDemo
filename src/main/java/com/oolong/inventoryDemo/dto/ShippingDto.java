package com.oolong.java3mtp.dto;


import java.util.List;

/*
 * This class contains the data for the Shipping table
 * It passes the table information to the GUI
 * The Data is populated by the service layer
 */

public class ShippingDto implements Dto{
    private int id;
    private String name;
    private String phone;

    public ShippingDto(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public List<Object> getData() {
        return List.of(
                id,
                name,
                phone
        );
    }

    @Override
    public List<String> getColumnNames() {
        return List.of(
                "ID",
                "Name",
                "Phone"
        );
    }
}
