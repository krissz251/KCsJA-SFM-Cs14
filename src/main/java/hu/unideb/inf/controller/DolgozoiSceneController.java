/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.RequestModels.AddUserRequest;
import hu.unideb.inf.businesslogic.RequestModels.GetUsersListRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetUsersListResult;
import hu.unideb.inf.dataaccess.Entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class DolgozoiSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
        @FXML
    private TableView<User> Table;

    @FXML
    private TableColumn<User, String> Felhasznalo;

    @FXML
    private TableColumn<User, String> Jelszo;
    
    @FXML
    private TextField FelhasznaloTextField;

    @FXML
    private PasswordField jelszoPasswordField;
    
      
    
    BusinessData bsd= new BusinessData();
    
    
   
 

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
    void handleFeltetekListazasaPushed(ActionEvent event) throws IOException {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FeltetekListazasaScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    
    
    public void refreshDolgozok(){
        GetUsersListResult UserList=bsd.GetUsersList(new GetUsersListRequest(0,10));
    
   ObservableList<User> olist= FXCollections.observableArrayList(UserList.Collection);
            Felhasznalo.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        Jelszo.setCellValueFactory(new PropertyValueFactory<User,String>("Password"));
        
        
        Table.setItems(olist);
    }
    
    @FXML
    void handleDolgozokBetoltesePushed(ActionEvent event) {
       /* GetUsersListResult UserList=bsd.GetUsersList(new GetUsersListRequest(0,10));
    
   ObservableList<User> olist= FXCollections.observableArrayList(UserList.Collection);
            Felhasznalo.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        Jelszo.setCellValueFactory(new PropertyValueFactory<User,String>("Password"));
        
        
        Table.setItems(olist);*/
       refreshDolgozok();
    }
    
      @FXML
    void handleDolgozoHozzadasaPushed(ActionEvent event) throws IOException {
             Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/DolgozoHozzadasa.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage stage= new Stage();
        stage.setScene(tableViewScene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }
    
    @FXML
    void handleHozzadasVisszaButtonPushed(ActionEvent event) {
        
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
    
     @FXML
    void handleMentesButtonPushed(ActionEvent event) { 
        
        if(FelhasznaloTextField.getText().isEmpty() || jelszoPasswordField.getText().isEmpty()){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Hiba");
                alert.setHeaderText("Hiba a kitöltés során.");
                alert.setContentText("Mindegyik mezőt ki kell tölteni!");
                alert.showAndWait();
        
        }else{
          AddUserRequest user= new AddUserRequest(FelhasznaloTextField.getText(),jelszoPasswordField.getText());
          User newuser=bsd.AddUser(user);
          System.out.println(newuser.Name);
          System.out.println(newuser.Password);
          //refreshDolgozok();
          Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.close();
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }    
    
}
