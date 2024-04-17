package metier;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.SingletonConnexion;

public class CrudCategorie {
	
	public static int add(Categorie c) {
		String req="insert into categorie (nom_cat,enLigne) values (?,?);";
		PreparedStatement ps;
		try {
			ps = SingletonConnexion.getCon().prepareStatement(req);
			ps.setString(1,c.getnom_cat());
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
	
	
}
