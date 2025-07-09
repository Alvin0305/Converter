package com.hash.converter.components.typeselector;

import com.hash.converter.Globals;
import com.hash.converter.util.Types;
import javafx.scene.layout.GridPane;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;


public class TypeSelector extends GridPane {
    Types[] types = Types.values();
    Ikon[] ikons = {
            FontAwesomeSolid.RULER,
            FontAwesomeSolid.SQUARE,
            FontAwesomeSolid.CUBE,
            FontAwesomeSolid.WEIGHT,
            FontAwesomeSolid.THERMOMETER_EMPTY,
            FontAwesomeSolid.TACHOMETER_ALT,
            FontAwesomeSolid.COMPRESS,
            FontAwesomeSolid.BOLT,
            FontAwesomeSolid.MICROCHIP
    };

    public TypeSelector() {
        this.setVgap(10);
        this.setHgap(10);

        for (int i = 0; i < types.length; i++) {
            this.add(new TypeSelectorButton(ikons[i], getFormatedString(types[i].name()), types[i]), i / 3, i % 3);
        }

        Globals.typeSelector = this;
        this.getStyleClass().add("background");
    }

    private String getFormatedString(String string) {
        return string.substring(0, 1).toUpperCase() +
                string
                .replace("_", " ")
                .substring(1).toLowerCase();
    }
}
