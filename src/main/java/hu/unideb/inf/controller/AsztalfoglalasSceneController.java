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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AsztalVegleges.fxml") );
        Parent root = loader.load();
        
        int tableid = 0;
        if (rb11.isSelected()) {
            tableid= 1;
        }
        else if (rb12.isSelected()) {
            tableid=2;
        }
         else if (rb13.isSelected()) {
            tableid=3;
        }
         else if (rb21.isSelected()) {
            tableid=4;
        }
         else if (rb22.isSelected()) {
            tableid=5;
        }
         else if (rb23.isSelected()) {
            tableid=6;
        }
         else if (rb31.isSelected()) {
            tableid=7;
        }
         else if (rb32.isSelected()) {
            tableid=8;
        }
         else if (rb33.isSelected()) {
            tableid=9;
        }
        AsztalVeglegesController asztalVeglegesController = loader.getController();
        asztalVeglegesController.setTableId(tableid);
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
       
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
