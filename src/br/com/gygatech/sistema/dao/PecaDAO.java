package br.com.gygatech.sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.gygatech.sistema.model.Peca;

@Repository
public class PecaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Peca peca) {
		manager.persist(peca);
	}
	
	public void apaga(Peca peca){
		manager.remove(peca);
	}
	
	public Peca consulta(int codigo){
		return manager.find(Peca.class, codigo);
	}
	
	public List<Peca> consultaTodos() {
		Query qr = manager.createQuery("select p from Peca p order by p.descricao");
		List<Peca> retorno = qr.getResultList();
		return retorno;
	}
	
}
