package password;

import java.util.LinkedList;

/**
 * Predstavlja korisnika aplikacije
 * 
 * @author Z3|jK0, R@, 0tAsH
 * 
 */
public class User {

	/**
	 * Predstavlja ime korisnika
	 */
	private String name;
	/**
	 * Predstavlja sifru korisnika
	 */

	private String password;

	/**
	 * Predstavlja sacuvane unose korisnika
	 */
	private LinkedList<Password> passwords = new LinkedList<Password>();

	/**
	 * Metoda vraca ime korisnika
	 * 
	 * @return name ime korisnika kao String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metoda postavlja ime korisnika na unetu vrednost.
	 * 
	 * @param name
	 *            ime korisnika
	 * @throws java.lang.RuntimeException
	 *             ako je uneto ime
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan String</li>
	 *             </ul>
	 */
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new RuntimeException("You must enter account name.");
		}
		this.name = name;
	}

	/**
	 * Metoda vraca sifru korisnika
	 * 
	 * @return password sifra korisnika kao String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Metoda postavlja sifru korisnika na unetu vrednost.
	 * 
	 * @param password
	 *            sifra korisnika
	 * @throws java.lang.RuntimeException
	 *             ako je uneta sifra
	 *             <ul>
	 *             <li>null</li>
	 *             <li>prazan String</li>
	 *             </ul>
	 */
	public void setPassword(String password) {
		if (password == null || password.isEmpty()) {
			throw new RuntimeException("You must enter a password.");
		}
		this.password = password;
	}

}
