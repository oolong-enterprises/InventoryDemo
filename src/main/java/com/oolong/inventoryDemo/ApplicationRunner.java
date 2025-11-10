package com.oolong.java3mtp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ApplicationRunner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationRunner.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        //load CSS
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/oolong/java3mtp/style.css")).toExternalForm());
        stage.setTitle("North Wind");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}