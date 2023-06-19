package Konto_04;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Konten {
	private int kontoIdNr;
	private double kontoSaldo;
	private double kontoDispo;
	private String kontoInhaber;
	private String kontoNr;

	public static int StartKontoNr = 10000; 
	static DecimalFormatSymbols maske = new DecimalFormatSymbols(Locale.US);
	private static final DecimalFormat df = new DecimalFormat("0.00", maske);
	
	public Konten () { 
		 kontoIdNr = StartKontoNr ++;
	} 
	 
	public int getKontoIdNr() {
		return kontoIdNr;
	}
	
	
	public double getKontoSaldo() {
		return kontoSaldo;
	}
	
	public String getSKontoSaldo() {
		return df.format(getKontoSaldo());
	}

	public void setKontoSaldo(double kontoSaldo) {
		this.kontoSaldo = kontoSaldo;
	}

	public String getKontoInhaber() {
		return kontoInhaber;
	}

	public void setKontoInhaber(String kontoInhaber) {
		this.kontoInhaber = kontoInhaber;
	}
	
	public String getKontoNr() {
		return kontoNr;
	}

	public void setKontoNr(String kontoNr) {
		this.kontoNr = kontoNr;
	}
	
	public double getKontoDispo() {
		return kontoDispo;
	}

	public void setKontoDispo(double kontoDispo) {
		this.kontoDispo = kontoDispo;
	}
	
	public String getSKontoDispo() {
		return df.format(getKontoDispo());
	}
	
	public String getKontoInfo() {
		return "KontoIdNr: " + getKontoIdNr() + " KontoSaldo " + df.format(getKontoSaldo());  
	}
		 
}
