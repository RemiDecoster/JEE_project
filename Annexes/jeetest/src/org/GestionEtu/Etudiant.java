package org.GestionEtu;

import java.util.Date;

/**
 * Etudiant modelisation
 * 
 */
public class Etudiant {

	// Etudiant db id
	private int id;

	// Etudiant prenom
	private String prenom;

	// Etudiant nom
	private String nom;

	// Etudiant dateNaissance
	private Date dateNaissance;

	// Etudiant courrielPro
	private String pro;

	// Etudiant courrielPerso
	private String perso;

	// Etudiant serieBac
	private String bac;

	// Etudiant dateBac
	private Date dateBac;

	// Etudiant mentionBac
	private String mention;

	// Etudiant diplome
	private String diplome;

	// Etudiant Datediplome
	private Date dateDiplome;

	// Etudiant Villediplome
	private String villeDiplome;

	public Etudiant() {
		// nothing to do
	}

	public Etudiant(int id, String p, String n, Date d1, Date d2, Date d3, String cpro, String cper,String s, String m, String d, String v) {
		this.id = id;
		this.prenom = p;
		this.nom = n;
		this.dateBac = d1;
		this.dateDiplome = d2;
		this.dateNaissance = d3;
		this.pro = cpro;
		this.perso = cper;
		this.bac = s;
		this.mention = m;
		this.diplome = d;
		this.villeDiplome = v;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
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

	public Date getDateBac() {
		return dateBac;
	}

	public void setDateBac(Date dateBac) {
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

	public Date getDateDiplome() {
		return dateDiplome;
	}

	public void setDateDiplome(Date dateDiplome) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}