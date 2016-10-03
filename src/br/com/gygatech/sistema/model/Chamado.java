package br.com.gygatech.sistema.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Chamado {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	@ManyToOne
	private Cliente cliente;
	@ManyToMany(fetch = FetchType.EAGER)
    private List<Servico> servicos;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Peca> pecas;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	private String horario;
	private float valorAtendimento;
	private String status;
	private String informacoes;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
		
}
