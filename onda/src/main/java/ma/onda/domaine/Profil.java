package ma.onda.domaine;
import java.util.Collection;

public class Profil {
   private int idProfil;
   private ProfilType nomProfil;
   private Collection<Fonction> fonctions;
   
  
public Profil() {
	super();
	// TODO Auto-generated constructor stub
}
public int getIdProfil() {
	return idProfil;
}
public void setIdProfil(int idProfil) {
	this.idProfil = idProfil;
}
public ProfilType getNomProfil() {
	return nomProfil;
}
public void setNomProfil(ProfilType nomProfil) {
	this.nomProfil = nomProfil;
}
public Collection<Fonction> getFonctions() {
	return fonctions;
}
public void setFonctions(Collection<Fonction> fonctions) {
	this.fonctions = fonctions;
}
   
  

   

}