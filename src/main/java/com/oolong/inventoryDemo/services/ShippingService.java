package com.oolong.java3mtp.services;

import com.oolong.java3mtp.dto.ShippingDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ShippingService extends Service<ShippingDto> {

    //base query and search options,
    //search options are shown as radio menu on UI
    public ShippingService() {
        super("SELECT * FROM java3mtp.shippers ",

                Map.of(
                        "Id", "shipperId",
                        "Name", "CompanyName",
                        "Phone Number", "Phone"
                ));
    }


    //helper class to build row data to a Dto for the GUI to show
    @Override
    protected ShippingDto createRow(ResultSet resultSet) throws SQLException {
        return new ShippingDto(
                resultSet.getInt("ShipperID"),
                resultSet.getString("CompanyName"),
                resultSet.getString("Phone")
        );
    }
}
