package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruka.TwitterPoruka;

public class TwitterTest {
	private Twitter t;
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testUnesi() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("jovanam96");
		tp.setPoruka("Danasnji twit");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		
		assertEquals(tp, t.vratiSvePoruke().getLast());
	}
	
	
	@Test
	public void testUnesiBrojElemenata() {
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("neko");
		tp1.setPoruka("nesto");
		t.unesi(tp1.getKorisnik(), tp1.getPoruka());
		int brojac = t.vratiSvePoruke().size();
		assertFalse(t.vratiSvePoruke().isEmpty());
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("jovanam96");
		tp.setPoruka("Danasnji twit");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		assertEquals(brojac+1, t.vratiSvePoruke().size());
	}
	
	@Test
	public void testVratiPoruke() {
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("jovanam96");
		tp1.setPoruka("tag");
		t.unesi(tp1.getKorisnik(), tp1.getPoruka());
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("neko");
		tp2.setPoruka("nesto tag");
		t.unesi(tp2.getKorisnik(), tp2.getPoruka());
		TwitterPoruka[] rezultat = {tp1, tp2};
		assertArrayEquals(rezultat, t.vratiPoruke(2, "tag"));
	}
	
	@Test
	public void testVratiPorukeNegativno() {
		assertEquals(t.vratiPoruke(-100, "tag").length, 100);
		
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(100, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(100, "");
	}
}