package br.com.gygatech.sistema.model;

import java.util.List;

public class AuxChamado {

	private int codigo;
	private Cliente cliente;
	private List<Servico> servicos;
	private List<Peca> pecas;
	private String data;
	private String horario;
	private float valorAtendimento;
	private String status;
	private String informacoes;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
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
	public float getValorAtendimento() {
		return valorAtendimento;
	}
	public void setValorAtendimento(float valorAtendimento) {
		this.valorAtendimento = valorAtendimento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	
}
