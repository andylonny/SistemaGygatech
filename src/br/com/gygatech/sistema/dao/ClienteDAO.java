package br.com.gygatech.sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.gygatech.sistema.model.Cliente;

@Repository
public class ClienteDAO {

	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Cliente cliente) {
		manager.persist(cliente);
	}
	
	public void apaga(Cliente cliente) {
		manager.remove(cliente);
	}
	
	public Cliente consulta(int codigo) {
		return manager.find(Cliente.class, codigo);
	}

	public List<Cliente> consultaTodos() {
		Query qr = manager.createQuery("select c from Cliente c order by c.nome");
		List<Cliente> retorno = qr.getResultList();
		return retorno;
	}

	public List<Cliente> consultaPorNome(String nome) {
		Query qr = manager.createQuery("select c from Cliente as c " +
				"where c.nome like :nome");
		qr.setParameter("nome", "%"+nome+"%");
		List<Cliente> retorno = qr.getResultList();
		return retorno;
	}

}
