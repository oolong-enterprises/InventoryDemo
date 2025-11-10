package com.oolong.java3mtp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/*
* The main window of the program
* This window gets populated from the MenuOption class,
* to edit views shown as options change the map on MenuOptions
 */

public class MainViewController {

    @FXML
    private ScrollPane menuPane;
    @FXML
    private AnchorPane mainViewPane;

    public void initialize() {
        List<String> options = new ArrayList<String>(
                MenuOptions.getOptions().keySet());

        VBox vbox = new VBox();

        //populate the view selection menu for the GUI
        options.forEach(option ->{

            Button button = new Button(option);
            button.setMinWidth(150);
            button.setMaxWidth(150);
            button.setMinHeight(60);
            vbox.setSpacing(15);
            vbox.getChildren().add(button);


            //show view when button is pressed
            button.setOnAction(event -> {
               mainViewPane.getChildren().clear();
               mainViewPane.getChildren()
                       .add(MenuOptions.getOptions().get(option).getPane());
            });

        });

        menuPane.setContent(vbox);

    }
}