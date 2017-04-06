package com.twitter.poruka;

import java.util.LinkedList;

import com.twitter.poruka.TwitterPoruka;

/**
 * Klasa koja sadrzi listu twitter poruka i njene standardne metode.
 * @author Jovana Mitrovic
 * @version 2.0
 */
public class Twitter {
	/**
	 * Atribut koji predstavlja listu twiitter poruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda koja vraca listu svih twitter poruka.
	 * @return sve twitter poruke kao listu
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	
	/**
	 * Metoda koja unosi novu twitter poruku i njenog korisnika u listu
	 * @param korisnik ime novog korisnika kao String
	 * @param poruka sadrzaj nove poruke kao String
	 */
	public void unesi(String korisnik, String poruka) {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda koja pretrazuje sve twitter poruke i vraca one koje sadrze dati tag kao niz
	 * @param maxBroj kapacitet niza koji sadrzi poruke sa datim tagom
	 * @param tag rec/recenica koja mora biti sadrzana u poruci
	 * @return niz poruka koje sadrze dati tag
	 * @throws java.lang.RuntimeException ako je unet tag kao:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if(tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		
		if(maxBroj<=0)
			maxBroj = 100;
		
		int brojac = 0;
		
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
	
		for (int i = 0; i < poruke.size(); i++) 
			if(poruke.get(i).getPoruka().indexOf(tag)!=1)
				if(brojac < maxBroj) {
					rezultat[brojac+1]=poruke.get(i);
					brojac++;
				}
				else break;
			
		return rezultat;
	}
	
}
