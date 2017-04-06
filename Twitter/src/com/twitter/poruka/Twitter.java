package com.twitter.poruka;

import java.util.LinkedList;

import com.twitter.poruka.TwitterPoruka;

public class Twitter {
	
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	
	public void unesi(String korisnik, String poruka) {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		
		poruke.addLast(tp);
	}
	
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
