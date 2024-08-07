module main.sensoryexpeirmentplatform {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires javafx.media;
    requires com.fazecast.jSerialComm;

    opens main.sensoryexperimentplatform to javafx.fxml;
    opens main.sensoryexperimentplatform.models to javafx.base;
    exports main.sensoryexperimentplatform;
    exports main.sensoryexperimentplatform.controllers;
    opens main.sensoryexperimentplatform.controllers to javafx.fxml;
    exports main.sensoryexperimentplatform.viewmodel;
    opens main.sensoryexperimentplatform.viewmodel to javafx.fxml;
}