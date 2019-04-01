package org.GestionEtu;

import java.util.List;
import java.util.Date;


public class Groupe {

    private String nom;
    private String proprietaire;
    private Date dateCreation;
    private List<Etudiant> membres;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Etudiant> getMembres() {
        return membres;
    }

    public void setMembres(List<Etudiant> membres) {
        this.membres = membres;
    }

    public Groupe(String nom, String proprietaire, Date dateCreation, List<Etudiant> membre) {
        this.nom = nom;
        this.proprietaire = proprietaire;
        this.dateCreation = dateCreation;
        this.membres = membre;
    }

    public void modif(String nom, String proprietaire, Date dateCreation, List<Etudiant> membre){
        this.nom = nom;
        this.proprietaire = proprietaire;
        this.dateCreation = dateCreation;
        this.membres = membre;
    }

    public void suppr(){
        this.nom = null;
        this.proprietaire = null;
        this.dateCreation = null;
        this.membres = null;
    }

    public Groupe clone(){
        return this;
    }

    public void add(Etudiant e){
        this.membres.add(e);
    }

    public void add(Groupe g) {
        int n = this.membres.size();
        int i=0;
        while (i<n){
            Etudiant e = g.membres.get(i);
            this.membres.add(e);
            i++;
        }
    }
    
}
