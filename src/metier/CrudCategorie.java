package metier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.SingletonConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CrudCategorie {
	
	public static int add(Categorie c) {
		String req="insert into categorie (nom_cat,enLigne) values (?,?);";
		PreparedStatement ps;
		try {
			ps = SingletonConnexion.getCon().prepareStatement(req);
			ps.setString(1,c.getNom_cat());
			ps.setBoolean(2,c.isEnLigne());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int delete(Categorie c) {
		String req="delete from categorie where code=?;";
		PreparedStatement ps;
		try {
			ps = SingletonConnexion.getCon().prepareStatement(req);
			ps.setInt(1,c.getCode());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static ObservableList<Categorie> getAll(){
		ObservableList<Categorie> cats = FXCollections.observableArrayList();
		String req = "Select * from categorie;";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = SingletonConnexion.getCon().prepareStatement(req);
			rs=ps.executeQuery();
			while(rs.next()) {
				int code = rs.getInt(1);
				String nom = rs.getString(2);
				Boolean enLigne = rs.getBoolean(3);
				Categorie c = new Categorie(code,nom,enLigne);
				cats.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cats;
	}
	
	public static int update(Categorie c,String newNom, boolean newenLigne) {
		String req = "Update categorie Set nom_cat = ? , enligne = ? where code = ?;";
		PreparedStatement ps;
		try {
			ps = SingletonConnexion.getCon().prepareStatement(req);
			ps.setString(1,newNom);
			ps.setBoolean(2,newenLigne);
			ps.setInt(3, c.getCode());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
