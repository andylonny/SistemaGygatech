package br.com.gygatech.sistema.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity 
public class Recibo {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoRecibo;
	@ManyToOne
	private Cliente cliente;
	private String data;
	@ManyToMany
	private List<Chamado> chamados;
	private float valorRecibo;
	private String status;
	
	public int getCodigoRecibo() {
		return codigoRecibo;
	}
	public void setCodigoRecibo(int codigoRecibo) {
		this.codigoRecibo = codigoRecibo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public float getValorRecibo() {
		return valorRecibo;
	}
	public void setValorRecibo(float valorRecibo) {
		this.valorRecibo = valorRecibo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Chamado> getChamados() {
		return chamados;
	}
	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
		
}
