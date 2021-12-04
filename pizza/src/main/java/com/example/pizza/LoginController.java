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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginController {
    @FXML
    private Button asGuestButton;
    @FXML
    private Button toCreateButton;
    @FXML
    private Button loginButton;
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
    public void CreatePageButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("create-account.fxml"));
        Stage stage = (Stage) toCreateButton.getScene().getWindow();
        fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.getRoot());
        stage.setScene(scene);
    }
    @FXML
    public void CheckLoginButton() throws IOException {
            try {
                String usernameCheck = "username.txt";
                String passwordCheck = "password.txt";
                String username = usernameInput.getText();
                String password = passwordInput.getText();
    
                FileReader frUser = new FileReader(usernameCheck);
        //        FileReader frPass = new FileReader(passwordCheck);
                BufferedReader brUser = new BufferedReader(frUser);
                String line;
                int count = 0;
                boolean isLoginSuccess = false;
                while ((line = brUser.readLine()) != null) {
                    if (username.equals(line)) {
                        break;
                    } 
                    count++;
                }
                brUser.close();
                try{
                    String passTest = Files.readAllLines(Paths.get(passwordCheck)).get(count);
                    if(passTest.equals(password)){
                        isLoginSuccess = true;
                    }
                } catch(Exception e){
                    System.out.println(e);
                }
                if (!isLoginSuccess) {
                    System.out.println("ERROR MESSAGE");
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pizza-menu.fxml"));
                    Stage stage = (Stage) asGuestButton.getScene().getWindow();
                    fxmlLoader.load();
                     Scene scene = new Scene(fxmlLoader.getRoot());
                   stage.setScene(scene);
                }
                frUser.close();
    
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}
