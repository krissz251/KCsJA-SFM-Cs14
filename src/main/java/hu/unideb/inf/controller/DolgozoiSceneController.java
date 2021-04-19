/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    
    BusinessData bsd= new BusinessData();
    
    GetUsersListResult UserList=bsd.GetUsersList(new GetUsersListRequest(0,1));
    
   ObservableList<User> olist= FXCollections.observableArrayList(UserList.Collection);
   
 

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
    
    @FXML
    void handleDolgozokBetoltesePushed(ActionEvent event) {
            Felhasznalo.setCellValueFactory(new PropertyValueFactory<User,String>("Name"));
        Jelszo.setCellValueFactory(new PropertyValueFactory<User,String>("Password"));
        
        
        Table.setItems(olist);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }    
    
}
