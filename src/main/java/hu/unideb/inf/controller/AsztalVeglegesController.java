/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.RequestModels.AddBookingRequest;
import hu.unideb.inf.businesslogic.RequestModels.AddUserRequest;
import hu.unideb.inf.dataaccess.Entities.Booking;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class AsztalVeglegesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private int tableid;
    
    @FXML
    private TextField nevTextField;

    @FXML
    private TextField telefonTextField;
    
    @FXML
    private TextArea megjegyzesTextArea;
    
    BusinessData bsd= new BusinessData();

    @FXML
    void handleVisszaButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/AsztalfoglalasScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();

    }
     @FXML
    void handleFoglalasLeadasaPushed(ActionEvent event) throws IOException { 
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/AsztalfoglalasUtolsoScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        if(nevTextField.getText().isEmpty()){
               Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Hiba");
                alert.setHeaderText("Hiba a kitöltés során.");
                alert.setContentText("Mindegyik mezőt ki kell tölteni!");
                alert.showAndWait();
        
        }else{
          AddBookingRequest booking= new AddBookingRequest(nevTextField.getText(),this.tableid);
          Booking newbooking=bsd.AddBooking(booking);
          
          Stage window=(Stage) ((Node) event.getSource()).getScene().getWindow();
          window.setScene(tableViewScene);
          window.show();
        }
        
       
        
    }
    
    public void setTableId(int id){
        this.tableid = id;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
