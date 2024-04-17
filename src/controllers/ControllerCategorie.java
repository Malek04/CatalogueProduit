package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import metier.Categorie;
import metier.CrudCategorie;

public class ControllerCategorie implements Initializable{

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
    	loadData();
    }

    @FXML
    void charger(MouseEvent event) {
    	Categorie c = tableCat.getSelectionModel().getSelectedItem();
    	txtCode.setText(String.valueOf(c.getCode()));
    	txtNom.setText(c.getNom_cat());
    	chLigne.setSelected(c.isEnLigne());
    }

    @FXML
    void modifier(ActionEvent event) {
    	Categorie c = tableCat.getSelectionModel().getSelectedItem();
    	String newNom = txtNom.getText();
    	boolean newenLigne = chLigne.isSelected();
    	Alert d = new Alert(AlertType.CONFIRMATION);
    	d.setTitle("confirmation MAJ");
    	d.setHeaderText(null);
    	d.setContentText("Voulez vous mettre a jour cette categorie ?");
    	Optional<ButtonType> rep = d.showAndWait();
    	int i=CrudCategorie.update(c, newNom, newenLigne);
    	if(rep.get()==ButtonType.OK) {
    		if(i!=0) {
	    		Alert d1 = new Alert(AlertType.INFORMATION);
	    		d1.setTitle("Ajout Categorie");
	    		d1.setHeaderText(null);
	    		d1.setContentText("Ajout effectuee avec succees");
	    		d1.showAndWait();
    		}
    		else {
	    		Alert d1 = new Alert(AlertType.ERROR);
	    		d1.setTitle("Ajout Categorie");
	    		d1.setHeaderText(null);
	    		d1.setContentText("Ajout echouee");
	    		d1.showAndWait();
	    	}
    	}
    	else {
    		Alert d1 = new Alert(AlertType.ERROR);
    		d1.setTitle("Ajout Categorie");
    		d1.setHeaderText(null);
    		d1.setContentText("Ajout Annulle");
    		d1.showAndWait();
    	}
    	loadData();
    }

    @FXML
    void supprimer(ActionEvent event) {
    	Categorie c = tableCat.getSelectionModel().getSelectedItem();
    	int i = CrudCategorie.delete(c);
    	if(i!=0) {
    		Alert d = new Alert(AlertType.INFORMATION);
    		d.setTitle("Suppression Categorie");
    		d.setHeaderText(null);
    		d.setContentText("suppression effectuee avec succees");
    		d.showAndWait();
    	}
    	else {
    		Alert d = new Alert(AlertType.ERROR);
    		d.setTitle("Suppression Categorie");
    		d.setHeaderText(null);
    		d.setContentText("suppression echouee");
    		d.showAndWait();
    	}
    	txtCode.setText(null);
    	txtNom.setText(null);
    	chLigne.setSelected(false);
    	loadData();
    }

    @FXML
    void vider(ActionEvent event) {
    	txtCode.setText(null);
    	txtNom.setText(null);
    	chLigne.setSelected(false);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadData();
	}
	
	public void loadData() {
		// TODO Auto-generated method stub
		colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
		colNom.setCellValueFactory(new PropertyValueFactory<>("nom_cat"));
		ColLigne.setCellValueFactory(new PropertyValueFactory<>("enLigne"));
		tableCat.setItems(CrudCategorie.getAll());
	}

}
