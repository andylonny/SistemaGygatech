package br.com.gygatech.sistema.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity 
public class NotaFiscal {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoNotaFiscal;
	@ManyToOne
	private Cliente cliente;
	private String data;
	@ManyToMany
	private List<Chamado> chamados;
	private float valorNota;
	private String status;
	
	public int getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}
	public void setCodigoNotaFiscal(int codigoNotaFiscal) {
		this.codigoNotaFiscal = codigoNotaFiscal;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Chamado> getChamados() {
		return chamados;
	}
	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	public float getValorNota() {
		return valorNota;
	}
	public void setValorNota(float valorNota) {
		this.valorNota = valorNota;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
}
