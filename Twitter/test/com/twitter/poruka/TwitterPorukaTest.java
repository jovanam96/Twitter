package com.twitter.poruka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	private TwitterPoruka t;

	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testSetKorisnik() {
		t.setKorisnik("jovanam96");
		
		assertEquals("jovanam96", t.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		t.setKorisnik("");
	}
	
	@Test
	public void testSetPoruka() {
		t.setPoruka("Danasnji twit");
		
		assertEquals("Danasnji twit", t.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		t.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		t.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrekoracenje() {
		t.setPoruka("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	}

	@Test
	public void testToString() {
		String expected = "KORISNIK:"+t.getKorisnik()+" PORUKA:"+t.getPoruka();
		
		assertEquals(expected, t.toString());
	}

}