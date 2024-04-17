package metier;

public class Produit {
	private int ref;
	private String nomProd;
	private double prix;
	private int qte;
	private int cat;
	
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getcat() {
		return cat;
	}
	public void setcat(int cat) {
		this.cat = cat;
	}
	public int getRef() {
		return ref;
	}
	public Produit(int ref, String nomProd, double prix, int qte, int cat) {
		super();
		this.ref = ref;
		this.nomProd = nomProd;
		this.prix = prix;
		this.qte = qte;
		this.cat = cat;
	}
	public Produit(String nomProd, double prix, int qte, int cat) {
		super();
		this.nomProd = nomProd;
		this.prix = prix;
		this.qte = qte;
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Produit [ref=" + ref + ", nomProd=" + nomProd + ", prix=" + prix + ", qte=" + qte + ", cat="
				+ cat + "]";
	}
	
}
