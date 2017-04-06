package com.twitter.poruka;
/**
 * Klasa koja predstavlja twitter poruku
 * @author Jovana Mitrovic
 * @version 1.0
 */
public class TwitterPoruka {
	/**
	 * Ime korisnika koji unosi poruku.
	 */
	private String korisnik;
	/**
	 * Poruka koja se unosi.
	 */
	private String poruka;
	
	/**
	 * Vraca vrednost atributa korisnik.
	 * @return ime korisnika kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Postavlja novu vrednost atributa korisnik
	 * @param korisnik ime novog korisnika
	 * @throws java.lang.RuntimeException ako je unet korisnik kao
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if(korisnik==null || !korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca vrednost atributa poruka kao String.
	 * @return sadrzaj poruke kao String
	 */
	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * Postavlja novu vrednost atributa poruka.
	 * @param poruka novi sadrzaj poruke
	 * @throws java.lang.RuntimeException ako je unet sadrzaj kao
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>String duzi od 140 znakova</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if(poruka==null || poruka==new String("") || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		
		this.poruka = poruka;
	}

	/**
	 * Vraca String sa svim podacima klase TwitterPoruka
	 * @return Ime korisnika i sadrzaj poruke
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
	
	
}
