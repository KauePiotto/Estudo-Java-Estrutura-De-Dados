package ado01;

public class Vetor {

	public Consulta[] consulta;
	public int tamanho;

	public Vetor(int capacidade) {
		this.consulta = new Consulta[capacidade];
		this.tamanho = 0;
	}

	public void MarcarConsulta(Consulta consulta) throws Exception {
		if (this.tamanho < this.consulta.length) {
			this.consulta[this.tamanho] = consulta;
			tamanho++;
		}
	}

	public Consulta BuscarConsulta(int indiceBuscar) throws Exception {
		if (indiceBuscar >= 0 && indiceBuscar < this.tamanho) {
			return consulta[indiceBuscar];
		}
		return null;
	}

	public void AlterarConsulta(int indiceAlterar, Consulta novaConsulta) throws Exception {
		if (indiceAlterar >= 0 && indiceAlterar < tamanho) {
			consulta[indiceAlterar] = novaConsulta;
		}
	}

	public void ExcluirConsulta(int indice) throws Exception {
		if (indice >= 0 && indice < tamanho) {
			for (int i = indice; i < this.tamanho - 1; i++) {
				consulta[i] = consulta[i + 1];
			}
			consulta[tamanho - 1] = null;
			this.tamanho--;
		}
	}

	public int tamanho() {
		return this.tamanho;
	}
}