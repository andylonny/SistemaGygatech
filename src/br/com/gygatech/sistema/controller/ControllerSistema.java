package br.com.gygatech.sistema.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gygatech.sistema.dao.UsuarioDAO;
import br.com.gygatech.sistema.model.Usuario;

@Transactional
@Controller
public class ControllerSistema {
	
	final private String salt="Jh3gt4y57sfGtrc22";

	@Autowired
	UsuarioDAO usuarioDao;
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session){
		String senha = gerarSenha(usuario.getSenha()+salt);
		Usuario autorizado = usuarioDao.buscaLogin(usuario.getUserlogin());
		if(autorizado != null){
			if(autorizado.getSenha().equals(senha)){
				session.setAttribute("usuarioLogado", autorizado);
				return "principal";
			}
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		if(session.getAttribute("usuarioLogado") != null){
			session.invalidate();
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/principalView")
	public String principalView(HttpSession session){
		if(session.getAttribute("usuarioLogado") != null){
			return "principal";
		}
		return "redirect:index.html";
	}
	
	private String gerarSenha(String senha){
		String valorParaSenha = senha;
		MessageDigest algorithm;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(valorParaSenha.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			senha = hexString.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return senha;
	}
}
