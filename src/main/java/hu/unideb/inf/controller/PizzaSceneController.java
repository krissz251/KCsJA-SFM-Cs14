/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Jelenszky Ádám
 */
public class PizzaSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    void handleRendelesButtonPushed(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/RendelesScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void handleFoglalasButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/AsztalfoglalasScene.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }

    @FXML
    void handleBejelentkezesPushed(ActionEvent event) {

Dialog<Pair<String, String>> dialog = new Dialog<>();
dialog.setTitle("Dolgozói bejelentkezés");
dialog.setHeaderText("Dolgozói bejelentkezés");


dialog.setGraphic(new ImageView(this.getClass().getResource("/images/szakacs_kicsi.jpg").toString()));


ButtonType loginButtonType = new ButtonType("Bejelentkezés", ButtonData.OK_DONE);
ButtonType megsemButtonType = new ButtonType("Mégsem", ButtonData.CANCEL_CLOSE);
dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, megsemButtonType);


GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(20, 150, 10, 10));

TextField username = new TextField();
username.setPromptText("Felhasználónév");
PasswordField password = new PasswordField();
password.setPromptText("Jelszó");

grid.add(new Label("Felhasználónév:"), 0, 0);
grid.add(username, 1, 0);
grid.add(new Label("Jelszó:"), 0, 1);
grid.add(password, 1, 1);


Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
BooleanBinding booleanBind = username.textProperty().isEmpty()
                            .or(password.textProperty().isEmpty());
loginButton.disableProperty().bind(booleanBind);

dialog.getDialogPane().setContent(grid);


Platform.runLater(() -> username.requestFocus());


dialog.setResultConverter(dialogButton -> {
    if (dialogButton == loginButtonType) {
        return new Pair<>(username.getText(), password.getText());
    }
    return null;
});

Optional<Pair<String, String>> result = dialog.showAndWait();

result.ifPresent(usernamePassword -> {
    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
});

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
