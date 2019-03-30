package org.GestionEtu;

import java.util.Date;

/**
 * Etudiant modelisation
 * 
 */
public class Etudiant {

	// Etudiant db id
	private String id;

	// Etudiant prenom
	private String prenom;

	// Etudiant nom
	private String nom;

	// Etudiant sexe
	private String s;

	// Etudiant dateNaissance
	private String dateNaissance;

	// Etudiant courrielPro
	private String pro;

	// Etudiant courrielPerso
	private String perso;

	// Etudiant serieBac
	private String bac;

	// Etudiant dateBac
	private String dateBac;

	// Etudiant mentionBac
	private String mention;

	// Etudiant date inscription
	private String inscription;

	// Etudiant diplome
	private String diplome;

	// Etudiant Datediplome
	private String dateDiplome;

	// Etudiant Villediplome
	private String villeDiplome;

	public Etudiant() {
		// nothing to do
	}

	public Etudiant(String id, String p, String n,String s, String d1, String d2, String d3, String cpro, String cper, String l, String m,String i, String d, String v) {
		this.id = id;
		this.prenom = p;
		this.nom = n;
		this.s = s;
		this.dateNaissance = d1;
		this.dateBac = d2;
		this.dateDiplome = d3;
		this.pro = cpro;
		this.perso = cper;
		this.bac = l;
		this.mention = m;
		this.inscription = i;
		this.diplome = d;
		this.villeDiplome = v;
	}

	@Override
	public String toString(){
		return "Etudiant no : "+this.id+", prenom : "+this.prenom+ " , nom : " + this.nom+ " , né(e) le "+this.dateNaissance+
				" , a obtenu le bac "+this.bac+" le "+this.dateBac+ " mention "+ this.mention+" , a obtenu le diplôme "+this.diplome+
				" , le "+this.dateDiplome+ " à "+this.villeDiplome+ " , mail pro: "+this.perso+ " , mail perso: "+this.perso ;
	}

	public void modif(String id, String p, String n,String s, String d1, String d2, String d3, String cpro, String cper,String l, String m,String i, String d, String v) {
		this.id = id;
		this.prenom = p;
		this.nom = n;
		this.s = s;
		this.dateNaissance = d1;
		this.dateBac = d2;
		this.dateDiplome = d3;
		this.pro = cpro;
		this.perso = cper;
		this.bac = l;
		this.mention = m;
		this.inscription = i;
		this.diplome = d;
		this.villeDiplome = v;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getInscription() {
		return inscription;
	}

	public void setInscription(String inscription) {
		this.inscription = inscription;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getPerso() {
		return perso;
	}

	public void setPerso(String perso) {
		this.perso = perso;
	}

	public String getBac() {
		return bac;
	}

	public void setBac(String bac) {
		this.bac = bac;
	}

	public String getDateBac() {
		return dateBac;
	}

	public void setDateBac(String dateBac) {
		this.dateBac = dateBac;
	}

	public String getMention() {
		return mention;
	}

	public void setMention(String mention) {
		this.mention = mention;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getDateDiplome() {
		return dateDiplome;
	}

	public void setDateDiplome(String dateDiplome) {
		dateDiplome = dateDiplome;
	}

	public String getVilleDiplome() {
		return villeDiplome;
	}

	public void setVilleDiplome(String villeDiplome) {
		villeDiplome = villeDiplome;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}