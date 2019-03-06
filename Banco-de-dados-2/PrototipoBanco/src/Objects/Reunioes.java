package Objects;

import java.sql.Date;

public class Reunioes {
	int idReunioes;
	String data, horario, localizacao, assunto;
	
	public Reunioes() {}
	
	public Reunioes(int idReunioes, String data, String horario,String localizacao, String assunto) {
		super();
		this.idReunioes = idReunioes;
		this.data = data;
		this.horario = horario;
		this.localizacao = localizacao;
		this.assunto = assunto;
	}
	public int getIdReunioes() {
		return idReunioes;
	}
	public void setIdReunioes(int idReunioes) {
		this.idReunioes = idReunioes;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
}
