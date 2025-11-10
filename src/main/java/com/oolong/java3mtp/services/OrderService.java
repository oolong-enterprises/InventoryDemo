package com.oolong.java3mtp.services;
import com.oolong.java3mtp.dto.OrderDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OrderService extends Service<OrderDto> {

    //base query and search options,
    //search options are shown as radio menu on UI
    public OrderService() {
        super(
                "SELECT \n" +
                        "    o.OrderID, \n" +
                        "    o.OrderDate, \n" +
                        "    o.Freight, \n" +
                        "    p.ProductName, \n" +
                        "    d.Quantity, \n" +
                        "    d.UnitPrice, \n" +
                        "    d.Discount\n" +
                        "FROM java3mtp.orders o\n" +
                        "JOIN java3mtp.`order details` d ON o.OrderID = d.OrderID\n" +
                        "JOIN java3mtp.products p ON p.ProductID = d.ProductID ",

                Map.of(
                        "Id", "o.OrderId",
                        "Customer", "CustomerID",
                        "Order Date", "o.OrderDate",
                        "Required Date", "o.RequireDate",
                        "Shipped Date", "o.ShippedDate"
                ));
    }


    //helper class to build row data to a Dto for the GUI to show
    @Override
    protected OrderDto createRow(ResultSet resultSet) throws SQLException {
        return new OrderDto(
                resultSet.getInt("orderID"),
                resultSet.getString("orderDate"),
                resultSet.getDouble("freight"),
                resultSet.getString("productName"),
                resultSet.getInt("quantity"),
                resultSet.getDouble("unitPrice"),
                resultSet.getDouble("discount")
        );
    }

    //Unique method for orderService
    //Custom logic for order view
    //returns the total for the order in the UI search bar
    public double calcTotal(String orderId){
        String query = """
        SELECT SUM(d.Quantity * d.UnitPrice * (1 - d.Discount)) AS OrderTotal
        FROM java3mtp.orders o
        JOIN java3mtp.`order details` d ON o.OrderID = d.OrderID
        WHERE o.OrderID = ?
        GROUP BY o.OrderID
        """;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("OrderTotal");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

}
