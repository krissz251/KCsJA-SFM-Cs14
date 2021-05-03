/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Interfaces.IUserData;
import hu.unideb.inf.businesslogic.RequestModels.AddUserRequest;
import hu.unideb.inf.businesslogic.RequestModels.GetUsersListRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetUsersListResult;
import hu.unideb.inf.dataaccess.Entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.stage.Window;

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
   
       
    
      
    
   
   
    Stage stagew= new Stage();
 

    @FXML
    void handleVisszaButtonPushed(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/KezdoScene.fxml"));
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
    
    
    
    public void  refreshDolgozok(){
         IUserData bsd= new BusinessData();
        GetUsersListResult UserList=bsd.GetUsersList(new GetUsersListRequest(0,10));
    
   ObservableList<User> olist= FXCollections.observableArrayList(UserList.Collection);
            Felhasznalo.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        Jelszo.setCellValueFactory(new PropertyValueFactory<User,String>("Password"));
        
        
        Table.setItems(olist);
    }
    
    @FXML
    void handleDolgozokBetoltesePushed(ActionEvent event) {
       refreshDolgozok();
    }
    
      @FXML
    void handleDolgozoHozzadasaPushed(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DolgozoHozzadasa.fxml"));
             Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        Stage stage= new Stage();
        stage.setScene(tableViewScene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        DolgozoHozzadasaController dolgozoiSceneController = loader.getController();
          dolgozoiSceneController.setStagew((Stage) ((Node) event.getSource()).getScene().getWindow());
        
    }
    
    
    
   
    
    @FXML
    void handleDolgozoTorlesePushed(ActionEvent event) {
        if(Table.getSelectionModel().isEmpty()){
        Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Hiba");
                alert.setHeaderText("A törléshez válassz ki egy felhasználót a listából!");
                alert.showAndWait();
        
        }else{
             IUserData bsd= new BusinessData();
        bsd.DeleteUserById(Table.getSelectionModel().getSelectedItem().Id);
        Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Törlés");
                alert.setHeaderText("A felhasználó törlésre került.");
                alert.showAndWait();
        refreshDolgozok();
        
        }
    }
    
     @FXML
    void handleFoglalasokListazasaPushed(ActionEvent event) throws IOException {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FoglalasListazasScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
      @FXML
    void handleRendelesekListazasaPushed(ActionEvent event) throws IOException {
  Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/RendelesekListazasaScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }    
    
}
