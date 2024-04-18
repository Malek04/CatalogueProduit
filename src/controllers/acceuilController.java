package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class acceuilController implements Initializable{

    @FXML
    private AnchorPane body;

    @FXML
    private AnchorPane bodyacceuil;

    @FXML
    private VBox boxMenu;

    @FXML
    private Button btnConnecter;

    @FXML
    private Button btnGestionCat;

    @FXML
    private Button btnGestionProd;

    @FXML
    private ImageView imgLogo;

    @FXML
    private Label lblTitre;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private TextField txtLogin;

    @FXML
    void gererCategorie(ActionEvent event) {
    	try {
			AnchorPane p = FXMLLoader.load(getClass().getResource("/view/interfaceCategorie.fxml"));
			bodyacceuil.getChildren().clear();
			bodyacceuil.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void gererProduit(ActionEvent event) {
    	try {
			AnchorPane p = FXMLLoader.load(getClass().getResource("/view/interfaceProduit.fxml"));
			bodyacceuil.getChildren().clear();
			bodyacceuil.getChildren().add(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void seConnecter(ActionEvent event) {
    	String Log = txtLogin.getText();
    	String pass = pwdPassword.getText();
    	if (Log.equals("admin") && pass.equals("0000")) {
    		Alert d=new Alert(AlertType.INFORMATION);
    		d.setTitle("Connexion");
    		d.setHeaderText(null);
    		d.setContentText("Connexion etablit avec succees");
    		d.showAndWait();
    		bodyacceuil.getChildren().clear();
    		boxMenu.setVisible(true);
    	}
    	else {
    		Alert d=new Alert(AlertType.ERROR);
    		d.setTitle("Connexion");
    		d.setHeaderText(null); 
    		d.setContentText("Connexion echouee");
    		d.showAndWait();
    		txtLogin.setText(null);
    		pwdPassword.setText(null);
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		boxMenu.setVisible(false);
	}

}
