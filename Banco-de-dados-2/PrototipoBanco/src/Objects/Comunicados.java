package Objects;

public class Comunicados {
	int idComunicados;
	String nome, comunicado, moradores, horasDispo, descricao;
	
	public Comunicados() {}
	
	public Comunicados(int idComunicados,String nome, String comunicado, String moradores, String horasDispo, String descricao) {
		super();
		this.idComunicados = idComunicados;
		this.nome = nome;
		this.comunicado = comunicado;
		this.moradores = moradores;
		this.horasDispo = horasDispo;
		this.descricao = descricao;
	}
	public int getIdComunicados() {
		return idComunicados;
	}
	public void setIdComunicados(int idComunicados) {
		this.idComunicados = idComunicados;
	}
	public String getHorasDispo() {
		return horasDispo;
	}
	public void setHorasDispo(String horasDispo) {
		this.horasDispo = horasDispo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComunicado() {
		return comunicado;
	}

	public void setComunicado(String comunicado) {
		this.comunicado = comunicado;
	}

	public String getMoradores() {
		return moradores;
	}

	public void setMoradores(String moradores) {
		this.moradores = moradores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
