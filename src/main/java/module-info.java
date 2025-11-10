module org.example.java3mtp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.j;
    requires com.gluonhq.attach.util;

    opens com.oolong.java3mtp to javafx.fxml;
    exports com.oolong.java3mtp;
    exports com.oolong.java3mtp.views;
    opens com.oolong.java3mtp.views to javafx.fxml;
    exports com.oolong.java3mtp.services;
    opens com.oolong.java3mtp.services to javafx.fxml;
    exports com.oolong.java3mtp.dto;
    opens com.oolong.java3mtp.dto to javafx.fxml;
}