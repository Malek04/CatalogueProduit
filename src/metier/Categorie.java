package metier;

public class Categorie {
	private int code;
	private String nom_cat;
	private boolean enLigne;
	
	public boolean isEnLigne() {
		return enLigne;
	}
	public void setEnLigne(boolean enLigne) {
		this.enLigne = enLigne;
	}
	public String getnom_cat() {
		return nom_cat;
	}
	public void setnom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}
	public int getCode() {
		return code;
	}
	public Categorie(int code, String nom_cat, boolean enLigne) {
		super();
		this.code = code;
		this.nom_cat = nom_cat;
		this.enLigne = enLigne;
	}
	public Categorie(String nom_cat, boolean enLigne) {
		super();
		this.nom_cat = nom_cat;
		this.enLigne = enLigne;
	}
	@Override
	public String toString() {
		return "Categorie [code=" + code + ", nom_cat=" + nom_cat + ", enLigne=" + enLigne + "]";
	}
	
	

}
