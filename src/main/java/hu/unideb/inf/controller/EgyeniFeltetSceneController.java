/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

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
    private RadioButton rbElso;

    @FXML
    private RadioButton rbMasodik;

    @FXML
    private RadioButton rbHarmadik;

    @FXML
    private RadioButton rbNegyedik;

    @FXML
    private RadioButton rbOtodik;

    @FXML
    private RadioButton rbHatodik;
    
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
        // TODO
    }    
    
}
