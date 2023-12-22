package com.example.task7_observer;

import ObserverItems.TimeServer;
import ShapeSlideItems.ShapeSlide;
import TimeItems.Time;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import ImageItems.ImagePane;

import java.net.URL;
import java.util.ResourceBundle;

public class Task7Controller implements Initializable {
    @FXML
    public StackPane ImagePane;
    @FXML
    public BorderPane TimerText;
    @FXML
    TextField textField;
    @FXML
    public BorderPane MediaPage;
    private TimeServer timeServer;
    private Time clockComponent;
    private ImageItems.ImagePane imageComponentPane;

    private ShapeSlide slidesComponent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeServer = new TimeServer();
        slidesComponent = new ShapeSlide();
        imageComponentPane = new ImagePane();
        clockComponent = new Time();


        timeServer.attach(imageComponentPane);
        timeServer.attach(clockComponent);
        timeServer.attach(slidesComponent);

        this.TimerText.setCenter(clockComponent.getTime());
        this.ImagePane.getChildren().add(imageComponentPane.buildJoke());
        this.MediaPage.setCenter(slidesComponent.getPanel());
    }
}