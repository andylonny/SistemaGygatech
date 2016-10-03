package br.com.gygatech.sistema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gygatech.sistema.dao.PecaDAO;
import br.com.gygatech.sistema.model.Peca;

@Transactional
@Controller
public class ControllerPeca {

	@Autowired
	PecaDAO pecaDao;
	
	@RequestMapping("/cadastrarPecaView")
	public String cadastrarPecaView(HttpSession session){
		if(session.getAttribute("usuarioLogado") != null){
			return "peca/cadastrarPeca";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/alterarPecaView")
	public String alterarPecaView(int codigo, HttpSession session, 
			HttpServletRequest req, HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			Peca peca = pecaDao.consulta(codigo);
			req.setAttribute("peca", peca);
			return "peca/alterarPeca";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/gravarPeca")
	public String gravarPeca(Peca peca, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			pecaDao.adiciona(peca);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarPecas")
	public String consultarPecas(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			List<Peca> lista = pecaDao.consultaTodos();
			req.setAttribute("pecas", lista);
			return "peca/resultadoPeca";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/excluirPeca")
	public String excluirPeca(int codigo, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			Peca peca = pecaDao.consulta(codigo);
			pecaDao.apaga(peca);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/alterarPeca")
	public String alterarPeca(Peca pecaAlterado, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			Peca peca = pecaDao.consulta(pecaAlterado.getCodigo());
			peca.setDescricao(pecaAlterado.getDescricao());
			peca.setValor(pecaAlterado.getValor());
			return "principal";
		}
		return "redirect:index.html";
	}
	
}
