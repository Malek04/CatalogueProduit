package application;
	
import DAO.SingletonConnexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import metier.Categorie;
import metier.CrudCategorie;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SingletonConnexion.getCon();
			/*Categorie c = new Categorie("test",false);
			if(CrudCategorie.add(c)!=0) {
				System.out.println("Insertion OK");
			}
			else {
				System.out.println("erreur de l'insertion");
			}
			if(CrudCategorie.delete(new Categorie(3,"test",false))!=0) {
				System.out.println("suppression OK");
			}
			else {
				System.out.println("erreur de la suppression");
			}*/
			Parent root = FXMLLoader.load(getClass().getResource("/view/interfaceCategorie.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
