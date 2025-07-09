module com.hash.converter {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    // Kordamp Ikonli modules
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires org.kordamp.ikonli.materialdesign2; // Added this for the dependency you have

    // THIS IS THE CRITICAL FIX FOR JLINK AND MODULAR RUNS
    uses org.kordamp.ikonli.IkonHandler;

    opens com.hash.converter to javafx.fxml;
    exports com.hash.converter;

    // You must also open your subpackages if they contain @FXML annotated fields
    // or are used directly in FXML files.
    opens com.hash.converter.components.typeselector to javafx.fxml;
}