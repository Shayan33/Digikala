package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Shop extends Application {
    static public Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("shop.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
}
