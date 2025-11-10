package com.oolong.java3mtp.services;

import com.oolong.java3mtp.dto.SupplierDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class SupplierService extends Service<SupplierDto> {

    //base query and search options,
    //search options are shown as radio menu on UI
    public SupplierService() {
        super("SELECT * FROM java3mtp.suppliers ",

                Map.of(
                        "Id", "SupplierId",
                        "Company Name", "CompanyName",
                        "Contact Name", "ContactName",
                        "Address", "Address",
                        "Phone Number", "phone",
                        "Fax", "Fax"
                ));
    }


    //helper class to build row data to a Dto for the GUI to show
    @Override
    protected SupplierDto createRow(ResultSet resultSet) throws SQLException {
        return new SupplierDto(
                resultSet.getInt("SupplierID"),
                resultSet.getString("CompanyName"),
                resultSet.getString("ContactName"),
                resultSet.getString("ContactTitle"),
                resultSet.getString("Address"),
                resultSet.getString("City"),
                resultSet.getString("Region"),
                resultSet.getString("PostalCode"),
                resultSet.getString("Country"),
                resultSet.getString("Phone"),
                resultSet.getString("Fax"),
                resultSet.getString("HomePage")
        );
    }
}
