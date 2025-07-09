package com.hash.converter.components.convert;

import com.hash.converter.Globals;
import com.hash.converter.util.Registry;
import com.hash.converter.util.Types;
import com.hash.converter.util.Unit;
import com.hash.converter.util.Units;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;
import java.util.List;

public class Convert extends VBox {
    private final Text heading = new Text();
    private final FontIcon backIcon = new FontIcon(FontAwesomeSolid.ARROW_LEFT);
    private final Button backButton = new Button();
    private final FontIcon swapIcon = new FontIcon(FontAwesomeSolid.SYNC_ALT);
    private final Button swapButton = new Button();
    private final Region spacer = new Region();
    private final HBox topBar = new HBox(backButton, heading, spacer, swapButton);

    private final VBox fromBox = new VBox(10);
    private final VBox toBox = new VBox(10);

    private final ComboBox<String> fromList = new ComboBox<>();
    private final ComboBox<String> toList = new ComboBox<>();

    private final TextField fromField = new TextField(String.valueOf(1));
    private final TextField toField = new TextField();

    private final GridPane numberPad = new GridPane(10, 10);

    private Unit from;
    private Unit to;

    private final List<Unit> units;

    private final Color ICON_COLOR = Color.WHITE;
    private final int ICON_SIZE = 24;
    private final int FONT_SIZE = 14;
    private final int MIN_WIDTH = 400;

    public Convert(Types type) {
        this.backIcon.setIconColor(ICON_COLOR);
        this.backIcon.setIconSize(ICON_SIZE);
        this.backButton.setGraphic(backIcon);
        this.backButton.getStyleClass().add("back-button");

        this.swapIcon.setIconColor(ICON_COLOR);
        this.swapIcon.setIconSize(ICON_SIZE);
        this.swapButton.setGraphic(swapIcon);
        this.swapButton.getStyleClass().add("back-button");

        this.topBar.setAlignment(Pos.CENTER_LEFT);
        this.topBar.setSpacing(10);
        this.topBar.getStyleClass().add("top-bar");

        HBox.setHgrow(spacer, Priority.ALWAYS);

        this.heading.setText(type.name());
        this.heading.getStyleClass().add("heading");
        this.heading.setFont(Font.font("Comic Sans MS", FONT_SIZE));

        this.units = new ArrayList<>(Registry.getUnitsByType(type));

        this.fromList.getItems().addAll(units.stream().map(unit -> unit.getUnit().name() + " (" + unit.getSymbol() + ")").toList());
        this.fromList.setValue(units.getFirst().getUnit().name());
        this.fromList.setMaxWidth(Double.MAX_VALUE);
        this.fromList.getStyleClass().add("drop-down");

        this.toList.getItems().addAll(units.stream().map(unit -> unit.getUnit().name()).toList());
        this.toList.setValue(units.get(1).getUnit().name());
        this.toList.setMaxWidth(Double.MAX_VALUE);
        this.toList.getStyleClass().add("drop-down");

        this.from = Registry.map.get(units.getFirst().getUnit());
        this.to = Registry.map.get(units.get(1).getUnit());

        this.fromField.getStyleClass().add("text-field");
        this.toField.getStyleClass().add("text-field");

        fromBox.getChildren().addAll(fromList, fromField);
        toBox.getChildren().addAll(toList, toField);
        fromBox.getStyleClass().add("convertor-box");
        toBox.getStyleClass().add("convertor-box");
        fromBox.setMinWidth(MIN_WIDTH);
        toBox.setMinWidth(MIN_WIDTH);

        toField.setText(from.convert(1.0, Units.valueOf(getEnumValue(to.getUnit().name()))).toString());
        toField.setDisable(true);

        drawNumberPad();
        addListeners();

        numberPad.setAlignment(Pos.CENTER);

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(topBar, fromBox, toBox, numberPad);
        this.getStyleClass().add("background");
    }

    private void drawNumberPad() {
        numberPad.add(new NumberPadButton("7", () -> fromField.setText(fromField.getText() + "7")), 0, 0);
        numberPad.add(new NumberPadButton("8", () -> fromField.setText(fromField.getText() + "8")), 1, 0);
        numberPad.add(new NumberPadButton("9", () -> fromField.setText(fromField.getText() + "9")), 2, 0);
        numberPad.add(new NumberPadButton("AC", fromField::clear), 3, 0);
        numberPad.add(new NumberPadButton("4", () -> fromField.setText(fromField.getText() + "4")), 0, 1);
        numberPad.add(new NumberPadButton("5", () -> fromField.setText(fromField.getText() + "5")), 1, 1);
        numberPad.add(new NumberPadButton("6", () -> fromField.setText(fromField.getText() + "6")), 2, 1);
        numberPad.add(new NumberPadButton("⌫", () -> {
            if (!fromField.getText().isEmpty()) {
                fromField.setText(fromField.getText().substring(0, fromField.getLength() - 1));
            }
        }), 3, 1);
        numberPad.add(new NumberPadButton("1", () -> fromField.setText(fromField.getText() + "1")), 0, 2);
        numberPad.add(new NumberPadButton("2", () -> fromField.setText(fromField.getText() + "2")), 1, 2);
        numberPad.add(new NumberPadButton("3", () -> fromField.setText(fromField.getText() + "3")), 2, 2);
        numberPad.add(new NumberPadButton("00", () -> fromField.setText(fromField.getText() + "00")), 0, 3);
        numberPad.add(new NumberPadButton("0", () -> fromField.setText(fromField.getText() + "0")), 1, 3);
        numberPad.add(new NumberPadButton(".", () -> fromField.setText(fromField.getText() + ".")), 2, 3);
    }

    private void addListeners() {
        backButton.setOnAction(e -> {
            Globals.wrapper.getChildren().clear();
            Globals.wrapper.getChildren().add(Globals.typeSelector);
        });

        swapButton.setOnAction(e -> {
            String textValue = fromField.getText();
            fromField.setText(toField.getText());
            toField.setText(textValue);

            Unit unitValue = from;
            from = to;
            to = unitValue;

            fromList.setValue(from.getUnit().name());
            toList.setValue(to.getUnit().name());
        });

        fromList.setOnAction(e -> {
            from = Registry.map.get(Units.valueOf(getEnumValue(fromList.getValue())));
            toField.setText(from.convert(Double.parseDouble(fromField.getText()), to.getUnit()).toString());
        });

        toList.setOnAction(e -> {
            to = Registry.map.get(Units.valueOf(getEnumValue(toList.getValue())));
            toField.setText(from.convert(Double.parseDouble(fromField.getText()), to.getUnit()).toString());
        });

        fromField.textProperty().addListener((obs, oldText, newText) -> {
            try {
                double value;

                if (newText.isEmpty()) {
                    value = 0;
                } else {
                    value = Double.parseDouble(newText);
                }

                toField.setText(from.convert(value, to.getUnit()).toString());
            } catch (NumberFormatException e) {
                fromField.setText(oldText);
            }
        });
    }

    private String getEnumValue(String string) {
        return string.split(" ")[0];
    }
}
