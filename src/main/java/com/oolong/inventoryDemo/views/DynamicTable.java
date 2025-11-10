package com.oolong.java3mtp.views;

import com.oolong.java3mtp.services.Service;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import com.oolong.java3mtp.dto.Dto;
import java.util.List;

/*
* Creates a tableview from a list of objects that extend Dto
* It automatically builds a table using the column names in the Dto object
* and fills the rows with data from the Dto
*
* This allows the UI to display data different datasets,
* without hard coding the structure
 */
public class DynamicTable {

    private Service<Dto> service;

    public DynamicTable() {
    }


    // Builds and returns a populated TableView using any Dto
    public TableView<List<Object>> populateTable(List<? extends Dto> data) {
        TableView<List<Object>> table = new TableView<>();

        if (!data.isEmpty()) {

            //get the column name
            List<String> columnNames = data.get(0).getColumnNames();

            // create a column for each name
            for (int i = 0; i < columnNames.size(); i++) {
                final int index = i;

                TableColumn<List<Object>, Object> col = new TableColumn<>(columnNames.get(i));
                col.setCellValueFactory(cellData ->
                        new ReadOnlyObjectWrapper<>(cellData.getValue().get(index))
                );
                table.getColumns().add(col);
            }

            //fill the table with data
            ObservableList<List<Object>> tableData = FXCollections.observableArrayList();
            for (Dto dto : data) {
                tableData.add(dto.getData());
            }

            table.setItems(tableData);
        }

        table.setRowFactory(tv -> {
            TableRow<List<Object>> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    List<Object> rowData = row.getItem();
                    Dto dto = data.get(table.getItems().indexOf(rowData));

                    Window window = new Window("title");
                    window.setPane(dto);
                    window.showWindow();
                }
            });
            return row;
        });


        //table properties for the GUI
        table.setMinWidth(700);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        return table;
    }
}
