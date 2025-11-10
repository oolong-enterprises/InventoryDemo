package com.oolong.java3mtp.views;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import com.oolong.java3mtp.dto.Dto;
import com.oolong.java3mtp.services.Service;

import java.util.List;

/*
* the ViewPane class is a reusable class for the main UI view
* it holds a title, a searchBar and a dynamic table
*
* it can hold additional elements by extending the class,
* and adding to the container Hbox from the addToView() method
 */
public class ViewPane<T extends Dto> {

    private final Pane pane = new Pane();
    private final VBox vbox = new VBox();
    private TableView<List<Object>> table;
    private final SearchBar<T> searchBar;

    // optional extra controls or elements
    private final HBox container = new HBox();

    public ViewPane(String title, Service<T> service) {

        // Populate table with all data from the service
        table = new DynamicTable().populateTable(service.getAll());

        // Build search bar
        HBox searchBarContainer = new HBox();
        searchBar = new SearchBar<>(service, this);
        searchBarContainer.getChildren().add(searchBar.buildSearchBar());

        // Title label
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("sheetTitle");
        titleLabel.setFont(new Font("Arial", 26));

        // Configure main layout
        vbox.setPrefWidth(1000);
        vbox.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(table, Priority.ALWAYS);

        // Add elements to layout
        vbox.getChildren().addAll(titleLabel, searchBarContainer, container, table);
        pane.getChildren().addAll(vbox);
    }

    // Add extra elements to the container HBox
    public void addToView(Node node) {
        container.getChildren().add(node);
    }

    public Pane getPane() {
        return pane;
    }

    public SearchBar<T> getSearchBar() {
        return searchBar;
    }

    // Updates the table with new data
    public void updateTable(List<T> data) {
        vbox.getChildren().remove(table);
        table = new DynamicTable().populateTable(data);
        VBox.setVgrow(table, Priority.ALWAYS);
        vbox.getChildren().add(table);
    }
}