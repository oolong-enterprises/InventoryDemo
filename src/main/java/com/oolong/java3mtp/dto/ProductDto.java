package com.oolong.java3mtp.dto;

import java.util.List;

/*
 * This class contains the data for the Product table
 * It passes the table information to the GUI
 * The Data is populated by the service layer
 */

public class ProductDto implements Dto{
    private int id;
    private String name;
    private String companyName;
    private String categoryName;
    private String quantity;
    private double price;
    private int inStock;
    private int onOrder;
    private int reorderLevel;
    private boolean discontinued;

    public ProductDto(int id, String name, String companyName,
                      String categoryName, String quantity,
                      double price, int inStock, int onOrder,
                      int reorderLevel, boolean discontinued) {

        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.categoryName = categoryName;
        this.quantity = quantity;
        this.price = price;
        this.inStock = inStock;
        this.onOrder = onOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    @Override
    public List<Object> getData() {
        return List.of(
                id,
                name,
                categoryName,
                companyName,
                quantity,
                price,
                inStock,
                onOrder,
                reorderLevel,
                discontinued
        );
    }

    @Override
    public List<String> getColumnNames() {
        return List.of(
                "ID",
                "Name",
                "Category",
                "Company Name",
                "Quantity per Unit",
                "Unit Price",
                "Units in Stock",
                "Units on Order",
                "Reorder Level",
                "Discontinued"
        );
    }
}
