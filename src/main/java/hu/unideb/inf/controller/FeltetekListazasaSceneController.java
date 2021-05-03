/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Enums.ItemType;
import hu.unideb.inf.businesslogic.Interfaces.IOrderData;
import hu.unideb.inf.businesslogic.Interfaces.IUserData;
import hu.unideb.inf.businesslogic.RequestModels.GetItemsListRequest;
import hu.unideb.inf.businesslogic.RequestModels.GetUsersListRequest;
import hu.unideb.inf.businesslogic.RequestModels.SetItemRequest;
import hu.unideb.inf.businesslogic.RequestModels.SetOrderRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetItemsListResult;
import hu.unideb.inf.businesslogic.ResultModels.GetUsersListResult;
import hu.unideb.inf.dataaccess.Entities.Item;
import hu.unideb.inf.dataaccess.Entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

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
    
    
    
    
    public void refreshFeltetek(){
    IOrderData bsd= new BusinessData();
    
    GetItemsListResult ItemList=bsd.GetItemsList(new GetItemsListRequest(0,12));
    
   ObservableList<Item> olist= FXCollections.observableArrayList(ItemList.Collection);
    
            Nev.setCellValueFactory(new PropertyValueFactory<Item,String>("Name"));
        Mennyiseg.setCellValueFactory(new PropertyValueFactory<Item,Integer>("Amount"));
        Ar.setCellValueFactory(new PropertyValueFactory<Item,Integer>("Price"));
        
        Table.setItems(olist);
    
    
    }
    
    
    @FXML
    void handleKeszletFeltoltesePushed(ActionEvent event) {
        Dialog<Integer> dialog = new Dialog<>();
dialog.setTitle("Készlet feltöltés");
dialog.setHeaderText("Készlet feltöltés");

ButtonType feltoltButtonType = new ButtonType("Feltöltés", ButtonBar.ButtonData.OK_DONE);
ButtonType megsemButtonType = new ButtonType("Mégsem", ButtonBar.ButtonData.CANCEL_CLOSE);
dialog.getDialogPane().getButtonTypes().addAll(feltoltButtonType, megsemButtonType);


GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(20, 150, 10, 10));

TextField mennyiseg = new TextField();
mennyiseg.setPromptText("Mennyiség");


grid.add(new Label("Mennyiség:"), 0, 0);
grid.add(mennyiseg, 1, 0);



Node feltoltButton = dialog.getDialogPane().lookupButton(feltoltButtonType);
BooleanBinding booleanBind = mennyiseg.textProperty().isEmpty();
feltoltButton.disableProperty().bind(booleanBind);

dialog.getDialogPane().setContent(grid);


Platform.runLater(() -> mennyiseg.requestFocus());


dialog.setResultConverter(dialogButton -> {
    if (dialogButton == feltoltButtonType) {
        try{
        return Integer.parseInt(mennyiseg.getText());
        } catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Feltöltési hiba");
                alert.setHeaderText("Nem sikerült feltölteni a készletet!");
                alert.setContentText("Hibásan megadott mennyiség!");
                alert.showAndWait();    
        
        
        }
        
        }
    return null;
});

Optional<Integer> result = dialog.showAndWait();

result.ifPresent(Mennyiseg -> {    
    if(Mennyiseg<1){
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Feltöltési hiba");
                alert.setHeaderText("Nem sikerült feltölteni a készletet!");
                alert.setContentText("Hibásan megadott mennyiség!");
                alert.showAndWait();
      
    } else{
    
        IOrderData bsd = new BusinessData();
        bsd.SetItem(new SetItemRequest(Table.getSelectionModel().getSelectedItem().Id, Mennyiseg));
        //System.out.println(Table.getSelectionModel().getSelectedItem().Id +" "+ Table.getSelectionModel().getSelectedItem().Name +" "+ (Table.getSelectionModel().getSelectedItem().Amount+Mennyiseg) +" "+ Table.getSelectionModel().getSelectedItem().Price +" "+ Table.getSelectionModel().getSelectedItem().Type);
    }       
});
            refreshFeltetek();
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
    
    @FXML
    void handleFeltetekBetoltesePushed(ActionEvent event) {
        refreshFeltetek();
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
