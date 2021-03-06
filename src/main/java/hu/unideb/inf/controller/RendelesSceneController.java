/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.businesslogic.BusinessData;
import hu.unideb.inf.businesslogic.Interfaces.IOrderData;
import hu.unideb.inf.businesslogic.RequestModels.FullOrderRequest;
import hu.unideb.inf.businesslogic.RequestModels.GetItemsListRequest;
import hu.unideb.inf.businesslogic.ResultModels.GetItemsListResult;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class RendelesSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private Label extraLabel;

    @FXML
    private Label extraFeltet;

    @FXML
    private RadioButton rbExtra;

    @FXML
    private ToggleGroup tgPizzak;

    @FXML
    private Label gombasLabel;

    @FXML
    private Label gombasFeltet;

    @FXML
    private RadioButton rbGombas;

    @FXML
    private Label olaszosLabel;

    @FXML
    private Label olaszosFeltet;

    @FXML
    private RadioButton rbOlaszos;

    @FXML
    private Label szalamisLabel;

    @FXML
    private Label szalamisFeltet;

    @FXML
    private RadioButton rbSzalamis;

    @FXML
    private Label vegaLabel;

    @FXML
    private Label vegaFeltet;

    @FXML
    private RadioButton rbVega;

    
    public int osszegez(FullOrderRequest fullorderrequest){
    IOrderData bsd= new BusinessData();
        int sum=0;
        for(int i :fullorderrequest.OrderItems){
            sum+=bsd.GetItemById(i).Price;
        }
        
    return sum;
    }
    
    @FXML
    void handleEgyeniButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/EgyeniPizzaOsszeallitasaElsoScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    void handleTovabbALeadashoz(ActionEvent event) throws IOException {
        if(!rbSzalamis.isSelected()&&!rbGombas.isSelected()&&!rbOlaszos.isSelected()&&!rbExtra.isSelected()&&!rbVega.isSelected()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba a pizza kiválasztásánál!");
                alert.setHeaderText("A rendeléshez válassz egy pizzát vagy állítsd össze sajátod!");
                alert.showAndWait();
        } else{
            IOrderData bsd=new BusinessData();
            FullOrderRequest fullorderrequest=bsd.GetListOfDefaultOrders().get(0);
            if(rbGombas.isSelected()){
            fullorderrequest=bsd.GetListOfDefaultOrders().get(1);
            } else             if(rbOlaszos.isSelected()){
             fullorderrequest=bsd.GetListOfDefaultOrders().get(2);
            } else             if(rbExtra.isSelected()){
             fullorderrequest=bsd.GetListOfDefaultOrders().get(3);
            } else             if(rbVega.isSelected()){
             fullorderrequest=bsd.GetListOfDefaultOrders().get(4);
            }
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RendelesLeadasaScene.fxml") );
        Parent root = loader.load();  
        RendelesLeadasaSceneController rendelesLeadasaSceneController = loader.getController();
        rendelesLeadasaSceneController.setFullorderrequest(fullorderrequest);
        rendelesLeadasaSceneController.getVegosszegLabel().setText(String.valueOf(osszegez(fullorderrequest))+" Ft");
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        }
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IOrderData bsd= new BusinessData();
        List<FullOrderRequest> list=bsd.GetListOfDefaultOrders();
        szalamisLabel.setText(list.get(0).Title+": ");
        StringBuilder sb=new StringBuilder();
        for(int i:list.get(0).OrderItems){
         
            if(i!=list.get(0).OrderItems.get(list.get(0).OrderItems.size()-1)){
            sb.append(bsd.GetItemById(i).Name+", ");
            }
            else{
            sb.append(bsd.GetItemById(i).Name);
            }
            }
            
        szalamisFeltet.setText(sb.toString());
        
        
          gombasLabel.setText(list.get(1).Title+": ");
        sb=new StringBuilder();
        for(int i:list.get(1).OrderItems){
            if(i!=list.get(1).OrderItems.get(list.get(1).OrderItems.size()-1)){
            sb.append(bsd.GetItemById(i).Name+", ");
            }
            else{
            sb.append(bsd.GetItemById(i).Name);
            }
            }
            
        gombasFeltet.setText(sb.toString());
        
        
        olaszosLabel.setText(list.get(2).Title+": ");
        sb=new StringBuilder();
        for(int i:list.get(2).OrderItems){
           
            if(i!=list.get(2).OrderItems.get(list.get(2).OrderItems.size()-1)){
            sb.append(bsd.GetItemById(i).Name+", ");
            }
            else{
            sb.append(bsd.GetItemById(i).Name);
            }
            }
            
        olaszosFeltet.setText(sb.toString());
        
        
        extraLabel.setText(list.get(3).Title+": ");
        sb=new StringBuilder();
        for(int i:list.get(3).OrderItems){
         
            if(i!=list.get(3).OrderItems.get(list.get(3).OrderItems.size()-1)){
            sb.append(bsd.GetItemById(i).Name+", ");
            }
            else{
            sb.append(bsd.GetItemById(i).Name);
            }
            }
            
        extraFeltet.setText(sb.toString());
        
        vegaLabel.setText(list.get(4).Title+": ");
        sb=new StringBuilder();
        for(int i:list.get(4).OrderItems){
            
            if(i!=list.get(4).OrderItems.get(list.get(4).OrderItems.size()-1)){
            sb.append(bsd.GetItemById(i).Name+", ");
            }
            else{
            sb.append(bsd.GetItemById(i).Name);
            }
            }
            
        vegaFeltet.setText(sb.toString());
    }    
              
        
        
    
}
