package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class acceuilController {

    @FXML
    private AnchorPane body;

    @FXML
    private AnchorPane bodyacceuil;

    @FXML
    private VBox boxMenu;

    @FXML
    private Button btnAnnuler;

    @FXML
    private Button btnConnecter;

    @FXML
    private Button btnGestionCat;

    @FXML
    private Button btnGestionProd;

    @FXML
    private ImageView imgLogo;

    @FXML
    private TextField lblLogin;

    @FXML
    private PasswordField lblPassword;

    @FXML
    private Label lblTitre;

    @FXML
    void gererCategorie(ActionEvent event) {

    }

    @FXML
    void gererProduit(ActionEvent event) {

    }

}
