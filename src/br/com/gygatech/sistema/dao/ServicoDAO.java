package br.com.gygatech.sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.gygatech.sistema.model.Servico;

@Repository
public class ServicoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Servico servico) {
		manager.persist(servico);
	}
	
	public void apaga(Servico servico){
		manager.remove(servico);
	}
	
	public Servico consulta(int codigo){
		return manager.find(Servico.class, codigo);
	}
	
	public List<Servico> consultaTodos() {
		Query qr = manager.createQuery("select s from Servico s order by s.descricao");
		List<Servico> retorno = qr.getResultList();
		return retorno;
	}

}
