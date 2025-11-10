package com.oolong.java3mtp.views;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import com.oolong.java3mtp.dto.Dto;
import com.oolong.java3mtp.services.Service;

import java.util.ArrayList;
import java.util.List;

/*
*Builds a reusable search bar for the UI
* creates search options from the service that gets passed as an argument
*
* provides the user with a search button that populates the table on the GUI
 */

public class SearchBar<T extends Dto> {

    private final Service<T> service;
    private final ViewPane viewPane;
    private final TextField search = new TextField();

    public SearchBar(Service<T> service, ViewPane viewPane) {
        this.service = service;
        this.viewPane = viewPane;
    }

    // Builds the HBox containing the search bar UI
    public HBox buildSearchBar() {
        HBox box = new HBox();
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER);

        // Create radio buttons for each search option
        List<String> options = new ArrayList<>(service.getSearchOptions().keySet());
        ToggleGroup group = new ToggleGroup();

        for (String option : options) {
            RadioButton rb = new RadioButton(option);
            rb.setToggleGroup(group);
            box.getChildren().add(rb);
        }

        search.setPromptText("Search");
        search.setMinWidth(150);

        Button searchButton = new Button("Search");
        Button clearButton = new Button("Clear");

        searchButton.setOnAction(e -> {
            String searchText = search.getText();
            RadioButton selected = (RadioButton) group.getSelectedToggle();
            if (selected != null) {
                String selectedName = selected.getText();
                viewPane.updateTable(service.search(selectedName, searchText));
            }
        });

        clearButton.setOnAction(e -> clear());

        box.getChildren().addAll(search, searchButton, clearButton);
        return box;
    }

    // returns the current text in the search field
    public String getSearch() {
        return search.getText();
    }

    // clears the search field and resets the table
    public void clear() {
        search.clear();
        viewPane.updateTable(service.getAll());
    }
}