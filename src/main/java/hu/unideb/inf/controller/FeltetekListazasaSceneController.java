/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Interfaces.IOrderData;
import hu.unideb.inf.businesslogic.RequestModels.GetItemsListRequest;
import hu.unideb.inf.businesslogic.RequestModels.GetUsersListRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetItemsListResult;
import hu.unideb.inf.businesslogic.ResultModels.GetUsersListResult;
import hu.unideb.inf.dataaccess.Entities.Item;
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
public class FeltetekListazasaSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TableView<Item> Table;

    @FXML
    private TableColumn<Item, String> Nev;

    @FXML
    private TableColumn<Item, Integer> Mennyiseg;

    @FXML
    private TableColumn<Item, Integer> Ar;
    
    
    
    
    
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
    void handleTovabbaDolgozokButtonPushed(ActionEvent event) throws IOException {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/DolgozoiScene.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            
            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableViewScene);
            window.show();

    }
    
    @FXML
    void handleFeltetekBetoltesePushed(ActionEvent event) {
        IOrderData bsd= new BusinessData();
    
    GetItemsListResult ItemList=bsd.GetItemsList(new GetItemsListRequest(0,11));
    
   ObservableList<Item> olist= FXCollections.observableArrayList(ItemList.Collection);
    
            Nev.setCellValueFactory(new PropertyValueFactory<Item,String>("Name"));
        Mennyiseg.setCellValueFactory(new PropertyValueFactory<Item,Integer>("Amount"));
        Ar.setCellValueFactory(new PropertyValueFactory<Item,Integer>("Price"));
        
        Table.setItems(olist);
    }
    
    @FXML
    void handleTovabbaFoglalasokButtonPushed(ActionEvent event) throws IOException {
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
        //TODOs
    }    
    
}
