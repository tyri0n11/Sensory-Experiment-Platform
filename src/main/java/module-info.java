module main.sensoryexpeirmentplatform {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens main.sensoryexperimentplatform to javafx.fxml;
    exports main.sensoryexperimentplatform;
    exports main.sensoryexperimentplatform.controllers;
    opens main.sensoryexperimentplatform.controllers to javafx.fxml;
}