/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class EgyeniSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
       
    @FXML
    private RadioButton rbParadicsomos;

    @FXML
    private ToggleGroup tgAlap;

    @FXML
    private RadioButton rbTejfolos;

    @FXML
    private RadioButton rbNormal;

    @FXML
    private ToggleGroup tgMeret;

    @FXML
    private RadioButton rbNagy;

    @FXML
    private RadioButton rbOrias;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
