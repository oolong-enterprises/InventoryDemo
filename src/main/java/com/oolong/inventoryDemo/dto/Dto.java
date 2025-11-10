package com.oolong.java3mtp.dto;

import java.util.List;


/*
        * This interface helps pass data from the database to the UI.
        * The UI elements are set to accept the Dto interface and can be passed any class implementing Dto
        * Any Dto object should be created by first implementing this class
 */
public interface Dto {
    public List<Object> getData();
    public List<String> getColumnNames();
}
