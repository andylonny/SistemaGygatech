package br.com.gygatech.sistema.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.gygatech.sistema.model.Chamado;
import br.com.gygatech.sistema.model.Cliente;

@Repository
public class ChamadoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Chamado atendimento) {
		manager.persist(atendimento);
	}
	
	public void apaga(Chamado atendimento) {
		manager.remove(atendimento);
	}
	
	public Chamado consulta(int codigo) {
		return manager.find(Chamado.class, codigo);
	}
	
	public List<Chamado> consultaPorCliente(Cliente cliente) {
		Query qr = manager.createQuery("select c from Chamado as c " +
				"where c.cliente = :cliente order by c.data,horario");
		qr.setParameter("cliente", cliente);
		List<Chamado> retorno = qr.getResultList();
		return retorno;
	}
	
	public List<Chamado> consultaPorData(Calendar data) {
		Query qr = manager.createQuery("select c from Chamado as c " +
				"where c.data = :data order by c.data,horario");
		qr.setParameter("data", data);
		List<Chamado> retorno = qr.getResultList();
		return retorno;
	}
	
	public List<Chamado> consultaPorStatus(String status) {
		Query qr = manager.createQuery("select c from Chamado as c " +
				"where c.status = :status order by c.data,horario");
		qr.setParameter("status", status);
		List<Chamado> retorno = qr.getResultList();
		return retorno;
	}
	
	public List<Chamado> consultaTodos() {
		Query qr = manager.createQuery("select c from Chamado c order by c.data,horario");
		List<Chamado> retorno = qr.getResultList();
		return retorno;
	}
	
}
