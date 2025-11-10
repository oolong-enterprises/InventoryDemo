package com.oolong.java3mtp.views;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import com.oolong.java3mtp.dto.OrderDto;
import com.oolong.java3mtp.services.OrderService;

/*
* custom view pane for the order data set
* this view pane adds the getTotal button that calls calcTotal() from OrderService
 */
public class OrderView extends ViewPane<OrderDto> {

    public OrderView(String title, OrderService orderService) {
        super(title, orderService);

        //set up button
        Button getTotal  = new Button("Get Total");

        //when clicked query service and create pop up
        getTotal.setOnAction(e -> {
            String searchText = getSearchBar().getSearch();
            double total = orderService.calcTotal(searchText);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText("Order Total");
            alert.setContentText("Total: " + total);
            alert.showAndWait();

        });

        //add button to view
        addToView(getTotal);
    }

}
