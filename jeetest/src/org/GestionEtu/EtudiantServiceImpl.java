package org.GestionEtu;

import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {

	// choose the DAO data source : DB or Mock
	private EtudiantDAO etuDao = new EtudiantDAOImpl(); // or new EtudiantDAOMockImpl();

	@Override
	public List<Etudiant> getAllStudents() {
		List<Etudiant> listEtus = etuDao.findByAll();
		return listEtus;
	}

	@Override
	// donne les etudiants selon leur prenom (et pas nom)
	public List<Etudiant> getStudentsByName(String searchText) {
		List<Etudiant> listBooks = etuDao.findByName(searchText);
		return listBooks;
	}

}
