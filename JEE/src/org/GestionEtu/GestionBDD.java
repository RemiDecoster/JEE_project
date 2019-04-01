package org.GestionEtu;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.util.Enumeration;
//import java.util.Properties;
//import java.util.ResourceBundle;;
import java.util.*;


public class GestionBDD {
	
	
	
	private List<String> messages = new ArrayList<String>();
	
	
	private static GestionBDD gestion = new GestionBDD();
	
	private GestionBDD() {
		 /* Chargement du driver JDBC pour MySQL */
		try {
	        Class.forName( "com.mysql.jdbc.Driver" );
	    } catch ( ClassNotFoundException e ) {
	    	e.printStackTrace();
	    }
	}
	
	public static GestionBDD getInstance() {
		return gestion;
	}
	
	//Méthode de test de l'utilisateur 
	public boolean isUser(HttpServletRequest request) throws SQLException {
		boolean isUser = false;
		Connection connexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultat = null;

    
	    String pseudo = (String) request.getParameter("pseudo");
	    String mdp = (String) request.getParameter("password");
	    
	    
	    if(pseudo != null && mdp != null) {
	    	//vérification des pseudo et mot de passe dans la base de donnée 
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
		        connexion = (Connection) DBManager.getInstance().getConnection();
	    		statement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM Users where pseudo=? and password=?");
		        statement.setString(1, pseudo);
		        statement.setString(2,  mdp);
		        resultat = statement.executeQuery();
	        } catch ( SQLException e ) {
	        	e.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
		        if ( resultat != null ) {
		            try {
		            	//S'il y a un utilisateur dans la base de données avec le pseudo et le mot de passe voulus, isUser passe à True
		            	isUser= found(resultat);
		                resultat.close();
		            } catch ( SQLException ignore ) {
		            	ignore.printStackTrace();
		            }
		        }
		        if ( statement != null ) {
		            try {
		                statement.close();
		            } catch ( SQLException ignore ) {
		            }
		        }
		        if ( connexion != null ) {
		            try {
		                connexion.close();
		            } catch ( SQLException ignore ) {
		            	ignore.printStackTrace();
		            }
		        }
			}
	    }
	    return isUser;
	}


	//Méthode renvoyant les droits d'un utilisateur dans un tableau (de longueur 3)
	public boolean[] getStatus(HttpServletRequest request) throws SQLException {
		boolean  [] status = new boolean[3];//Position 0 : isUser //Position 1  isEditor //Position 2 : isAdmin
		Connection connexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultat = null;
	    String pseudo = (String) request.getParameter("pseudo");
	    String mdp = (String) request.getParameter("password");
	    
	    if(pseudo != null && mdp != null) {
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
		        connexion = (Connection) DBManager.getInstance().getConnection();
	    		statement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM Users where pseudo=? and password=?");
		        statement.setString(1, pseudo);
		        statement.setString(2,  mdp);
		        resultat = statement.executeQuery();
	        } catch ( SQLException e ) {
	        	e.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
		        if ( resultat != null ) {
		            try {
		            	if(found(resultat)) {
		            		status[0] = true;
		            		status[1] = resultat.getBoolean("isEditor");
		            		status[2] = resultat.getBoolean("isAdmin");
		            	}
		                resultat.close();
		            } catch ( SQLException ignore ) {
		            	ignore.printStackTrace();
		            }
		        }
		        if ( statement != null ) {
		            try {
		                statement.close();
		            } catch ( SQLException ignore ) {
		            }
		        }
		        if ( connexion != null ) {
		            try {
		                connexion.close();
		            } catch ( SQLException ignore ) {
		            	ignore.printStackTrace();
		            }
		        }
			}
	    }
	    return status;
	}

	//Méthode de test de l'editeur
	public boolean isEditor(HttpServletRequest request) throws SQLException {
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;
		boolean isAdmin = false;
		String pseudo = (String) request.getParameter("pseudo");
		String mdp = (String) request.getParameter("password");

		if(pseudo != null && mdp != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connexion = (Connection) DBManager.getInstance().getConnection();
				statement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM Users where pseudo=? and password=?");
				statement.setString(1, pseudo);
				statement.setString(2,  mdp);
				resultat = statement.executeQuery();
			} catch ( SQLException e ) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				if ( resultat != null ) {
					try {
						if(found(resultat)) {
							isAdmin= resultat.getBoolean("isEditor");
						}
						resultat.close();
					} catch ( SQLException ignore ) {
						ignore.printStackTrace();
					}
				}
				if ( statement != null ) {
					try {
						statement.close();
					} catch ( SQLException ignore ) {
					}
				}
				if ( connexion != null ) {
					try {
						connexion.close();
					} catch ( SQLException ignore ) {
						ignore.printStackTrace();
					}
				}
			}
		}
		return isAdmin;
	}

	//Méthode de test de l'administrateur
	public boolean isAdmin(HttpServletRequest request) throws SQLException {
		Connection connexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultat = null;
	    boolean isAdmin = false;
	    String pseudo = (String) request.getParameter("pseudo");
	    String mdp = (String) request.getParameter("password");
	    
	    if(pseudo != null && mdp != null) {
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
		        connexion = (Connection) DBManager.getInstance().getConnection();
	    		statement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM Users where pseudo=? and password=?");
		        statement.setString(1, pseudo);
		        statement.setString(2,  mdp);
		        resultat = statement.executeQuery();
	        } catch ( SQLException e ) {
	        	e.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
		        if ( resultat != null ) {
		            try {
		            	if(found(resultat)) {
		            	isAdmin= resultat.getBoolean("isAdmin");
		            	}
		                resultat.close();
		            } catch ( SQLException ignore ) {
		            	ignore.printStackTrace();
		            }
		        }
		        if ( statement != null ) {
		            try {
		                statement.close();
		            } catch ( SQLException ignore ) {
		            }
		        }
		        if ( connexion != null ) {
		            try {
		                connexion.close();
		            } catch ( SQLException ignore ) {
		            	ignore.printStackTrace();
		            }
		        }
			}
	    }
	    return isAdmin;
	}
	
	public boolean found(ResultSet r) throws SQLException {
		return r.next();
	}

	
	
	/**
	 * enregisterJoueur : ajoute dans la BDD un nouvel utilisateur
	 * @param pseudo
	 * @param password
	 * @param question
	 * @param answer
	 * @return succes/echec
	 */
	public boolean insertUser(String pseudo, String password, String question, String answer) {
		Connection connexion = null;
	    PreparedStatement statement = null;
	    ResultSet resultat = null;
	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        /* Verification pseudo */
	        statement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM Users WHERE Players.pseudo = ? ;");
	        statement.setString(1, pseudo);
	        resultat = statement.executeQuery();
	        
	        if(!resultat.next()) {
	        	statement = (PreparedStatement) connexion.prepareStatement("INSERT INTO Users (`pseudo`, `password`, `question`, `answer`, `isEditor`, `isAdmin`) VALUES (?,?,?,?,0,0);");
		        statement.setString(1, pseudo);
		        statement.setString(2, password);
		        statement.setString(3, question);
		        statement.setString(4, answer);
		        statement.execute();
		        statement.close();
		        System.out.println("Inscription reussi");
		        return true;
	        } else {
	        	// pseudo deja utilise
	        	System.out.println("pseudo deja utilise");
	        	return false;
	        }	        
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
		return false;
	}





//*******************************************************USELESS***************************************************************

	/**
	 * enregisterPartie : ajoute dans la BDD une nouvelle Partie
	 * @param pseudo
	 * @param game
	 * @return succes/echec
	 */
	public void enregisterPartie(String pseudo, String game) {  //TODO changer pour Groupe
		Connection connexion = null;
	    PreparedStatement statement = null;
	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        statement = (PreparedStatement) connexion.prepareStatement("INSERT INTO Matchs (`pseudo`, `gameName`, `hBegin`) VALUES (?,?,CURRENT_TIMESTAMP());");
	        statement.setString(1, pseudo);
	        statement.setString(2, game);
	        System.out.println(pseudo+game);
	        statement.execute();
	        statement.close();
	        System.out.println("Le jeu va commencé");
	    } catch (SQLException e ) {
		   	e.printStackTrace();
		}
	}
	
	public void enregistrerStop(String pseudo, String game) {
		Connection connexion = null;
	    PreparedStatement statement = null;
	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        statement = (PreparedStatement) connexion.prepareStatement("UPDATE Matchs SET hEnd=CURRENT_TIMESTAMP() WHERE idMatch in (SELECT * FROM (SELECT max(idMatch) FROM Matchs WHERE pseudo=?) AS tmp) ;");
	        statement.setString(1,pseudo);
	        statement.execute();
	        statement.close();
	        System.out.println("Le partie est terminée");
	    } catch (SQLException e ) {
		   	e.printStackTrace();
		}
	}


	public ResultSet getGames() {
		Connection connexion = null;
	    PreparedStatement statement = null;

	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        /* Verification pseudo */
	        statement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM Games;");
	      return( statement.executeQuery());
	                      
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
		return null;
	}


	public void addGame(HttpServletRequest request) {
		Connection connexion = null;
	    PreparedStatement statement = null;
	    String name = (String) request.getParameter("name");
		   String info = (String) request.getParameter("infos");
		   String release = (String) request.getParameter("release");
		   System.out.println("Ajout d'un jeu : " +name + " " + info + " " + release);
		   
		   try {
		        connexion = (Connection) DBManager.getInstance().getConnection();

				   statement = (PreparedStatement) connexion.prepareStatement("INSERT INTO Games (`name`, `infos`, `release`, `isShowed`) VALUES (?,?,?,?)");
			        statement.setString(1, name);
			        statement.setString(2, info);
			        statement.setString(3, release);
			        statement.setString(4, "1");
			        statement.execute();
			        statement.close();
			   
		                      
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    }
	}

//***************************************************END_USELESS*******************************************************************







	/**
	 * deleteEtu : supprime dans la BDD un etudiant
	 * @param request
	 * @return succes/echec
	 */

	public void deleteEtu( HttpServletRequest request) {
		Connection connexion = null;
		PreparedStatement statement = null;
		String numetudiant = (String) request.getParameter("numetudiant");
		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement = (PreparedStatement) connexion.prepareStatement("Delete From Etudiants where numetudiant = ? ;");
			statement.setString(1, numetudiant);
			statement.execute();
			statement.close();
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}

	/**
	 * deleteEtu : supprime dans la BDD un groupe
	 * @param request
	 * @return succes/echec
	 */

	public void deleteGroup( HttpServletRequest request) {
		Connection connexion = null;
		PreparedStatement statement = null;
		String idGroupe = (String) request.getParameter("idGroupe");
		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement = (PreparedStatement) connexion.prepareStatement("Delete From Groupes where idGroupe = ? ;");
			statement.setString(1, idGroupe);
			statement.execute();
			statement.close();
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}

	
	public ResultSet getAllEtudiants() {
		Connection connexion = null;
	    PreparedStatement statement = null;

	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        /* Verification pseudo */
	        statement = (PreparedStatement) connexion.prepareStatement("SELECT * FROM Etudiants;");
	      return( statement.executeQuery());
	                      
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
		return null;
	}
	
	
	
	public ResultSet getAllGroups() {
		Connection connexion = null;
	    PreparedStatement statement = null;

	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        /* Verification pseudo */
	        statement = (PreparedStatement) connexion.prepareStatement("select * from Groupes;");
	      return( statement.executeQuery());
	                      
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
		return null;
	}



	//TODO Les (14-1) fonctions pour changer les attributs des étudiants,
	//TODO (5-1) pour changer les attributs des groupes (y compris la liste d'étudiants) et les 3 pour ceux d'un utlisateur CONNECTE

	public void changeMDP(HttpServletRequest request) {
		Connection connexion = null;
		PreparedStatement statement = null;
		String pseudo = (String) request.getParameter("pseudo");
		String newMdp = (String) request.getParameter("NewPassword");
		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement = (PreparedStatement) connexion.prepareStatement("Update Users set password = ? where pseudo = ? ;");
			statement.setString(1, newMdp);
			statement.setString(2, pseudo);
			statement.execute();
			statement.close();
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}



	public void mdpOublie(HttpServletRequest request) {
		Connection connexion = null;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet resultat = null;

		String pseudo = (String) request.getParameter("pseudo");
		String answer = (String) request.getParameter("answer");  //reponse donnée a la question personelle pour autoriser la modification
		String check = null; // reponse enregistrée dans la BDD a la question personelle
		String newMdp = (String) request.getParameter("NewPassword");

		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement2 = (PreparedStatement) connexion.prepareStatement("select answer from Users where pseudo = ?;");
			statement2.setString(1, pseudo);
			resultat = statement.executeQuery();
			if(resultat != null && resultat.next()) {
				check = resultat.getString("answer");
			}
			if (check==answer) {
				statement = (PreparedStatement) connexion.prepareStatement("Update Users set password = ? where pseudo = ? ;");
				statement.setString(1, newMdp);
				statement.setString(2, pseudo);
				statement.execute();
				statement.close();
			}
			else{
				System.out.println("Reponse a la question incorrect");
			}
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}



//*******************************************************USELESS***************************************************************

	public ResultSet getFinishedMatchs() {
		Connection connexion = null;
	    PreparedStatement statement = null;

	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        /* Verification pseudo */
	
	        statement = (PreparedStatement) connexion.prepareStatement("select * from Matchs where hEnd is not  NULL;");
	      return( statement.executeQuery());
	                      
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
		return null;
	}
	
	public ResultSet getPlays(String pseudo) {
		Connection connexion = null;
	    PreparedStatement statement = null;

	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        /* Verification pseudo */
	        statement = (PreparedStatement) connexion.prepareStatement("select count(*) from Matchs where pseudo = ?;");
	       
	        statement.setString(1, pseudo);
	      return( statement.executeQuery());
	                      
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
		return null;
	}
	


	
	public void ban(HttpServletRequest request) {
		
		Connection connexion = null;
	    PreparedStatement statement = null;
	    String pseudo = (String) request.getParameter("pseudo");
		   String ban = (String) request.getParameter("ban");
		   int abs = Math.abs( Integer.parseInt(ban) -1);
		   ban = Integer.toString(abs);
		
		   try {
		        connexion = (Connection) DBManager.getInstance().getConnection();

				    statement = (PreparedStatement) connexion.prepareStatement("Update Players set ban = ? where pseudo = ?  ");
			        statement.setString(1, ban);
			        statement.setString(2, pseudo);
			        statement.execute();
			        statement.close();
			   
		                      
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    }
		
		 
	}
	
	
	public void end(HttpServletRequest request) {
		
		Connection connexion = null;
	    PreparedStatement statement = null;
	    String id = (String) request.getParameter("id");
	
		  Date dNow = new Date();
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	     String d = ft.format(dNow) ;
			   
		   try {
		        connexion = (Connection) DBManager.getInstance().getConnection();

				    statement = (PreparedStatement) connexion.prepareStatement("Update Matchs set hEnd = ? where idMatch = ? ;");
			        statement.setString(1, d);
			        statement.setString(2, id);
			        statement.execute();
			        statement.close();
			   	                      
		} catch (SQLException e ) {
		    	e.printStackTrace();
	    }
		
	
		 
	}

	public void setShow(HttpServletRequest request, Boolean b) {
		Connection connexion = null;
	    PreparedStatement statement = null;
	    String name = request.getParameter("name");
	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        /* Verification pseudo */
	        statement = (PreparedStatement) connexion.prepareStatement("update Games set isShowed = ? where name = ?;");
	        statement.setBoolean(1, b);
	        statement.setString(2, name);
	        statement.executeUpdate();
	                      
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
	}

			
	/*public void changeMDP(HttpServletRequest request) {
		Connection connexion = null;
	    PreparedStatement statement = null;
	    String pseudo = (String) request.getParameter("pseudo");
	    String newMdp = (String) request.getParameter("NewPassword");
		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement = (PreparedStatement) connexion.prepareStatement("Update Players set password = ? where pseudo = ? ;");
			statement.setString(1, newMdp);
			statement.setString(2, pseudo);
			statement.execute();
			statement.close();        
		} catch (SQLException e ) {
		    e.printStackTrace();
	    }
	}*/

	
	public String getEmail(String pseudo) {
		Connection connexion = null;
		ResultSet resultat = null;
	    PreparedStatement statement = null;

	    /* Connexion à la base de données */
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        statement = (PreparedStatement) connexion.prepareStatement("select email from Players where pseudo = ?;");
	        statement.setString(1, pseudo);
	        resultat = statement.executeQuery();
	        if(resultat != null && resultat.next()) {
	        	return resultat.getString("email");
	        }
	    } catch (SQLException e ) {
	    	e.printStackTrace();
	    }
		return "";
	}

	public void changeEmail(HttpServletRequest request) {
		Connection connexion = null;
	    PreparedStatement statement = null;
	    String pseudo = (String) request.getParameter("pseudo");
	    String newEmail = (String) request.getParameter("newEmail");
		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement = (PreparedStatement) connexion.prepareStatement("Update Players set email = ? where pseudo = ? ;");
			statement.setString(1, newEmail);
			statement.setString(2, pseudo);
			statement.execute();
			statement.close();        
		} catch (SQLException e ) {
		    e.printStackTrace();
	    }
	}
	
	public ResultSet getPreferedGames(HttpServletRequest request) {
		Connection connexion = null;
		ResultSet resultat = null;
	    PreparedStatement statement = null;
	    String pseudo = (String) request.getAttribute("pseudo");
	    try {
	        connexion = (Connection) DBManager.getInstance().getConnection();
	        statement = (PreparedStatement) connexion.prepareStatement("select * from PreferedGames where pseudo = ?;");
	        statement.setString(1, pseudo);
	        return statement.executeQuery();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
		return null;	
	}

	public void removePreferedGames(String pseudo) {
		Connection connexion = null;
	    PreparedStatement statement = null;
		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement = (PreparedStatement) connexion.prepareStatement("Delete From PreferedGames where pseudo = ? ;");
			statement.setString(1, pseudo);   
			statement.execute();
			statement.close();               
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    }
	}

	public void addPreferedGames(String pseudo, String game) {
		Connection connexion = null;
	    PreparedStatement statement = null;
		try {
			connexion = (Connection) DBManager.getInstance().getConnection();
			statement = (PreparedStatement) connexion.prepareStatement("INSERT INTO PreferedGames (`pseudo`, `gameName`) VALUES (?,?);");
			statement.setString(1, pseudo);
			statement.setString(2, game);
			statement.execute();
			statement.close();               
		    } catch (SQLException e ) {
		    	e.printStackTrace();
		    }
	}
		
	
	
	
}

