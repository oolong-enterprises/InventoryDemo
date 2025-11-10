package com.oolong.java3mtp.services;

import com.oolong.java3mtp.dto.CustomerDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CustomerService extends Service<CustomerDto> {

    //base query and search options,
    //search options are shown as radio menu on UI
    public CustomerService() {
        super("SELECT * FROM java3mtp.customers ",

                Map.of(
                        "Id", "CustomerId",
                        "Company Name", "CompanyName",
                        "Contact Name", "ContactName",
                        "Address", "Address",
                        "Phone Number", "phone",
                        "Fax", "Fax"
                ));
    }


    //helper class to build row data to a Dto for the GUI to show
    @Override
    protected CustomerDto createRow(ResultSet resultSet) throws SQLException {
        return new CustomerDto(
                resultSet.getString("CustomerID"),
                resultSet.getString("CompanyName"),
                resultSet.getString("ContactName"),
                resultSet.getString("ContactTitle"),
                resultSet.getString("Address"),
                resultSet.getString("City"),
                resultSet.getString("Region"),
                resultSet.getString("PostalCode"),
                resultSet.getString("Country"),
                resultSet.getString("Phone"),
                resultSet.getString("Fax")
        );
    }
}
