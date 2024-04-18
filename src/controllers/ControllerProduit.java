package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import metier.CrudProduit;
import metier.Produit;

public class ControllerProduit implements Initializable{

    @FXML
    private AnchorPane bodyProd;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnclear;

    @FXML
    private Button btndelete;

    @FXML
    private TableColumn<Produit, String> colCat;

    @FXML
    private TableColumn<Produit, String> colNom;

    @FXML
    private TableColumn<Produit, Double> colPrix;

    @FXML
    private TableColumn<Produit, Integer> colQuantite;

    @FXML
    private TableColumn<Produit, Integer> colRef;

    @FXML
    private ComboBox<String> comboCat;

    @FXML
    private Label lblNom;

    @FXML
    private Label lblPrix;

    @FXML
    private Label lblQte;

    @FXML
    private Label lblRef;

    @FXML
    private Label lblcategorie;

    @FXML
    private Spinner<Integer> spQuantite;

    @FXML
    private TableView<Produit> tableProd;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrix;

    @FXML
    private TextField txtRef;

    @FXML
    void ajouter(ActionEvent event) {

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

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		comboCat.setItems(CrudProduit.getNoms());
		loadData();
	}

	private void loadData() {
		// TODO Auto-generated method stub
		colRef.setCellValueFactory(new PropertyValueFactory<>("ref"));
		colNom.setCellValueFactory(new PropertyValueFactory<>("nomProd"));
		colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
		colQuantite.setCellValueFactory(new PropertyValueFactory<>("qte"));
		colCat.setCellValueFactory(new PropertyValueFactory<>("cat"));
		tableProd.setItems(CrudProduit.getAll());
	}

    
}
