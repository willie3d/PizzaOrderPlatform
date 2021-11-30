package com.example.pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

public class HelloController {
    ObservableList<String> pizzaSizeList = FXCollections.observableArrayList("Small","Medium","Large","Extra Large");
    ObservableList<String> sodaSizeList = FXCollections.observableArrayList("Can","Bottle","2-Liter");
    List<HBoxCell> list = new ArrayList<>();
    ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
    @FXML
    private Label welcomeText;

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
    private TextField cheeseQuant;
    @FXML
    private TextField pepQuant;
    @FXML
    private TextField supQuant;
    @FXML
    private TextField pepsiQuant;
    @FXML
    private TextField cokeQuant;
    @FXML
    private TextField dewQuant;
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
    BorderPane layout = new BorderPane();
    @FXML
    ListView<HBoxCell> listView = new ListView<HBoxCell>();





    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();

        HBoxCell(String labelText, String buttonText) {
            super();
            int cost = 0;
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            button.setText(buttonText);
            System.out.println(this);
            button.setOnAction(event -> this.getChildren().removeAll(this.getChildren()));

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
        BorderPane layout = new BorderPane();
        List<HBoxCell> list = new ArrayList<>();
        ListView<HBoxCell> listView = new ListView<HBoxCell>();

        listView.setItems(myObservableList);
        layout.setCenter(listView);
    }
    @FXML
    protected void cheeseOnMouseClicked() { //test
        list.add(new HBoxCell(cheeseSize.getValue() +" Cheese Pizza","Remove"));
        listView.setItems(myObservableList);
        listView.refresh();
    }
    @FXML
    protected void pepOnMouseClicked() {
        list.add(new HBoxCell(pepSize.getValue() +" Pepperoni Pizza","Remove"));
        listView.setItems(myObservableList);
        listView.refresh();
    }
    @FXML
    protected void supOnMouseClicked() {
        list.add(new HBoxCell(supSize.getValue() +" Supreme Pizza","Remove"));
        listView.setItems(myObservableList);
        listView.refresh();
    }
    @FXML
    protected void pepsiOnMouseClicked() {
        list.add(new HBoxCell(pepsiSize.getValue() +" Pepsi","Remove"));
        listView.setItems(myObservableList);
        listView.refresh();
    }
    @FXML
    protected void cokeOnMouseClicked() {
        list.add(new HBoxCell(cokeSize.getValue() +" Coca-Cola","Remove"));
        listView.setItems(myObservableList);
        listView.refresh();
    }
    @FXML
    protected void dewOnMouseClicked() {
        list.add(new HBoxCell(dewSize.getValue() +" Mountain Dew","Remove"));
        listView.setItems(myObservableList);
        listView.refresh();
    }


}