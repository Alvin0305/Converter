package com.hash.converter.components.convert;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class NumberPadButton extends Button {
    private final int BUTTON_SIZE = 50;

    public NumberPadButton(String value, Runnable onClick) {
        this.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
        this.getStyleClass().add("num-pad-button");

        if (value.equals("AC")) {
            this.getStyleClass().add("num-pad-action-button");
        }

        if (value.equals("⌫")) {
            FontIcon backspaceIcon = new FontIcon(FontAwesomeSolid.BACKSPACE);
            backspaceIcon.setIconColor(Color.WHITE);
            this.setGraphic(backspaceIcon);
        } else {
            this.setText(value);
        }

        this.setOnAction(e -> onClick.run());
    }
}
