package com.hash.converter.components.typeselector;

import com.hash.converter.Globals;
import com.hash.converter.components.convert.Convert;
import com.hash.converter.util.Types;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.javafx.FontIcon;

public class TypeSelectorButton extends Button {
    private final FontIcon icon;
    private final Text name;
    private final VBox child;

    private final Color ICON_COLOR = Color.WHITE;
    private final int ICON_SIZE = 36;
    private final int BUTTON_SIZE = 120;
    private final int WRAP_WIDTH = BUTTON_SIZE - 20;
    private final int FONT_SIZE = 14;

    private final Types type;

    public TypeSelectorButton(Ikon ikon, String name, Types type) {
        this.type = type;

        this.icon = new FontIcon(ikon);
        this.icon.setIconColor(ICON_COLOR);
        this.icon.setIconSize(ICON_SIZE);

        this.name = new Text(name);
        this.name.setTextAlignment(TextAlignment.CENTER);
        this.name.setWrappingWidth(WRAP_WIDTH);
        this.name.getStyleClass().add("selector-button-text");

        this.child = new VBox(10, this.icon, this.name);
        this.child.setAlignment(Pos.CENTER);

        this.setGraphic(child);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);

        this.setOnMouseClicked(e -> {
            Globals.wrapper.getChildren().clear();
            Globals.wrapper.getChildren().add(new Convert(type));
        });

        this.getStyleClass().add("selector-button");
    }

}
