package ado01;

public class Consulta {

	private String data;
	private String hora;
	private String nome;
	private String telefone;

	public Consulta() {

	}

	public Consulta(String data, String hora, String nome, String telefone) {
		this.data = data;
		this.hora = hora;
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Consulta [data=" + data + ", hora=" + hora + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
}