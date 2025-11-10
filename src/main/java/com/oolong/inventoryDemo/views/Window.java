package com.oolong.java3mtp.views;

import com.oolong.java3mtp.dto.Dto;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Window {

    private Pane pane = new Pane();
    private final String title;

    public Window(String title) {
        this.title = title;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Dto data) {
        pane.getChildren().clear();
        VBox vbox = new VBox();

        List<Object> dataObj= data.getData();
        List<String> names= data.getColumnNames();

        for (int i = 0; i < dataObj.size(); i++) {
            Label nameLabel = new Label(names.get(i)+": ");
            nameLabel.setStyle("-fx-font-weight: bold");
            Label dataLabel = new Label(dataObj.get(i).toString());
            HBox box = new HBox();
            box.setPadding(new Insets(10, 10, 10, 10));
            box.getChildren().add(nameLabel);
            box.getChildren().add(dataLabel);
            vbox.getChildren().add(box);
        }
        pane.getChildren().add(vbox);
    }

    public void showWindow() {
        Scene scene = new Scene(pane, 900,500);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

}
