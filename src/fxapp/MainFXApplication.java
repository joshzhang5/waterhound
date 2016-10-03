package fxapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.User;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class MainFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/WelcomeScreen.fxml"));
        primaryStage.setTitle("Waterhound Clean Water Application");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        }

    public static void main(String[] args) {
        launch(args);
    }
}
