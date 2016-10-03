package br.com.gygatech.sistema.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.gygatech.sistema.model.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public Usuario buscaLogin(String userLogin){
		
		Query qr = manager.createQuery("select u from Usuario as u "+
          "where u.userlogin = :userlogin");
		qr.setParameter("userlogin", userLogin);
		try{
			Usuario retorno = (Usuario) qr.getSingleResult();
			return retorno;
		}catch(NoResultException e){
			return null;
		}
	}

}
