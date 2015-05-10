package password;

import java.io.Serializable;
/**
 * Predstavlja jedan unos pasvorda koji se cuva
 * @author Z3|jK0, R@, 0tAsH
 * @version 1.0.3
 */

@SuppressWarnings("serial")
public class Password implements Serializable {
	/**
	 * Ime naloga
	 */
	private String account;
	/**
	 * Username naloga
	 */
	private String username;
	/**
	 * Sifra naloga
	 */
	private String password;
	
	/**
	 * Metoda vraca ime naloga
	 * @return ime naloga kao String
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * Metoda postavlja ime naloga na unetu vrednost.
	 * @param account naziv naloga
	 * @throws java.lang.RuntimeException ako je unet naziv naloga
	 * <ul>
	 * 	<li>null</li>
	 *  <li>prazan String</li>
	 * </ul>
	 */
	public void setAccount(String account) {
		if (account == null || account.isEmpty())
			throw new RuntimeException("You must enter account name.");
		this.account = account;
	}
	/**
	 * Metoda vraca username naloga
	 * @return username naloga kao String
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Metoda postavlja username naloga na unetu vrednost.
	 * @param username username naloga
	 * @throws java.lang.RuntimeException ako je unet username naloga
	 * <ul>
	 * 	<li>null</li>
	 *  <li>prazan String</li>
	 * </ul>
	 */
	public void setUsername(String username) {
		if (username == null || username.isEmpty())
			throw new RuntimeException("You must enter username.");
		this.username = username;
	}
	/**
	 * Metoda vraca sifru naloga
	 * @return sifra naloga kao String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Metoda postavlja sifru naloga na unetu vrednost.
	 * @param password sifra naloga
	 * @throws java.lang.RuntimeException ako je uneta sifra naloga
	 * <ul>
	 * 	<li>null</li>
	 *  <li>prazan String</li>
	 * </ul>
	 */
	public void setPassword(String password) {
		if (password == null || password.isEmpty())
			throw new RuntimeException("You must enter password.");
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Password))
			return false;

		Password pw = (Password) obj;
		if (this.getAccount().equals(pw.getAccount())
				&& this.getPassword().equals(pw.getPassword())
				&& this.getUsername().equals(pw.getUsername()))
			return true;
		else
			return false;
	}
}
