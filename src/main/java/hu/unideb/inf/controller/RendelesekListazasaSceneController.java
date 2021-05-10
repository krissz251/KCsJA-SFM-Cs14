/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Enums.BookingState;
import hu.unideb.inf.businesslogic.Enums.OrderState;
import hu.unideb.inf.businesslogic.Interfaces.IBookingData;
import hu.unideb.inf.businesslogic.Interfaces.IOrderData;
import hu.unideb.inf.businesslogic.RequestModels.GetOrdersListRequest;
import hu.unideb.inf.businesslogic.RequestModels.SetBookingRequest;
import hu.unideb.inf.businesslogic.RequestModels.SetOrderRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetOrdersListResult;
import hu.unideb.inf.dataaccess.Entities.Order;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám & Muszta Attila
 */
public class RendelesekListazasaSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<Order> Table;

    @FXML
    private TableColumn<Order, String> Cim;

    @FXML
    private TableColumn<Order,String> Nev;
    
    @FXML
    private TableColumn<Order,String> Phone;

    @FXML
    private TableColumn<Order,OrderState> Statusz;

    @FXML
    private TableColumn<Order, String> Pizza;

    @FXML
    private TableColumn<Order, Date> Datum;
    
    @FXML
    private TableColumn<Order, String> Megjegyzes;
    
       @FXML
    private TableColumn<?, ?> Ar;

    
    
    public void refreshRendelesek(){
     IOrderData bsd= new BusinessData();
        GetOrdersListResult OrderList=bsd.GetOrdersList(new GetOrdersListRequest(0,100));  
        ObservableList<Order> olist= FXCollections.observableArrayList(OrderList.Collection);      
        Nev.setCellValueFactory(new PropertyValueFactory<Order,String>("Name"));
        //Pizza.setCellValueFactory(new PropertyValueFactory<Order,String>("Title"));
        Statusz.setCellValueFactory(new PropertyValueFactory<Order,OrderState>("State"));
       Datum.setCellValueFactory(new PropertyValueFactory<Order,Date>("Date"));
      // Megjegyzes.setCellValueFactory(new PropertyValueFactory<Order,String>("Description"));
       Phone.setCellValueFactory(new PropertyValueFactory<Order,String>("Phone"));
       //Cim.setCellValueFactory(new PropertyValueFactory<Order,String>("Address"));
        
        
        Table.setItems(olist);
    
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
    void handleTovabbaDolgozokButtonPushed(ActionEvent event) throws IOException {
         Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/DolgozoiScene.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            
            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    void handleTovabbaFeltetekButtonPushed(ActionEvent event) throws IOException {
             Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FeltetekListazasaScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

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
    void handleRendelesekBetoltesePushed(ActionEvent event) {
            refreshRendelesek();
    }
    
     @FXML
    void handleReszletekListazasaPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/RendelesReszletekListazasScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
        
    }
    
     @FXML
    void handleRendelesKeszButtonPushed(ActionEvent event) {
 if(Table.getSelectionModel().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba");
                alert.setHeaderText("Válaszd ki a módosítandó rendelést a listából!");
                alert.showAndWait();
        
        }else{
            IOrderData bsd= new BusinessData();
        bsd.SetOrder(new SetOrderRequest(Table.getSelectionModel().getSelectedItem().Id,Table.getSelectionModel().getSelectedItem().Name,OrderState.Done,Table.getSelectionModel().getSelectedItem().Title));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Státusz módosítva");
                alert.setHeaderText("A rendelés feldolgozásra került.");
                alert.showAndWait();
        refreshRendelesek();
        
        }
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
   
}


    
    
   
    

