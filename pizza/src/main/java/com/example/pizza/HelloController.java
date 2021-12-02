package com.example.pizza;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class HelloController {
    ObservableList<String> pizzaSizeList = FXCollections.observableArrayList("Small","Medium","Large","Extra Large");
    ObservableList<String> sodaSizeList = FXCollections.observableArrayList("Can","Bottle","2-Liter");
    ObservableList<String> crustList = FXCollections.observableArrayList("Thin","Buttery","Pan");
    List<HBoxCell> list = new ArrayList<>();
    ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
    @FXML
    private Label welcomeText;
    @FXML
    private Label recieptTotalLabel;
    @FXML
    public static double totalPrice;
    private double getTotalPrice(){
        return totalPrice;
    }
    private void setTotalPrice(double price){
        totalPrice = price;
    }
    @FXML
    private ComboBox cheeseSize;
    @FXML
    private ComboBox pepSize;
    @FXML
    private ComboBox supSize;
    @FXML
    private ComboBox pepsiSize;
    @FXML
    private ComboBox cokeSize;
    @FXML
    private ComboBox dewSize;
    @FXML
    private ComboBox spriteSize;
    @FXML
    private ComboBox fantaSize;
    @FXML
    private ComboBox cheeseCrust;
    @FXML
    private ComboBox pepCrust;
    @FXML
    private ComboBox supCrust;
    @FXML
    private Button cheeseAdd;
    @FXML
    private Button pepAdd;
    @FXML
    private Button supAdd;
    @FXML
    private Button pepsiAdd;
    @FXML
    private Button cokeAdd;
    @FXML
    private Button dewAdd;
    @FXML
    private Button spriteAdd;
    @FXML
    private Button fantaAdd;
    @FXML
    private Button backPage;
    @FXML
    BorderPane layout = new BorderPane();
    @FXML
    ListView<HBoxCell> listView = new ListView<HBoxCell>();

    @FXML
    protected static void removeButton(double amount){
        totalPrice = totalPrice - amount;
    }
    @FXML
    protected void refresh(){
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                totalPrice = Math.round(totalPrice * 100.0) / 100.0;
                recieptTotalLabel.setText(String.valueOf(totalPrice));
            }
        }));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
    }



    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();
        double cost;
        private double getCost(){
            return cost;
        }

        HBoxCell(String labelText, String buttonText, double price) {
            super();
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);
            cost = price;

            button.setText(buttonText);
            System.out.println(this);
            button.setOnAction(event -> this.getChildren().removeAll(this.getChildren()));
            button.setOnMousePressed(event -> removeButton(price));
            this.getChildren().addAll(label, button);
        }

    }
    @FXML
    private void initialize() {
        cheeseSize.setItems(pizzaSizeList);
        pepSize.setItems(pizzaSizeList);
        supSize.setItems(pizzaSizeList);
        pepsiSize.setItems(sodaSizeList);
        cokeSize.setItems(sodaSizeList);
        dewSize.setItems(sodaSizeList);
        spriteSize.setItems(sodaSizeList);
        fantaSize.setItems(sodaSizeList);
        cheeseCrust.setItems(crustList);
        pepCrust.setItems(crustList);
        supCrust.setItems(crustList);
        BorderPane layout = new BorderPane();
        List<HBoxCell> list = new ArrayList<>();
        ListView<HBoxCell> listView = new ListView<HBoxCell>();

        listView.setItems(myObservableList);
        layout.setCenter(listView);
        refresh();
    }
    @FXML
    protected void cheeseOnMouseClicked() {
        double thisPrice = 0;
        if(cheeseSize.getValue().toString() == "Small"){
            thisPrice = 10.99;
        } else if(cheeseSize.getValue().toString() == "Medium"){
            thisPrice = 12.99;
        } else if(cheeseSize.getValue().toString() == "Large"){
            thisPrice = 14.99;
        } else if(cheeseSize.getValue().toString() == "Extra Large"){
            thisPrice = 15.99;
        }
        HBoxCell cheesePizzaCell = new HBoxCell(String.valueOf(thisPrice) + "   "+ cheeseCrust.getValue() + " " + cheeseSize.getValue() +" Cheese Pizza","Remove",thisPrice);
        list.add(cheesePizzaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + cheesePizzaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    protected void pepOnMouseClicked() {
        double thisPrice = 0;
        if(pepSize.getValue().toString() == "Small"){
            thisPrice = 10.99;
        } else if(pepSize.getValue().toString() == "Medium"){
            thisPrice = 12.99;
        } else if(pepSize.getValue().toString() == "Large"){
            thisPrice = 14.99;
        } else if(pepSize.getValue().toString() == "Extra Large"){
            thisPrice = 15.99;
        }
        HBoxCell pepPizzaCell = new HBoxCell(String.valueOf(thisPrice) + "   " + pepCrust.getValue() + " " + pepSize.getValue() +" Pepperoni Pizza","Remove",thisPrice);
        list.add(pepPizzaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + pepPizzaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    protected void supOnMouseClicked() {
        double thisPrice = 0;
        if(supSize.getValue().toString() == "Small"){
            thisPrice = 10.99;
        } else if(supSize.getValue().toString() == "Medium"){
            thisPrice = 12.99;
        } else if(supSize.getValue().toString() == "Large"){
            thisPrice = 14.99;
        } else if(supSize.getValue().toString() == "Extra Large"){
            thisPrice = 15.99;
        }
        HBoxCell supPizzaCell = new HBoxCell(String.valueOf(thisPrice) + "   " + supCrust.getValue() + " " + supSize.getValue() +" Supreme Pizza","Remove",thisPrice);
        list.add(supPizzaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + supPizzaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    protected void pepsiOnMouseClicked() {
        double thisPrice = 0;
        if(pepsiSize.getValue().toString() == "Can"){
            thisPrice = 0.99;
        } else if(pepsiSize.getValue().toString() == "Bottle"){
            thisPrice = 1.49;
        } else if(pepsiSize.getValue().toString() == "2-Liter"){
            thisPrice = 1.99;
        }
        HBoxCell pepsiSodaCell = new HBoxCell(String.valueOf(thisPrice) + "   " + pepsiSize.getValue() +" Pepsi","Remove",thisPrice);
        list.add(pepsiSodaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + pepsiSodaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    protected void cokeOnMouseClicked() {
        double thisPrice = 0;
        if(cokeSize.getValue().toString() == "Can"){
            thisPrice = 0.99;
        } else if(cokeSize.getValue().toString() == "Bottle"){
            thisPrice = 1.49;
        } else if(cokeSize.getValue().toString() == "2-Liter"){
            thisPrice = 1.99;
        }
        HBoxCell cokeSodaCell = new HBoxCell(String.valueOf(thisPrice) + "   " + cokeSize.getValue() +" Coca-Cola","Remove",thisPrice);
        list.add(cokeSodaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + cokeSodaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    protected void dewOnMouseClicked() {
        double thisPrice = 0;
        if(dewSize.getValue().toString() == "Can"){
            thisPrice = 0.99;
        } else if(dewSize.getValue().toString() == "Bottle"){
            thisPrice = 1.49;
        } else if(dewSize.getValue().toString() == "2-Liter"){
            thisPrice = 1.99;
        }
        HBoxCell dewSodaCell = new HBoxCell(String.valueOf(thisPrice) + "   " + dewSize.getValue() +" Moutain Dew","Remove",thisPrice);
        list.add(dewSodaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + dewSodaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    protected void spriteOnMouseClicked() {
        double thisPrice = 0;
        if(spriteSize.getValue().toString() == "Can"){
            thisPrice = 0.99;
        } else if(spriteSize.getValue().toString() == "Bottle"){
            thisPrice = 1.49;
        } else if(spriteSize.getValue().toString() == "2-Liter"){
            thisPrice = 1.99;
        }
        HBoxCell spriteSodaCell = new HBoxCell(String.valueOf(thisPrice) + "   " + spriteSize.getValue() +" Sprite","Remove",thisPrice);
        list.add(spriteSodaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + spriteSodaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    protected void fantaOnMouseClicked() {
        double thisPrice = 0;
        if(fantaSize.getValue().toString() == "Can"){
            thisPrice = 0.99;
        } else if(fantaSize.getValue().toString() == "Bottle"){
            thisPrice = 1.49;
        } else if(fantaSize.getValue().toString() == "2-Liter"){
            thisPrice = 1.99;
        }
        HBoxCell fantaSodaCell = new HBoxCell(String.valueOf(thisPrice) + "   " + fantaSize.getValue() +" Orange Fanta","Remove",thisPrice);
        list.add(fantaSodaCell);
        listView.setItems(myObservableList);
        listView.refresh();
        totalPrice = totalPrice + fantaSodaCell.getCost();
        recieptTotalLabel.setText(String.valueOf(totalPrice));
    }
    @FXML
    public void toLoginButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Stage stage = (Stage) backPage.getScene().getWindow();
        fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.getRoot());
        stage.setScene(scene);
        
    }
}