package ma.onda.domaine;
import java.util.Collection;

public class Rejet {
   private int id_Rejet;
   private java.util.Date date_Rejet;
   private DirectionConcernee dir_Con;
   private Collection<Motif> motifs;
   
  public Rejet(){
	  super();
	// TODO Auto-generated constructor stub
  }
 public int getId_Rejet() {
	return id_Rejet;
}
public void setId_Rejet(int id_Rejet) {
	this.id_Rejet = id_Rejet;
}
public java.util.Date getDate_Rejet() {
	return date_Rejet;
}
public void setDate_Rejet(java.util.Date date_Rejet) {
	this.date_Rejet = date_Rejet;
}
public DirectionConcernee getDir_Con() {
	return dir_Con;
}
public void setDir_Con(DirectionConcernee dir_Con) {
	this.dir_Con = dir_Con;
}
public Collection<Motif> getMotifs() {
	return motifs;
}
public void setMotifs(Collection<Motif> motifs) {
	this.motifs = motifs;
}
}