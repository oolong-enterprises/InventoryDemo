package com.oolong.java3mtp;

import com.oolong.java3mtp.dto.Dto;
import com.oolong.java3mtp.services.*;
import com.oolong.java3mtp.views.OrderView;
import com.oolong.java3mtp.views.ViewPane;

import java.util.LinkedHashMap;
import java.util.Map;
/*
* This class holds a mapping of menu names to their view panes
* The list corresponds to the menu of views on the UI
* ViewPane will dynamically populate the view from the Service argument
 */
public class MenuOptions {

    public static Map<String, ViewPane<? extends Dto>> getOptions() {
        Map<String, ViewPane<? extends Dto>> map = new LinkedHashMap<>();
        map.put("Orders", new OrderView("Orders", new OrderService()));
        map.put("Customers", new ViewPane<>("Customers", new CustomerService()));
        map.put("Employees", new ViewPane<>("Employees", new EmployeeService()));
        map.put("Products", new ViewPane<>("Products", new ProductServices()));
        map.put("Shippers", new ViewPane<>("Shippers", new ShippingService()));
        map.put("Suppliers", new ViewPane<>("Suppliers", new SupplierService()));
        return map;
    }
}