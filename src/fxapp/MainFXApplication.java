package fxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.user.User;
import model.user.UserHashMap;
import model.user.UserType;

import static model.user.UserType.BASIC_USER;

public class MainFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        tempUser();
        Parent root = FXMLLoader.load(getClass().getResource("/view/WelcomeScreen.fxml"));
        primaryStage.setTitle("Waterhound Clean Water Application");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //adds temp user to User hash map for testing purposes
    private void tempUser() {
        User temp = new User("water", "hound", "WaterHound", UserType.BASIC_USER);
        UserHashMap.soleInstance.add(temp);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
