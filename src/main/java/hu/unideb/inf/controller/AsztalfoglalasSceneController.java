/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class AsztalfoglalasSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private RadioButton rb11;

    @FXML
    private ToggleGroup tgAsztal;

    @FXML
    private RadioButton rb21;

    @FXML
    private RadioButton rb31;

    @FXML
    private RadioButton rb12;

    @FXML
    private RadioButton rb22;

    @FXML
    private RadioButton rb32;

    @FXML
    private RadioButton rb13;

    @FXML
    private RadioButton rb23;

    @FXML
    private RadioButton rb33;

    
    @FXML
    void handleVisszaButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/PizzaScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    void handleVeglegesitesPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/AsztalVegleges.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
