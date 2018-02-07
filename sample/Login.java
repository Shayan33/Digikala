package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.service.Methods;
import model.service.Service;

public class Login extends Application {
    static public Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
//        Service service = new Service();
//        service.register();
        launch(args);
//        Methods methods = new Methods();
//        methods.selectNamesfromStudent();
    }
}
