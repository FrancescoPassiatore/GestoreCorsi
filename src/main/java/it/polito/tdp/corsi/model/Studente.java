package it.polito.tdp.corsi.model;

import java.util.Objects;

public class Studente {
	
	private String matricola;
	private String cognome;
	private String nome;
	private String CDS;
	
	public Studente(String matricola, String cognome, String nome, String cDS) {
		
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		CDS = cDS;
	}

	public String getMatricola() {
		return matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCDS() {
		return CDS;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", CDS=" + CDS + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CDS, cognome, matricola, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return Objects.equals(CDS, other.CDS) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(matricola, other.matricola) && Objects.equals(nome, other.nome);
	}
	
	
	

}
