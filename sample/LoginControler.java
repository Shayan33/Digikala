package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entity.Customer;
import model.service.Methods;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginControler implements Initializable {
    @FXML
    TextField usernameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    Button signinButton;
    @FXML
    Button register;
    @FXML
    void registerOnAction(){
        Stage stage = new Stage();
        Register register = new Register();
        try {
            register.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Login.stage.close();
    }
    @FXML
    void signinButtononAction(){
        Methods methods = new Methods();
        List<Customer> customerList = methods.selectAllCustomers();

        String username = usernameTextField.getText();
        String pass = passwordTextField.getText();

        for (int i = 0; i < customerList.size(); i++) {
            if ((username.equals(customerList.get(i).getcUName())) && (pass.equals(customerList.get(i).getcPass()))) {
                Stage stage = new Stage();
                Shop shop = new Shop();
                try {
                    shop.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Login.stage.close();

                return;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
