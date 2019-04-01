package org.package_jee.users;

public class User {
	public User() {
		super();
	}
	
	private String pseudo;
	private boolean isAdmin;
	private boolean isEditor;
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isEditor() {
		return isEditor;
	}
	public void setEditor(boolean isEditor) {
		this.isEditor = isEditor;
	}
	public String toString() {
		return pseudo + " Admin : "+isAdmin+ ", Editeur : "+ isEditor;
	}
	
}