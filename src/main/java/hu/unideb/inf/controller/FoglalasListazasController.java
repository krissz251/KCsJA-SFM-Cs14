package hu.unideb.inf.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.RequestModels.GetBookingsListRequest;
import hu.unideb.inf.businesslogic.RequestModels.GetUsersListRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetBookingsListResult;
import hu.unideb.inf.businesslogic.ResultModels.GetUsersListResult;
import hu.unideb.inf.dataaccess.Entities.Booking;
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
 * @author Attila
 */
public class FoglalasListazasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<Booking> Table;

    @FXML
    private TableColumn<Booking, String> Nev;

    @FXML
    private TableColumn<Booking, String> Asztal;
    BusinessData bsd= new BusinessData();
     
   public void refreshFoglalasok(){     
        GetBookingsListResult BookingList=bsd.GetBookingsList(new GetBookingsListRequest(0,10));        
        ObservableList<Booking> olist= FXCollections.observableArrayList(BookingList.Collection);      
        Nev.setCellValueFactory(new PropertyValueFactory<Booking,String>("Name"));
        Asztal.setCellValueFactory(new PropertyValueFactory<Booking,String>("Table"));
        
        
        Table.setItems(olist);
    }
   
    @FXML
    public void handleFoglalasokBetoltesePushed(ActionEvent event) {      
       refreshFoglalasok();
    }
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
