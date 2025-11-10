package com.oolong.java3mtp.services;

import com.oolong.java3mtp.DbConnector;
import com.oolong.java3mtp.dto.Dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* The base class for all database service classes.
* It handles shared functionality like connecting to the database, running queries,
* and building lists of DTO objects
* Each service extends this class and implements its on createRow(),
* that converts each Db row into a Dto object
*/

public abstract class Service<T extends Dto> {

    //Db connection provided by DbConnector
    protected Connection connection = DbConnector.getConnection();

    //base query and search options
    protected String query;
    protected Map<String, String> searchOptions;

    //constructor the sets up query and search options from subclass
    public Service(String query, Map<String, String> searchOptions) {
        this.query = query;
        this.searchOptions = searchOptions;
    }

    //converts row into Dto object
    protected abstract T createRow(ResultSet resultSet) throws SQLException;


    public Map<String, String> getSearchOptions() {
        return searchOptions;
    }


    //runs a search query using the selected items from the GUI
    public List<Dto> search(String selectedOption, String input) {
        List<Dto> data = new ArrayList<>();


        //build custom search query
        String searchQuery = query + " WHERE " + "LOWER(" + searchOptions.get(selectedOption) + ") "
                + " LIKE '%" + input + "%' ";


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);

            while (resultSet.next()) {
                T row = createRow(resultSet);
                data.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    //returns all data from the table
    public List<Dto> getAll(){
        List<Dto> data = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                T row = createRow(resultSet);
                data.add(row);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
