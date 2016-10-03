package br.com.gygatech.sistema.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.gygatech.sistema.model.Agenda;
import br.com.gygatech.sistema.model.Cliente;

@Repository
public class AgendaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Agenda agenda) {
		manager.persist(agenda);
	}
	
	public void apaga(Agenda agenda) {
		manager.remove(agenda);
	}
	
	public Agenda consulta(int codigo) {
		return manager.find(Agenda.class, codigo);
	}
	
	public List<Agenda> consultaPorCliente(Cliente cliente) {
		Query qr = manager.createQuery("select a from Agenda as a " +
				"where a.cliente = :cliente order by a.data,a.horario");
		qr.setParameter("cliente", cliente);
		List<Agenda> retorno = qr.getResultList();
		return retorno;
	}
	
	public List<Agenda> consultaPorData(Calendar data) {
		Query qr = manager.createQuery("select a from Agenda as a " +
				"where a.data = :data order by a.data,a.horario");
		qr.setParameter("data", data);
		List<Agenda> retorno = qr.getResultList();
		return retorno;
	}
	
	public List<Agenda> consultaTodos() {
		Query qr = manager.createQuery("select a from Agenda a order by a.data,a.horario");
		List<Agenda> retorno = qr.getResultList();
		return retorno;
	}
}
