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
	 * @return a list of books built from the SQL query
	 */
	private List<Etudiant> findBy(String query) {
		Connection conn = null;
		List<Etudiant> listBooks = new ArrayList<Etudiant>();
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getInstance().getConnection();
			if (conn != null) {
				stat = conn.createStatement();
				rs = stat.executeQuery(query);
				while (rs.next()) {
					int id = rs.getInt("id");
					String prenom = rs.getString("prenom");
					String nom = rs.getString("nom");
					Date d1 = rs.getDate("dateBac");
					Date d2 = rs.getDate("dateDiplome");
					Date d3 = rs.getDate("dateNaissance");
					String cp = rs.getString("pro");
					String c = rs.getString("perso");
					String s = rs.getString("bac");
					String m = rs.getString("mention");
					String d = rs.getString("diplome");
					String v = rs.getString("villeDiplome");
					listBooks.add(new Etudiant(id, prenom, nom, d1, d2, d3, cp, c, s, m, d, v));
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
		return listBooks;
	}

	public List<Etudiant> findByAll() {
		// avoid select * queries because of performance issues,
		// only query the columns you need
		return findBy("select id,prenom, nom, d1, d2, d3, cp, c, s, m, d, v from students");
	}

	// recherche l'etudiant par son prenom (pas son nom)
	public List<Etudiant> findByName(String searchText) {
		// watch out : this query is case sensitive. use upper function on title
		// and searchText to make it case insensitive
		return findBy("select id,prenom, nom, d1, d2, d3, cp, c, s, m, d, v from books where prenom like '%" + searchText + "%'");

	}
}
