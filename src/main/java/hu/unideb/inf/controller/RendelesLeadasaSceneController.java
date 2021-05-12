/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Interfaces.IOrderData;
import hu.unideb.inf.businesslogic.RequestModels.FullOrderRequest;
import hu.unideb.inf.businesslogic.ResultModels.FullOrderResult;
import hu.unideb.inf.dataaccess.Entities.OrderItem;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class RendelesLeadasaSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label vegosszegLabel;

    @FXML
    private TextField nevTextField;

    @FXML
    private TextField cimTextField;
    
     @FXML
    private TextField phoneTextField;

    @FXML
    private TextArea megjegyzesTextArea;
    
    private FullOrderRequest fullorderrequest;

    public void setFullorderrequest(FullOrderRequest fullorderrequest) {
        this.fullorderrequest = fullorderrequest;
    }

    public Label getVegosszegLabel() {
        return vegosszegLabel;
    }

    
    
    
    
    @FXML
    void handleRendelesLeadasa(ActionEvent event) throws IOException {
        if(nevTextField.getText().isEmpty() || phoneTextField.getText().isEmpty()){
             Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba a rendelés leadásánál!");
                alert.setHeaderText("A név és cím mező kitöltése kötelező!");
                alert.showAndWait();
        } else{
           this.fullorderrequest.Name=nevTextField.getText();
           this.fullorderrequest.Description = megjegyzesTextArea.getText();
           this.fullorderrequest.Phone = phoneTextField.getText();
           this.fullorderrequest.Address = cimTextField.getText();         
           IOrderData bsd= new BusinessData();
          bsd.AddFullOrder(fullorderrequest);          
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/UtolsoScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
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
        /*TODO*/
    }    
    
}
