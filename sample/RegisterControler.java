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

public class RegisterControler implements Initializable {
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField email;
    @FXML
    TextField lastname;
    @FXML
    Button register;
    @FXML
    TextField firstname;
    @FXML
    void registerOnAction(){
        Customer customer = new Customer();
        customer.setcFName(firstname.getText());
        customer.setcLName(lastname.getText());
        customer.setcMail(email.getText());
        customer.setcUName(username.getText());
        customer.setcPass(password.getText());
        Methods methods = new Methods();
        methods.addCustomer(customer);
        Stage stage = new Stage();
        Shop shop = new Shop();
        try {
            shop.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Register.stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
