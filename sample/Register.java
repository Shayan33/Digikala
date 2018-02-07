package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Register extends Application {
    static public Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        primaryStage.setTitle("Register");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
