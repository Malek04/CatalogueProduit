package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import metier.Categorie;
import metier.CrudCategorie;

public class ControllerCategorie {

    @FXML
    private TableColumn<Categorie, Boolean> ColLigne;

    @FXML
    private AnchorPane bodyCat;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private CheckBox chLigne;

    @FXML
    private TableColumn<Categorie , Integer> colCode;

    @FXML
    private TableColumn<Categorie, String> colNom;

    @FXML
    private Label lblCode;

    @FXML
    private Label lblNom;

    @FXML
    private TableView<Categorie> tableCat;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtNom;

    @FXML
    void ajouter(ActionEvent event) {
    	String nom = txtNom.getText();
    	Boolean ligne = chLigne.isSelected();
    	Categorie c = new Categorie(nom,ligne);
    	int i = CrudCategorie.add(c);
    	if(i!=0) {
    		Alert d = new Alert(AlertType.INFORMATION);
        	d.setTitle("Insertion Categorie");
        	d.setHeaderText(null);
        	d.setContentText("Insertion éffectuée Avec succés");
        	d.showAndWait();
    	}
    	else {
    		Alert d = new Alert(AlertType.ERROR);
        	d.setTitle("Insertion Categorie");
        	d.setHeaderText(null);
        	d.setContentText("Erreur d'insertion");
        	d.showAndWait();
    	}
    }

    @FXML
    void charger(MouseEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

    @FXML
    void vider(ActionEvent event) {
    	txtCode.setText(null);
    	txtNom.setText(null);
    	chLigne.setSelected(false);
    }

}
