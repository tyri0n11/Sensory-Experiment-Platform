module main.sensoryexpeirmentplatform {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens main.sensoryexpeirmentplatform to javafx.fxml;
    exports main.sensoryexpeirmentplatform;
    exports main.sensoryexpeirmentplatform.controllers;
    opens main.sensoryexpeirmentplatform.controllers to javafx.fxml;
}