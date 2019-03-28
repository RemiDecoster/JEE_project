package org.GestionEtu;

import java.util.List;

public interface EtudiantDAO {

	/**
	 * find all students without any criteria
	 * 
	 * @return a list of Etudiant objects
	 */
	List<Etudiant> findByAll();

	/**
	 * find by whose name contains a string
	 * 
	 * @param searchText
	 *            the pattern to search
	 * @return a list of student whose name contains searchText
	 */
	List<Etudiant> findByName(String searchText);

	/**
	 * find by whose id contains an int
	 *
	 * @param searchId
	 *            the pattern to search
	 * @return a list of student whose id contains searchId
	 */
	Etudiant findById(int searchId);
}
