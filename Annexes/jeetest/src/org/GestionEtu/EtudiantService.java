package org.GestionEtu;

import java.util.List;

public interface EtudiantService {

	/**
	 * find all students without any criteria
	 * 
	 * @return a list of Etudiant objects
	 */
	List<Etudiant> getAllStudents();

	/**
	 * find by whose title contains a string
	 * 
	 * @param searchText
	 *            the pattern to search
	 * @return a list of books whose title contains searchText
	 */
	List<Etudiant> getStudentsByName(String searchText);

}
