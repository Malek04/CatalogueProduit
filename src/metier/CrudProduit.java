package metier;

import DAO.SingletonConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudProduit {
	public static ObservableList<String> getNoms(){
		ObservableList<String> noms = FXCollections.observableArrayList();
		String req="Select nom_cat from categorie;";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = SingletonConnexion.getCon().prepareStatement(req);
			rs = ps.executeQuery();
			while(rs.next()){
				String nom = rs.getString(1);
				noms.add(nom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noms;
	}
	
	public static ObservableList<Produit> getAll(){
		ObservableList <Produit> prods = FXCollections.observableArrayList();
		String req = "Select * From produit";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = SingletonConnexion.getCon().prepareStatement(req);
			rs=ps.executeQuery();
			while(rs.next()) {
				int ref = rs.getInt(1);
				String nom = rs.getString(2);
				Double prix = rs.getDouble(3);
				int qte = rs.getInt(4);
				int cat = rs.getInt(5);
				Produit p = new Produit(ref,nom,prix,qte,cat);
				prods.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}
}
