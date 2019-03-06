package Objects;

public class Localizacao {
	int idLocalizacao, ponto;
	String rua, complemento;
	
	public Localizacao() {}
	
	public Localizacao(int idLocalizacao, String rua, String complemento, int ponto) {
		super();
		this.idLocalizacao = idLocalizacao;
		this.rua = rua;
		this.complemento = complemento;
		this.ponto = ponto;
	}
	public int getIdLocalizacao() {
		return idLocalizacao;
	}
	public void setIdLocalizacao(int idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getPonto() {
		return ponto;
	}

	public void setPonto(int ponto) {
		this.ponto = ponto;
	}
	
}
