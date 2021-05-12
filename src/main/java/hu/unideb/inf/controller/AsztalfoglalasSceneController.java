/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Interfaces.IBookingData;
import hu.unideb.inf.dataaccess.Entities.Booking;
import java.io.IOException;
import java.net.URL;
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
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/KezdoScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    /*@FXML
    void handleVeglegesitesPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/AsztalVegleges.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }*/
    
    
    @FXML
    void handleVeglegesitesPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AsztalFoglalasVeglegesiteseScene.fxml") );
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
        if(tableid==0){
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba az asztalválasztásnál");
                alert.setHeaderText("A foglaláshoz válassz ki egy asztalt!");
                alert.showAndWait();
        } else{
        AsztalVeglegesController asztalVeglegesController = loader.getController();
        asztalVeglegesController.setTableId(tableid);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        }
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IBookingData bsd = new BusinessData();
        List<Booking> foglalt=bsd.GetActiveBookings();
        for(Booking booking: foglalt){
            if(booking.Table==1){
                rb11.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==2){
                rb12.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==3){
                rb13.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==4){
                rb21.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==5){
                rb22.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==6){
                rb23.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==7){
                rb31.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==8){
                rb32.disableProperty().setValue(Boolean.TRUE);
            }
            if(booking.Table==9){
                rb33.disableProperty().setValue(Boolean.TRUE);
            }
        
        }
    }    
    
}
