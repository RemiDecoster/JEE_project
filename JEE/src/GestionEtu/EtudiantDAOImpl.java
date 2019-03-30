package org.GestionEtu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Etudiant DAO to get students from DB
 * 
 * @see EtudiantDAO
 * 
 */
public class EtudiantDAOImpl implements EtudiantDAO {

	/**
	 * common method used to query DB
	 * 
	 * @param query
	 *            the SQL query to use
	 * @return a list of students built from the SQL query
	 */
	private List<Etudiant> findBy(String query) {
		Connection conn = null;
		List<Etudiant> listStudents = new ArrayList<Etudiant>();
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getInstance().getConnection();
			if (conn != null) {
				stat = conn.createStatement();
				rs = stat.executeQuery(query);
				while (rs.next()) {
					String id = rs.getString("id");
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					String s = rs.getString("S");
					String d2 = rs.getString("dateBac");
					String d3 = rs.getString("dateDiplome");
					String d1 = rs.getString("dateNaissance");
					String cp = rs.getString("pro");
					String c = rs.getString("perso");
					String l = rs.getString("bac");
					String m = rs.getString("mention");
					String i = rs.getString("inscription");
					String d = rs.getString("diplome");
					String v = rs.getString("villeDiplome");
					listStudents.add(new Etudiant(id, prenom, nom, s, d1, d2, d3, cp, c, l, m, i, d, v));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception : main exception should thrown to servlet
			// layer to display error message
			e.printStackTrace();

		} finally {
			// always clean up all resources in finally block
			if (conn != null) {
				DBManager.getInstance().cleanup(conn, stat, rs);
			}
		}
		return listStudents;
	}

	private void insertIn(Etudiant etu ) {

		Connection conn = null;
		//List<Etudiant> listStudents = new ArrayList<Etudiant>();
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getInstance().getConnection();
			if (conn != null) {
				stat = conn.createStatement();
				String id = etu.getId();
				String nom = etu.getNom();
				String prenom = etu.getPrenom();
				String d1 = etu.getDateNaissance();
				String cp = etu.getPro();
				String c =  etu.getPerso();
				String b = etu.getBac();
				String d2 = etu.getDateBac();
				String m = etu.getMention();
				String d = etu.getDiplome();
				String d3 = etu.getDateDiplome();
				String v = etu.getVilleDiplome();
				String s = etu.getS();
				String i = etu.getInscription();
				String query = "insert into Etudiant values ('" + id + "','" + nom + "','" + prenom + "','" + d1 +
						"','" + cp + "','" + c + "','" + b + "','" + d2 + "','" + m + "','" + d + "','" + d3 + "','" + v + "','" + s + "','" + i + "');";
				rs = stat.executeQuery(query);
			}
		} catch (Exception e) {
			// TODO: handle exception : main exception should thrown to servlet
			// layer to display error message
			e.printStackTrace();

		} finally {
			// always clean up all resources in finally block
			if (conn != null) {
				DBManager.getInstance().cleanup(conn, stat, rs);
			}
		}
	}

	public List<Etudiant> findByAll() {
		// avoid select * queries because of performance issues,
		// only query the columns you need
		return findBy("select numetudiant,nom, prenom, ddn, emailPro, emailPerso, bac, anBac, menBac, diplome, anDiplome, villeDiplome S inscription from Etudiants");
		//TODO corriger avec les bons parametres de la BDD
	}


	/**
	 * common method used print all students
	 *
	 * @param l
	 *            a list of Etudiant to use
	 * Display all students in the list
	 *
	 */

	public void afficher(List<Etudiant> l){
		int n = l.size();
		int k=0;
		while (k<n) {
			System.out.println(l.get(k));
			k++;
		}

	}

	// recherche l'etudiant par son prenom (pas son nom)
	public List<Etudiant> findByName(String searchText) {
		// watch out : this query is case sensitive. use upper function on title
		// and searchText to make it case insensitive
		return findBy("select numetudiant,nom, prenom, ddn, emailPro, emailPerso, bac, anBac, menBac, diplome, anDiplome, villeDiplome S inscription from Etudiants where prenom like '%" + searchText + "%'");

	}
	// recherche l'etudiant par son identifiant (donc un seul etudiant)
	public Etudiant findById(int searchId) {
		// watch out : this query is case sensitive. use upper function on title
		// and searchText to make it case insensitive
		List<Etudiant> tab;
		tab = findBy("select numetudiant,nom, prenom, ddn, emailPro, emailPerso, bac, anBac, menBac, diplome, anDiplome, villeDiplome S inscription from Etudiants where numetudiant like '" + searchId +"'");
	return tab.get(0);
	}

	public void supprimerEtu(int etuId, List<Etudiant> l){
		List<Etudiant> tab;
		Etudiant etu;
		tab = findBy("select numetudiant,nom, prenom, ddn, emailPro, emailPerso, bac, anBac, menBac, diplome, anDiplome, villeDiplome S inscription from students where numetudiant like '" + etuId +"'");
		etu = tab.get(0);
		l.remove(etu);

	}


}
