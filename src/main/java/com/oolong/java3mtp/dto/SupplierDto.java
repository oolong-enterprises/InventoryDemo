package com.oolong.java3mtp.dto;

import java.util.Arrays;
import java.util.List;

/*
 * This class contains the data for the Supplier table
 * It passes the table information to the GUI
 * The Data is populated by the service layer
 */

public class SupplierDto implements Dto{

    private int Id;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String webSite;

    public SupplierDto(int Id, String companyName, String contactName,
                       String contactTitle, String address, String city,
                       String region, String postalCode, String country,
                       String phone, String fax, String webSite) {

        this.Id = Id;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
        this.webSite = webSite;
    }

    @Override
    public List<Object> getData() {
        return Arrays.asList(
                Id,
                companyName,
                contactName,
                contactTitle,
                address,
                city,
                region,
                postalCode,
                country,
                phone,
                fax
        );
    }

    @Override
    public List<String> getColumnNames() {
        return List.of(
                "Customer Id",
                "Company Name",
                "Contact Name",
                "Contact Title",
                "Address",
                "City",
                "Region",
                "Postal Code",
                "Country",
                "Phone",
                "Fax"
        );
    }
}
