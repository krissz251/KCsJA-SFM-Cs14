/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class EgyeniPizzaOsszeallitasaElsoSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
       
    @FXML
    private RadioButton rbParadicsomos;

    @FXML
    private ToggleGroup tgAlap;

    @FXML
    private RadioButton rbTejfolos;

    @FXML
    private RadioButton rbNormal;

    @FXML
    private ToggleGroup tgMeret;

    @FXML
    private RadioButton rbNagy;

    @FXML
    private RadioButton rbOrias;
    
    @FXML
    void handleTovabbPushed(ActionEvent event) throws IOException {
        
         if(!rbParadicsomos.isSelected() && !rbTejfolos.isSelected()){
                 Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba");
                alert.setHeaderText("Válaszd ki az alapot!");
                alert.showAndWait();
        } else if(!rbNormal.isSelected() && !rbNagy.isSelected() && !rbOrias.isSelected()){
                 Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba");
                alert.setHeaderText("Válassz méretet!");
                alert.showAndWait();
        } else{
            List<Integer> list=new ArrayList();
            if(rbParadicsomos.isSelected()){
                list.add(10);
            }
            else{
            list.add(11);
            }
            if(rbNormal.isSelected()){
            list.add(1);
            } else if(rbNagy.isSelected()){
            list.add(2);}
            else{
            list.add(3);}
        
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EgyeniPizzaOsszeallitasaMasodikScene.fxml") );
        Parent root = loader.load();  
        EgyeniPizzaOsszeallitasaMasodikSceneController egyeniFeltetSceneController = loader.getController();
        egyeniFeltetSceneController.setList(list);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
        
    }
    
    @FXML
    void handleVisszaButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/RendelesScene.fxml"));
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
