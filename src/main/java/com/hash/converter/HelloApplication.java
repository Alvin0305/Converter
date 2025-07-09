package com.hash.converter;

import com.hash.converter.components.typeselector.TypeSelector;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        StackPane wrapper = new StackPane(new TypeSelector());
        Globals.wrapper = wrapper;
        wrapper.getStyleClass().add("wrapper");

        Scene scene = new Scene(wrapper);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        Font.loadFont(getClass().getResourceAsStream("/fonts/Comic_Sans_MS.ttf"), 12);
        stage.setTitle("Converter!");
        stage.setScene(scene);

        wrapper.getChildren().addListener((ListChangeListener<? super Node>) change -> {
            stage.sizeToScene();
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}