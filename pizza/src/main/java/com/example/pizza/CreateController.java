package com.example.pizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
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

public class CreateController {
    @FXML
    private Button asGuestButton;
    @FXML
    private Button toLoginButton;
    @FXML
    public void ContinueButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pizza-menu.fxml"));
        Stage stage = (Stage) asGuestButton.getScene().getWindow();
        fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.getRoot());
        stage.setScene(scene);
    }
    @FXML
    public void LoginPageButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Stage stage = (Stage) toLoginButton.getScene().getWindow();
        fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.getRoot());
        stage.setScene(scene);
    }
}
