package com.oolong.java3mtp.dto;

import java.util.List;

/*
 * This class contains the data for the Order table
 * It passes the table information to the GUI
 * The Data is populated by the service layer
 */

public class OrderDto implements Dto{

    private int orderId;
    private String orderDate;
    private double freightCharge;
    private String productName;
    private int quantity;
    private double price;
    private double discount;

    public OrderDto(int orderId, String orderDate, double freightCharge,
                    String productName, int quantity,
                    double price, double discount) {

        this.orderId = orderId;
        this.orderDate = orderDate;
        this.freightCharge = freightCharge;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public List<Object> getData(){
        return List.of(
                orderId,
                orderDate,
                freightCharge,
                productName,
                quantity,
                price,
                discount
        );
    }


    @Override
    public List<String> getColumnNames() {
        return List.of("Order ID", "Order Date", "Freight",
                "Product Name", "Quantity", "Price", "Discount");
    }

}
