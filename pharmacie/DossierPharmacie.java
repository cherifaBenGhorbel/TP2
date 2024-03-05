package pharmacie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DossierPharmacie {

	private String nom;
	private HashMap<String, Patient> patients;
	
	public DossierPharmacie(String n) {
		nom = n;
		patients = new HashMap<String, Patient>();
	}

	void nouveauPatient ( String nom , Patient ord ){
		String nomEnMinuscules = nom.toLowerCase();
		if (!patients.containsKey(nomEnMinuscules)) {
            patients.put(nomEnMinuscules, ord);
        } else {
            System.out.println("Un patient avec le nom " + nom + " existe deje.");
        }
	}
	
    public boolean ajoutMedicament(String nom, String m) {
        String nomEnMinuscules = nom.toLowerCase();
        if (patients.containsKey(nomEnMinuscules)) {
            patients.get(nomEnMinuscules).ajoutMedicament(m);
            return true;
        } else {
            return false;
        }
    }
    public void affichePatient(String nom) {
        String nomEnMinuscules = nom.toLowerCase();
        if (patients.containsKey(nomEnMinuscules)) {
            patients.get(nomEnMinuscules).affiche();
        } else {
            System.out.println("Patient " + nom + " non trouve");
        }
    }
    
    public void affiche() {
        System.out.println("Nom de la pharmacie: " + nom);
        for (Patient patient : patients.values()) {
            patient.affiche();
        }
    }
    
    public Collection<String> affichePatientAvecMedicament(String m) {
        Collection<String> patientsAvecMedicament = new ArrayList<>();
        for (Patient patient : patients.values()) {
            if (patient.contientMedicament(m)) {
                patientsAvecMedicament.add(patient.getNom());
            }
        }
        return patientsAvecMedicament;
    }
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public HashMap<String, Patient> getPatients() {
		return patients;
	}

	public void setPatients(HashMap<String, Patient> patients) {
		this.patients = patients;
	}
}
