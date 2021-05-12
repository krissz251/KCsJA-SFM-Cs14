/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Interfaces.IUserData;
import hu.unideb.inf.businesslogic.RequestModels.AddUserRequest;
import hu.unideb.inf.dataaccess.Entities.User;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Jelenszky Ádám
 */
public class DolgozoHozzadasaController implements Initializable {
    
    @FXML
    private TextField FelhasznaloTextField;

    @FXML
    private PasswordField jelszoPasswordField;
    
    
    
    private Stage stagew;

    public void setStagew(Stage stagew) {
        this.stagew = stagew;
    }
    
     @FXML
    void handleHozzadasVisszaButtonPushed(ActionEvent event) {
        
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
    
     @FXML
    void handleMentesButtonPushed(ActionEvent event) throws IOException { 
        
        if(FelhasznaloTextField.getText().isEmpty() || jelszoPasswordField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hiba");
                alert.setHeaderText("Hiba a kitöltés során.");
                alert.setContentText("Mindegyik mezőt ki kell tölteni!");
                alert.showAndWait();
        
        }else{
            IUserData bsd= new BusinessData();
          AddUserRequest user= new AddUserRequest(FelhasznaloTextField.getText(),jelszoPasswordField.getText());
          User newuser=bsd.AddUser(user);
          System.out.println(newuser.Name);
          System.out.println(newuser.Password);
          Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.close();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DolgozoiScene.fxml") );
          Parent root = loader.load();
          DolgozoiSceneController dolgozoiSceneController = loader.getController();
          dolgozoiSceneController.refreshDolgozok();
          this.stagew.setScene(new Scene(root));
           
        }
        
        
    } 

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //TODO
    }
    
}
