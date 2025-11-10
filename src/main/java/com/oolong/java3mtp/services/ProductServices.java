package com.oolong.java3mtp.services;

import com.oolong.java3mtp.dto.ProductDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ProductServices extends Service<ProductDto> {

    //base query and search options,
    //search options are shown as radio menu on UI
    public ProductServices() {
        super("SELECT \n" +
                "\tp.ProductID,\n" +
                "    p.ProductName,\n" +
                "    s.CompanyName,\n" +
                "    c.CategoryName,\n" +
                "    p.QuantityPerUnit,\n" +
                "    p.UnitPrice,\n" +
                "    p.UnitsInStock,\n" +
                "    p.UnitsOnOrder,\n" +
                "    p.ReorderLevel,\n" +
                "    p.Discontinued\n" +
                "FROM java3mtp.products p\n" +
                "Join java3mtp.suppliers s on p.SupplierID = s.SupplierID\n" +
                "Join java3mtp.categories c on p.CategoryID = c.CategoryID ",

                Map.of(
                        "Id", "p.productId",
                        "Product Name", "p.ProductName",
                        "Company Name", "s.CompanyName",
                        "Category", "c.CategoryName"
                ));
    }


    //helper class to build row data to a Dto for the GUI to show
    @Override
    protected ProductDto createRow(ResultSet resultSet) throws SQLException {
        return new ProductDto(
                resultSet.getInt("ProductID"),
                resultSet.getString("ProductName"),
                resultSet.getString("CompanyName"),
                resultSet.getString("CategoryName"),
                resultSet.getString("QuantityPerUnit"),
                resultSet.getDouble("UnitPrice"),
                resultSet.getInt("UnitsInStock"),
                resultSet.getInt("UnitsOnOrder"),
                resultSet.getInt("ReorderLevel"),
                resultSet.getBoolean("Discontinued")
        );
    }
}
