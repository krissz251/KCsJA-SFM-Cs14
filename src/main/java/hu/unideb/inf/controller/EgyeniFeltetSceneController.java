/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Enums.ItemType;
import hu.unideb.inf.businesslogic.RequestModels.GetItemsListRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetItemsListResult;
import hu.unideb.inf.dataaccess.Entities.Item;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class EgyeniFeltetSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label elsoFeltetLabel;

    @FXML
    private Label elsoArLabel;

    @FXML
    private Label masodikFeltetLabel;

    @FXML
    private Label harmadikFeltetLabel;

    @FXML
    private Label negyedikFeltetLabel;

    @FXML
    private Label otodikFeltetLabel;

    @FXML
    private Label hatodikFeltetLabel;

    @FXML
    private Label masodikArLabel;

    @FXML
    private Label harmadikArLabel;

    @FXML
    private Label negyedikArLabel;

    @FXML
    private Label otodikArLabel;

    @FXML
    private Label hatodikArLabel;

     @FXML
    private CheckBox elsoCheckbox;

    @FXML
    private CheckBox masodikCheckbox;

    @FXML
    private CheckBox harmadikCheckbox;

    @FXML
    private CheckBox negyedikCheckbox;

    @FXML
    private CheckBox otodikCheckbox;

    @FXML
    private CheckBox hatodikCheckbox;
    
    
    BusinessData bsd= new BusinessData();
    GetItemsListResult ItemList=bsd.GetItemsList(new GetItemsListRequest(0,11));
           
       
    @FXML
    void handleTovabbALeadashoz(ActionEvent event) throws IOException {
          Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/RendelesLeadasaScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    void handleVisszaButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/EgyeniScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Item> toRemove = new ArrayList();
        for(Item item: ItemList.Collection){
           if(item.Type!=ItemType.Topping){
               toRemove.add(item);
           }
        }
        ItemList.Collection.removeAll(toRemove);        
        elsoFeltetLabel.setText(ItemList.Collection.get(0).Name);
        elsoArLabel.setText("+"+String.valueOf(ItemList.Collection.get(0).Price)+" Ft");
        masodikFeltetLabel.setText(ItemList.Collection.get(1).Name);
        masodikArLabel.setText("+"+String.valueOf(ItemList.Collection.get(1).Price)+" Ft");
        harmadikFeltetLabel.setText(ItemList.Collection.get(2).Name);
        harmadikArLabel.setText("+"+String.valueOf(ItemList.Collection.get(2).Price)+" Ft");
        negyedikFeltetLabel.setText(ItemList.Collection.get(3).Name);
        negyedikArLabel.setText("+"+String.valueOf(ItemList.Collection.get(3).Price)+" Ft");
        otodikFeltetLabel.setText(ItemList.Collection.get(4).Name);
        otodikArLabel.setText("+"+String.valueOf(ItemList.Collection.get(4).Price)+" Ft");
        hatodikFeltetLabel.setText(ItemList.Collection.get(5).Name);
        hatodikArLabel.setText("+"+String.valueOf(ItemList.Collection.get(5).Price)+" Ft");
    }    
    
}
