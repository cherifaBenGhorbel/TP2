package pharmacie;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient {

	private String nom;
	private Set<String> ordonnance;

	public Patient(String n) {
		nom = n;
		ordonnance = new HashSet<String>();
	}

	public boolean ordonnanceVide() {
		return this.ordonnance.isEmpty();
	}
	
	public void ajoutMedicament (String m) {
		this.ordonnance.add(m);
	}

	public void affiche(){
		System.out.println("Le nom de patient est :" + this.getNom());
		System.out.println("L''ordonnance de patient est :" + this.getOrdonnance());
		
	}
	
	public boolean contientMedicament(String m) {
		return this.ordonnance.contains(m);
	}
	
	
	
	public void trieOrdonnace() {
		Set <String> ordTrie = new TreeSet<>(this.ordonnance);
		this.ordonnance = ordTrie;
		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<String> getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Set<String> ordonnance) {
		this.ordonnance = ordonnance;
	}
}
