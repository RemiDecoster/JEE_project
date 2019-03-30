package org.GestionEtu;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAOMockImpl implements EtudiantDAO {

	@Override
	public List<Etudiant> findByAll() {
		Date d1 = new Date(10,15,06);
		Date d3 = new Date(10,15,06);
		Date d2 = new Date(10,15,06);

		List<Etudiant> listBooks = new ArrayList<Etudiant>();
		listBooks.add(new Etudiant(1, "Alice", "Lewis", d1,  d2,  d3,  "Alice@bigcorp.com",  "Alice@lol.com", "S",  "bien",  "Licence",  "Paris"));
		return listBooks;
	}

	@Override
	public List<Etudiant> findByName(String searchText) {
		return findByAll(); // search will return all students for testing purpose
	}
	@Override
	public Etudiant findById(int searchId) {
		//TODO remplacer l'overide
		Date d1 = new Date(10,15,06);
		Date d3 = new Date(10,15,06);
		Date d2 = new Date(10,15,06);
		Etudiant e = new Etudiant(1, "Alice", "Lewis", d1,  d2,  d3,  "Alice@bigcorp.com",  "Alice@lol.com", "S","bien",  "Licence",  "Paris");
		return e;
		}
	}
