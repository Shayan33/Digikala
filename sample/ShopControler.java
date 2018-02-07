package sample;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.entity.Category;
import model.entity.Product;
import model.service.Methods;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShopControler implements Initializable {
    List<TextField> textFieldList;
    List<Button> buttonList;
    @FXML
    ComboBox<String> ComboBox;
    @FXML
    VBox Vbox1;
    @FXML
    Button Addtosabadkharid;
    @FXML
    Button buy;
    @FXML
    void buyOnAction(){
        Methods methods = new Methods();
        methods.updateProductTable(productList);
    }
    List<Product> productList;

    @FXML
    void AddtosabadkharidOnAction() {
        ObservableList<String> list = FXCollections.observableArrayList();
        Methods methods = new Methods();
        List<Category> categoryList = methods.selectAllCategories();
        for (int i = 0; i < categoryList.size(); i++) {
            list.add(categoryList.get(i).getCatName());
        }
        ComboBox.setItems(list);
        ComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Vbox1.getChildren().clear();
                productList = methods.selectAllProducts();
                List<Product> showList = methods.selectAllProducts();
//                System.out.println(showList.get(0).getpCatCode());
                for (int i = 0; i < showList.size(); i++) {
                    if (!newValue.equals(showList.get(i).getCategory().getCatName())){
                        showList.remove(i);
                        i--;
                    }
                }
                textFieldList = new ArrayList<>();
                buttonList = new ArrayList<>();
                for (int i = 0; i < showList.size(); i++) {
                    HBox hBox = new HBox();
                    Text text = new Text();
                    text.setText(showList.get(i).getId() + " " + showList.get(i).getpName());
                    TextField textField = new TextField();
                    textFieldList.add(textField);
                    Button button = new Button();
                    button.setText("Add");
                    buttonList.add(button);
                    button.setId(Integer.toString(i));
                    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            int id = Integer.parseInt(((Button) event.getSource()).getId());
                            int cQty = Integer.parseInt(textFieldList.get(id).getText());
                            if (Integer.parseInt(showList.get(id).getWqty()) < cQty) {
                                textFieldList.get(id).setText("Not availble");
                            }
                            else{
                                long realid = showList.get(id).getId();
                                for (int i = 0; i < productList.size(); i++) {
                                    if (productList.get(i).getId() == realid){
                                        productList.get(i).setCqty(Integer.toString(cQty));
                                        int x =Integer.parseInt(productList.get(i).getWqty()) - cQty;
                                        productList.get(i).setWqty(Integer.toString(x));
                                    }

                                }

                            }
                        }
                    });
                    hBox.getChildren().add(text);
                    hBox.getChildren().add(textField);
                    hBox.getChildren().add(button);
                    Vbox1.getChildren().add(hBox);
                }
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
