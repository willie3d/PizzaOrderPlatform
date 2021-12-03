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
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

public class CreateController {
    @FXML
    private Button asGuestButton;
    @FXML
    private Button toLoginButton;
    @FXML
    private Button createAccountButton;
    @FXML
    private TextField usernameInput;
    @FXML
    private TextField passwordInput;
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
    @FXML
    public void CreateAccountButton() throws IOException {
        String usernameAdd = "username.txt";
        String passwordAdd = "password.txt";
        String username = usernameInput.getText();
        String password = passwordInput.getText();
        try {
            FileWriter filewrite = new FileWriter(usernameAdd, true);
            BufferedWriter writer = new BufferedWriter(filewrite); 
            writer.write(username);
           // writer.newLine();

            filewrite.close();
            writer.close();

            filewrite = new FileWriter(passwordAdd, true);
            writer = new BufferedWriter(filewrite);
            writer.write(password);
          //  writer.newLine();

            filewrite.close();
            writer.close();
            
        } catch (Exception e){
            System.out.println("Error in creating account");
        }
    }
}
